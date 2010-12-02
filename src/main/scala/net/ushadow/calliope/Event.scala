package net.ushadow.calliope

trait Event {

  def kind: String

  def apply[T](name: String): Option[Object] = {
    if (hasProperty(name)) {
      Some(getProperty(name))
    } else {
      None
    }
  }

  def properties: Map[String, Object]
  
  protected def hasProperty(name: String): Boolean = properties.contains(name)
  protected def getProperty(name: String): Object = properties(name)

}