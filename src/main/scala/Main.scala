import scala.io.Source

object Main extends App {
  val fileName = "instructions.txt"
  val lines = Source.fromFile(fileName).getLines().toSeq

  val result = "result"

  val instructions = lines.map {
    case line if line.startsWith("0") => {
      val Array(x) = line.split("\\s+")
      State(x.toInt)
    }
    case line if line.startsWith("+") => {
      val Array(symbol, x) = line.split("\\s+")
      Sum(symbol.charAt(0), x.toInt)
    }
    case line if line.startsWith("-") => {
      val Array(symbol, x) = line.split("\\s+")
      Minus(symbol.charAt(0), x.toInt)
    }
    case line if line.startsWith("*") => {
      val Array(symbol, x) = line.split("\\s+")
      Multiply(symbol.charAt(0), x.toInt)
    }
    case line if line.startsWith("/") => {
      val Array(symbol, x) = line.split("\\s+")
      Divide(symbol.charAt(0), x.toInt)
    }
    case _ => true
  }

  val state: State = instructions.head match {
    case s: State => s
  }
}
