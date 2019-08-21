package traits

sealed trait Tree[+A]
case class Leaf[A] (value: A) extends Tree[A]
case class Branch[A] (left: Tree[A], right: Tree[A]) extends Tree[A]

class BST {


}

class MyTree {

  def demo()={

    val l1 = new Leaf[Int](100)
    val l2 = new Leaf[Int](200)

    val leftBranch = new Branch[Int](l1, l2)

    val l3 = new Leaf[Int](300)
    val l4 = new Leaf[Int](400)

    val rightBranch = new Branch[Int](l3, l4)

    val tree = new Branch(leftBranch, rightBranch)

    println(tree)
  }

}

object TreeTest{
  def main(args: Array[String]): Unit = {
    val t = new MyTree
    t.demo()
  }
}