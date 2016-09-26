package recfun

/**
  * Created by Mansour Ahmed on 25/09/16.
  */
class Calculator(brand: String) {
  val color: String =
    if (brand == "HP") {
      "blue"
    } else {
      "black"
    }

  def add(m: Int, n: Int): Int = m + n
}

object Script {
  def main(args: Array[String]): Unit = {
    val calc = new Calculator("HP")
    println(calc.color)
    println(calc.add(1,2))
  }
}