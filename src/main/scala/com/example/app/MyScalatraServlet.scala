package com.example.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends ScalatraServlet with ScalateSupport {
  
  get("/") {
  contentType="text/html"

  jade("/index")
}

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
}
