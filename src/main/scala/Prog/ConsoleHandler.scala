package Prog

import java.lang.Math.{exp, pow}
import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {

  def inputData(): Equation = {
    println("Выберите функицю:")
    val temp = inputFunc(StdIn.readLine())
    println("Введите правую границы:")
    val end = inputData(StdIn.readLine())
    println("Введите шаг")
    val step = inputData(StdIn.readLine())
    Equation(temp._1, temp._2, end, step, temp._3)
  }

  @tailrec
  private def inputFunc(line: String): ((Double, Double) => Double, (Double, Double), Double => Double) = {
    line.trim.toLowerCase match {
      case "1" | "a" => (first,(1, -1), trueFirst)
      case "2" | "b" => (second,(0, 0), trueSecond)
      case "3" | "c" => (third,(-1, 1/ (2 * Math.exp(1))), trueThird)

      case "exit" | "no" | "n" | "учше" =>
        print("Хорошего Вам дня!")
        System.exit(0)
        (first,(1, -1), trueFirst) // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Давай по новой, Миша все х*йня")
        inputFunc(StdIn.readLine())
    }
  }


  private def first(x: Double, y: Double): Double = y + (1 + x) * pow(y, 2)
  private def second(x: Double, y: Double): Double = pow(x-y, 2) + 1
  private def third(x: Double, y: Double): Double = x * exp(-pow(x, 2)) - 2 * x * y

  private def trueFirst(x: Double): Double = -1 / x
  private def trueSecond(x: Double): Double = x
  private def trueThird(x: Double): Double = pow(x, 2) / 2 * exp(-pow(x, 2))

  @tailrec
  private def inputData(string: String): Double = {
    try {
      string.trim.replaceAll(",", ".").toDouble
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        inputData(StdIn.readLine())
    }
  }
}
