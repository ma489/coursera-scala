package recfun

/**
  * Created by Mansour Ahmed on 25/09/16.
  */
trait ListTrait[T] {
  def isEmpty: Boolean
  def head: T
  def tail: ListTrait[T]
}

class Nil[T] extends ListTrait[T] {
  override def isEmpty: Boolean = true

  override def tail: ListTrait[T] = throw new NoSuchElementException

  override def head: T = throw new NoSuchElementException

  override def toString = "●"
}

class Cons[T](val x: T, val xs: ListTrait[T]) extends ListTrait[T] {
  override def isEmpty: Boolean = false

  override def tail: ListTrait[T] = xs

  override def head: T = x

  override def toString = "[" + head.toString + ", " + tail.toString + "]"
}

object MyListFunc {
  def apply[T](x: T, y: T) = new Cons(x, new Cons(y, new Nil))
  def apply[T](x: T) = new Cons(x, new Nil)
  def apply() = new Nil
}

object MyList {
  val list = new Nil[Int]
  val list2 = new Cons[Int](1, list)
  def singleton[T](elem: T) = new Cons[T](elem, new Nil)
  def nth[T](n: Int, list: ListTrait[T]) = {
    var i = 0
    var tal = list
    while (i < n && !tal.isEmpty)
      tal = tal.tail
      i += 1
    tal.head
  }

  def main(args: Array[String]) = {
    val x: (Int, Int, Int) = (1,2,3)
    println("Empty? " + list.isEmpty)
    println(list2)
    println(list2.head)
    println(list2.isEmpty)
    println(singleton(1: Double))
    println(singleton(1))
    println(MyListFunc(1, 2))
    println(MyListFunc(1))
    println(MyListFunc())
//    println(nth(0, singleton(1)))
//    println(nth(1, singleton(1)))
  }
}
