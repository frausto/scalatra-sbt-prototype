libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.10"))

libraryDependencies += "org.neo4j" % "neo4j" % "1.6.1"

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0")

resolvers += "spray repo" at "http://repo.spray.cc"

addSbtPlugin("cc.spray" % "sbt-revolver" % "0.6.0")