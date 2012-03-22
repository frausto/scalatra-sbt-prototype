package com.example.app

import scala.collection.JavaConversions.iterableAsScalaIterable

import org.neo4j.graphdb.Node
import org.specs2.mutable.Specification

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html 
class MyNeo4JSpec extends Specification {
  "The Embedded Neo4J" should {
    "be runnable in Scala" in {
      var engine = new MyNeo4JEngine()
      var count = 0
      try {
        var nodes: Iterable[Node] = null
        nodes = engine.nodeCount()
        nodes.foreach(n => {
          count = count + 1
          if (n.hasProperty("name")) {
            println(n.getProperty("name"))
          }
          printPropertyKeys(n.getPropertyKeys())
        })
      } finally {
        engine.shutdown()
      }
      count must_== 2
    }
  }

  def printPropertyKeys(keys: Iterable[String]) = {
    keys.foreach(k => println(k))
  }
}