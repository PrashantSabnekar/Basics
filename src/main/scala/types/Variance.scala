package types

class A
class B extends A
class C extends B

class Covariance[+A]
class Contravariance[-B]
class Invariance[A]

class Variance {

  def testCovariance(x: Covariance[A])={
    println(x.getClass)
  }

  def test2(x: Contravariance[B]) = {
    println(x.getClass)
  }

  def testInvariance(x: Invariance[A]) = {
    println(x.getClass)
  }



}

object Test extends App {
  val o = new Variance

  val x = new Covariance[B]
  val y = new Covariance[A]

  val x1 = new Contravariance[C]
  val x2 = new Contravariance[B]
  val x3 = new Contravariance[A]

  val y1 = new Invariance[A]
  val y2 = new Invariance[B]
  val y3 = new Invariance[C]

  o.testCovariance(x)
  o.testCovariance(y)

  o.test2(x2)
  o.test2(x3)

  o.testInvariance(y1)
}