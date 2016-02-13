package fpinscala.datastructures

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {
  //3.25
  def size[A](t: Tree[A]): Int =  t match {
      case Leaf(value) => 1
      case Branch(left: Tree[A],right: Tree[A]) => 1 + size(left) + size(right)
    }
  
  //3.26
  def maximum(t: Tree[Int]): Int = t match{
    case Leaf(value) => value
    case Branch(left, right) => maximum(left).max(maximum(right))
  }
  
  //3.27
  def depth[A](t: Tree[A]): Int = t  match {
     case Leaf(value) => 1
     case Branch(left: Tree[A],right: Tree[A]) => 1 + (depth(left) max depth(right))
  }
  
  //3.28
  def map[A,B](t: Tree[A])( f:  A => B):Tree[B] = t match {
    case Leaf(value) => Leaf(f(value))
    case Branch(left: Tree[A], right: Tree[A]) => Branch(map(left)(f),  map(right)(f))
  }

  //3.29
  //used the hint that gave me the function definition
  def fold[A,B](t: Tree[A])(leafFunc: A => B)(f: (B,B) => B): B = t match {
    case Leaf(value) => leafFunc(value)
    case Branch(left: Tree[A], right: Tree[A]) => f(fold(left)(leafFunc)(f), fold(right)(leafFunc)(f))
  }
  //probably could write these a bit more legibly with shorter variable names and utilizing type inference more
  def foldSize[A](t: Tree[A]): Int =  fold(t)((x:A)=> 1)((left:Int,right:Int)=> 1+ left+right)
  def foldMaximum(t: Tree[Int]): Int = fold(t)((x:Int)=>x)((x,y)=>x max y)
  def foldDepth[A](t: Tree[A]): Int = fold(t)((x:A)=>1)((left:Int, right:Int) => 1+ ( left max right))
  def foldMap[A,B](t: Tree[A])( f:  A => B):Tree[B] = fold(t)((x: A) => Leaf(f(x)): Tree[B])((left, right) => Branch(left, right))


}