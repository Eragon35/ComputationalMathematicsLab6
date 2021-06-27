package Prog

case class Equation(func: (Double, Double) => Double, start: (Double, Double),
                    end: Double, solution: Double => Double, accuracy: Double) { }
