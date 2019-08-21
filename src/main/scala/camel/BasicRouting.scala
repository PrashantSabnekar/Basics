package camel

import org.apache.camel.CamelContext
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.impl.DefaultCamelContext

class BasicRouting {

  def fileRoute()= {
    val context: CamelContext = new DefaultCamelContext()
    try {
      context.addRoutes(new RouteBuilder {
        override def configure(): Unit = {
          from("file:C:/Prashant/Learning/camel/input?noop=true").to("file:C:/Prashant/Learning/camel/output")
        }
      })

      context.start()
      Thread.sleep(10000)
      context.stop()
    } catch {
      case e:Exception => print(e.getMessage)
                          e.printStackTrace()
    }
  }

}

object BasicRouting extends App {

  val route = new BasicRouting
  route.fileRoute()

}
