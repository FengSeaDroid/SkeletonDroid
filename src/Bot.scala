// this is the source code for your bot - have fun!

class ControlFunctionFactory {
  def create = ControlFunction.respond _
}

object ControlFunction {
  def respond(input: String) = {
    val tokens = input.split('(') // split at '(', returns Array[String]
    if (tokens(0) == "React") { // token(0): 0th element of array
      "Move(direction=1:0)" // response if true
    } else {
      "" // response if false
    }
  }
}