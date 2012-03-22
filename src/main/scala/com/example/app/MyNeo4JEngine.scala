package com.example.app

import scala.collection.JavaConversions.iterableAsScalaIterable

import org.neo4j.graphdb.DynamicRelationshipType
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.Transaction
import org.neo4j.kernel.EmbeddedGraphDatabase

class MyNeo4JEngine {
  val neo: GraphDatabaseService = new EmbeddedGraphDatabase("var/graphdb")

  implicit def string2relationshipType(x: String) = DynamicRelationshipType.withName(x)

  def nodeCount() : Iterable[Node] ={
    neo.getAllNodes()
  }
  
  def shutdown() = {
    neo.shutdown()
  }
  

//  def searchData() = {
//    var tx = neo.beginTx()
//
//    try {
//      val trav: Traverser = first.traverse(Traverser.Order.BREADTH_FIRST,
//        StopEvaluator.END_OF_GRAPH,
//        ReturnableEvaluator.ALL,
//        "isRelatedTo",
//        Direction.BOTH)
//
//      for (node <- trav) {
//        println(node.getProperty("name"))
//      }
//      tx.success()
//    } finally {
//      tx.finish()
//      println("finished transaction 2")
//    }
//  }
}