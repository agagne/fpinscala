package fpinscala.datastructures
import List._
object excercise {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
    val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }                                               //> x  : Int = 3
  
  val y = List(1,2,3,4,5)                         //> y  : fpinscala.datastructures.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Cons(5
                                                  //| ,Nil)))))
  val z = List.tail(y)                            //> z  : fpinscala.datastructures.List[Int] = Cons(2,Cons(3,Cons(4,Cons(5,Nil)))
                                                  //| )
  List.setHead(y,6)                               //> res0: fpinscala.datastructures.List[Int] = Cons(6,Cons(2,Cons(3,Cons(4,Cons(
                                                  //| 5,Nil)))))
  List.drop(y,2)                                  //> res1: fpinscala.datastructures.List[Int] = Cons(3,Cons(4,Cons(5,Nil)))
  List.drop(y,4)                                  //> res2: fpinscala.datastructures.List[Int] = Cons(5,Nil)
 // List.drop(List(),1)
 
  List.dropWhile(y,(x:Int) => x <= 3)             //> res3: fpinscala.datastructures.List[Int] = Cons(4,Cons(5,Nil))
  
  List.init(y)                                    //> res4: fpinscala.datastructures.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Nil))
                                                  //| ))
                                                  
  List.foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
                                                  //> res5: fpinscala.datastructures.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
  List.length(y)                                  //> res6: Int = 5
  List.foldLeft(y,0)((b,a) => b+a)                //> res7: Int = 15
  List.sumFoldLeft(y)                             //> res8: Int = 15
  List.productFoldLeft(y)                         //> res9: Int = 120
  List.lengthFoldLeft(y)                          //> res10: Int = 5
  List.reverse(y)                                 //> res11: fpinscala.datastructures.List[Int] = Cons(5,Cons(4,Cons(3,Cons(2,Cons
                                                  //| (1,Nil)))))
  
 List.appendFoldRight(y, y)                       //> res12: fpinscala.datastructures.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Cons
                                                  //| (5,Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Nil))))))))))
 
 val listOfList = List(List(1,2),List(3,4),List(5,6))
                                                  //> listOfList  : fpinscala.datastructures.List[fpinscala.datastructures.List[In
                                                  //| t]] = Cons(Cons(1,Cons(2,Nil)),Cons(Cons(3,Cons(4,Nil)),Cons(Cons(5,Cons(6,N
                                                  //| il)),Nil)))
 List.concat(listOfList)                          //> res13: fpinscala.datastructures.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Cons
                                                  //| (5,Cons(6,Nil))))))
 
 List.addOne(y)                                   //> res14: fpinscala.datastructures.List[Int] = Cons(2,Cons(3,Cons(4,Cons(5,Cons
                                                  //| (6,Nil)))))
 val doubles = List(1.0,2.1,3.2,4.3)              //> doubles  : fpinscala.datastructures.List[Double] = Cons(1.0,Cons(2.1,Cons(3.
                                                  //| 2,Cons(4.3,Nil))))
 List.doubleToString(doubles)                     //> res15: fpinscala.datastructures.List[String] = Cons(1.0,Cons(2.1,Cons(3.2,Co
                                                  //| ns(4.3,Nil))))
                                                  
 List.map(y)(_+1)                                 //> res16: fpinscala.datastructures.List[Int] = Cons(2,Cons(3,Cons(4,Cons(5,Con
                                                  //| s(6,Nil)))))
 
                                                  
 List.flatMap(List(1,2,3))(i => List(i,i))        //> res17: fpinscala.datastructures.List[Int] = Cons(1,Cons(1,Cons(2,Cons(2,Con
                                                  //| s(3,Cons(3,Nil))))))
 
 def isOdd(i: Int):Boolean = (i %2 == 0)          //> isOdd: (i: Int)Boolean
 List.filter(y)(isOdd)                            //> res18: fpinscala.datastructures.List[Int] = Cons(2,Cons(4,Nil))
 
 List.filterFlatMap(y)(isOdd)                     //> res19: fpinscala.datastructures.List[Int] = Cons(2,Cons(4,Nil))
 
 List.addLists(y, y)                              //> res20: fpinscala.datastructures.List[Int] = Cons(2,Cons(4,Cons(6,Cons(8,Con
                                                  //| s(10,Nil)))))
 
 
 List.zipWith(y, y)(_+_)                          //> res21: fpinscala.datastructures.List[Int] = Cons(2,Cons(4,Cons(6,Cons(8,Con
                                                  //| s(10,Nil)))))
 val leaf = Leaf(4)                               //> leaf  : fpinscala.datastructures.Leaf[Int] = Leaf(4)
 val tree = Branch(leaf,Branch(leaf,Branch(leaf,leaf)))
                                                  //> tree  : fpinscala.datastructures.Branch[Int] = Branch(Leaf(4),Branch(Leaf(4
                                                  //| ),Branch(Leaf(4),Leaf(4))))
 val tree2 = Branch(leaf,Branch(Leaf(1),Branch(Leaf(5),Leaf(8))))
                                                  //> tree2  : fpinscala.datastructures.Branch[Int] = Branch(Leaf(4),Branch(Leaf(
                                                  //| 1),Branch(Leaf(5),Leaf(8))))
 val tree3 = Branch(Branch(leaf,leaf),Branch(Leaf(1),Branch(Leaf(5),Branch(leaf,leaf))))
                                                  //> tree3  : fpinscala.datastructures.Branch[Int] = Branch(Branch(Leaf(4),Leaf(
                                                  //| 4)),Branch(Leaf(1),Branch(Leaf(5),Branch(Leaf(4),Leaf(4)))))
 Tree.size(leaf)                                  //> res22: Int = 1
 Tree.foldSize(leaf)                              //> res23: Int = 1
 
 Tree.size(tree)                                  //> res24: Int = 7
 Tree.foldSize(tree)                              //> res25: Int = 7
 
 Tree.maximum(leaf)                               //> res26: Int = 4
 Tree.foldMaximum(leaf)                           //> res27: Int = 4
 Tree.maximum(tree)                               //> res28: Int = 4
 Tree.foldMaximum(tree)                           //> res29: Int = 4
 Tree.maximum(tree2)                              //> res30: Int = 8
 Tree.foldMaximum(tree2)                          //> res31: Int = 8
 
 Tree.depth(leaf)                                 //> res32: Int = 1
 Tree.foldDepth(leaf)                             //> res33: Int = 1
 Tree.depth(tree)                                 //> res34: Int = 4
 Tree.foldDepth(tree)                             //> res35: Int = 4
 Tree.depth(tree2)                                //> res36: Int = 4
 Tree.foldDepth(tree2)                            //> res37: Int = 4
 Tree.depth(tree3)                                //> res38: Int = 5
 Tree.foldDepth(tree3)                            //> res39: Int = 5
 
 def addOne = (x:Int)=>x+1                        //> addOne: => Int => Int
 Tree.map(leaf)(addOne)                           //> res40: fpinscala.datastructures.Tree[Int] = Leaf(5)
 Tree.foldMap(leaf)(addOne)                       //> res41: fpinscala.datastructures.Tree[Int] = Leaf(5)
 Tree.map(tree3)(addOne)                          //> res42: fpinscala.datastructures.Tree[Int] = Branch(Branch(Leaf(5),Leaf(5)),
                                                  //| Branch(Leaf(2),Branch(Leaf(6),Branch(Leaf(5),Leaf(5)))))
 Tree.foldMap(tree3)(addOne)                      //> res43: fpinscala.datastructures.Tree[Int] = Branch(Branch(Leaf(5),Leaf(5)),
                                                  //| Branch(Leaf(2),Branch(Leaf(6),Branch(Leaf(5),Leaf(5)))))
}