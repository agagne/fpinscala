package fpinscala.errorhandling


import scala.{Option => _, Some => _, Either => _, _} // hide std library `Option`, `Some` and `Either`, since we are writing our own in this chapter

sealed trait Option[+A] {
  //4.1
  def map[B](f: A => B): Option[B] = this match{
    case None => None
    case Some(ob) => Some(f(ob))
  }

  //4.1
  def getOrElse[B>:A](default: => B): B = this match {
    case None => default
    case Some(ob) => ob
  }

  //4.1
  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(ob) => f(ob)
  }

  //4.1
  def orElse[B>:A](ob: => Option[B]): Option[B] = this match {
    case None => ob 
    case _ => this
  }

  //4.1
  def filter(f: A => Boolean): Option[A] = this match {
    case None => None
    case Some(ob) =>{
      if(f(ob)) this 
      else None
    }
     
  }
}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

object Option {
  def failingFn(i: Int): Int = {
    val y: Int = throw new Exception("fail!") // `val y: Int = ...` declares `y` as having type `Int`, and sets it equal to the right hand side of the `=`.
    try {
      val x = 42 + 5
      x + y
    }
    catch { case e: Exception => 43 } // A `catch` block is just a pattern matching block like the ones we've seen. `case e: Exception` is a pattern that matches any `Exception`, and it binds this value to the identifier `e`. The match returns the value 43.
  }

  def failingFn2(i: Int): Int = {
    try {
      val x = 42 + 5
      x + ((throw new Exception("fail!")): Int) // A thrown Exception can be given any type; here we're annotating it with the type `Int`
    }
    catch { case e: Exception => 43 }
  }

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  //4.2
  //had to look up the answer on this one
  def variance(xs: Seq[Double]): Option[Double] = {
      // where m is mean , math.power(x-m,2) for each m in the sequence
      mean(xs).flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
  }
 //4.3
  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = a.flatMap { x => b.map{ y=> f(x,y)} }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = sys.error("todo")

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = sys.error("todo")
}