
case class Color(r:Double, g:Double, b:Double)

var red = Color(255,0,0)
var white = Color(255,255,255)

object Stitch extends Enumeration {
  val Brick, Square, Fringe = Value
}

case class Bead(x:Double, y:Double, beadStitch:Stitch.Value) {
  var beadColor: Color = white

  def isFilled: Boolean = beadColor != white

  def fill(color: Color): Unit = beadColor = color

  def changeStitch(newStitch: Stitch.Value): Bead = copy(x, y, newStitch)

  def addBeadRight: Bead = {
    if (!beadStitch.equals(Stitch.Fringe)) {
      return Bead(x + 1, y, beadStitch)
    }
    None.get
  }

  def addBeadLeft: Bead = {
    if (!beadStitch.equals(Stitch.Fringe)) {return Bead(x-1, y, beadStitch)}
    None.get
  }


}

var bead1 = new Bead(0, 0, Stitch.Square)
bead1.isFilled
bead1.x
bead1.y
bead1.fill(red)
bead1.isFilled
bead1.beadColor
bead1.beadStitch
//bead1 = bead1.changeStitch(Stitch.Brick)
bead1.beadStitch
var bead2 = bead1.addBeadRight
bead2.fill(red)
var bead3 = bead1.addBeadLeft
bead1.addBeadRight.addBeadLeft

