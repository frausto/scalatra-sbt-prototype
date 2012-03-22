package com.example.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends ScalatraServlet with ScalateSupport {
  
  before(){
    contentType = "text/html"
  }
  
  get("/") {
    jade("/index")
  }
  
  post("/new_user"){
    "yo yo " + params("user")
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
}
