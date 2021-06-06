package Prog

import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {
  private var left: Double = 0.0
  private var right: Double = 0.0
  @tailrec
  def inputHandler(line: String): IndexedSeq[(Double, Double)] = {
    line.trim.toLowerCase match {
      case "1" | "a" => left = data(0)._1
        right = data(data.size - 1)._1
        data
      case "2" | "b" => chooseRange(second)
      case "3" | "c" => chooseRange(third)
      case "4" | "d" => chooseRange(forth)
      case "exit" | "no" | "n" | "учше" =>
        print("Хорошего Вам дня!")
        System.exit(0)
        IndexedSeq[(Double, Double)]() // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Давай по новой, Миша все х*йня")
        inputHandler(StdIn.readLine())
    }
  }

  private def second(x: Double): Double = x - 2
  private def third(x: Double): Double = Math.cos(x)
  private def forth(x: Double): Double = 1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95

  @tailrec
  private def chooseRange(func: Double => Double): (Double, Double) = {
    println("Выберите диапазон для генерации точек функцией")
    try {
      val line = StdIn.readLine().trim.replaceAll(",", ".").split(" ").map(x => x.toDouble)
      left = line(0)
      right = line(1)
      (left, right)
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        chooseRange(func)
    }
  }

  @tailrec
  def inputStepHandler(line: String): Double = {
    try {
      line.trim.replaceAll(",", ".").toDouble
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        inputStepHandler(StdIn.readLine())
    }
  }

  @tailrec
  def inputAccuracyHandler(line: String): Double = {
    try {
      line.trim.replaceAll(",", ".").toDouble
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        inputAccuracyHandler(StdIn.readLine())
    }
  }
}
