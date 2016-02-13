package fpinscala.datastructures

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {
  def size[A](t: Tree[A]): Int = 
   t match {
      case Leaf(value) => 1
      case Branch(left: Tree[A],right: Tree[A]) => 1 + size(left) + size(right)
    }
  
  def maximum(t: Tree[Int]): Int = t match{
    case Leaf(value) => value
    case Branch(left, right) => maximum(left).max(maximum(right))
  }
  



}