package Prog

import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {

  @tailrec
  def inputFunc(line: String): ((Double, Double) => Double, (Double, Double)) = {
    line.trim.toLowerCase match {
      case "1" | "a" => (first,(1, -1))
      case "2" | "b" => (second,(0, 0))
      case "3" | "c" => (third,(-1, 1/ (2 * Math.exp(1))))
      case "exit" | "no" | "n" | "учше" =>
        print("Хорошего Вам дня!")
        System.exit(0)
        (first,(1, -1)) // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Давай по новой, Миша все х*йня")
        inputFunc(StdIn.readLine())
    }
  }
  private def first(x: Double, y: Double): Double = y + (1 + x) * Math.pow(y, 2)
  private def second(x: Double, y: Double): Double = Math.pow(x-y, 2) + 1
  private def third(x: Double, y: Double): Double = x * Math.exp(-Math.pow(x, 2)) - 2 * x * y

  @tailrec
  def inputData(string: String): Double = {
    try {
      string.trim.replaceAll(",", ".").toDouble
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        inputData(StdIn.readLine())
    }
  }
}
