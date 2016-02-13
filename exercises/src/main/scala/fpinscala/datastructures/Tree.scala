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
  
  



}