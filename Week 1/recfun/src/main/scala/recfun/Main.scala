package recfun

object Main {

  def main(args: Array[String]) {
    test(x => x*10)
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (_ <- 1 to (10-row)/2) yield print("   ")
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def test(f: Int => Int) = println("hi" + f(1))

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == 0 && r == 0) 1
      else if (c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def aux(chrs: List[Char], openCount: Int, closeCount: Int): Boolean = {
        if (chrs.isEmpty) true
        else if (chrs.head == ')') {
          if (closeCount >= openCount) false
          else aux(chrs.tail, openCount, closeCount+1)
        }
        else if (chrs.head == '(') {
          aux(chrs.tail, openCount+1, closeCount)
        }
        else aux(chrs.tail, openCount, closeCount)
      }
      aux(chars, 0, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty || money < 0) 0
      else if (money == 0) 1
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
}
