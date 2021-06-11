package Prog

import scala.io.StdIn

object Main extends App {
  var x: Double = 0.0
  println(
    """ Вариант №2
      | y' = y + (1 + x) * y^2; y(1) = -1
      | y' = (x-y)^2 + 1; y(0) = 0
      | y' = xe^(-x)^2 - 2 * xy; y(-1) = 1 / 2e""".stripMargin)
  // Одношаговые методы - Усовершенствованный метод Эйлера
  // Многошаговые методы - Милна
  while (true) {
    val tmp = ConsoleHandler.inputFunc(StdIn.readLine())
    val func = tmp._1
    val start = tmp._2
    println("Введите правую границы:")
    val b = ConsoleHandler.inputData(StdIn.readLine())
    println("Введите шаг")
    val step = ConsoleHandler.inputData(StdIn.readLine())
    UpgradedEuler.solve(func, start, b, step)
    Milnes.solve(func, start, b, step)
  }

  //chose function
  //chose x0 & y0?
}
