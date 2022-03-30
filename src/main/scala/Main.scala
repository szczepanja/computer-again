import scala.io.Source

case class Sum(symbol: Char, x: Int)

case class Minus(x: Int)

case class Multiply(x: Int)

case class Divide(x: Int)

object Main extends App {
  val fileName = "instructions.txt"
  val lines = Source.fromFile(fileName).getLines().toSeq

  lines.map {
    case line if line.startsWith("+") => {
      val Array(symbol, x) = line.split("\\s+")
      Sum(symbol.charAt(0), x.toInt)
    }
    case _ => true
  }.foreach(println)
}
