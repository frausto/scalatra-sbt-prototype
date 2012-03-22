import sbt._
import Keys._

import org.neo4j.graphdb.DynamicRelationshipType
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.Transaction
import org.neo4j.kernel.EmbeddedGraphDatabase

object SeedBuild extends Build {
  implicit def string2relationshipType(x: String) = DynamicRelationshipType.withName(x)

  val hwsettings = Defaults.defaultSettings
  val seed = TaskKey[Unit]("seed", "Seeds Neo4J data")
  val unseed = TaskKey[Unit]("unseed", "Remove Neo4J data")

  val seedTask = seed := {
    val neo: GraphDatabaseService = new EmbeddedGraphDatabase("var/graphdb")
    var first: Node = null
    var second: Node = null

    var tx: Transaction = neo.beginTx()

    try {
      first = neo.getReferenceNode()
      first.setProperty("name", "first")

      second = neo.createNode()
      second.setProperty("name", "second")

      first.createRelationshipTo(second, "isRelatedTo")

      tx.success()
    } finally {
      println("finished transaction 1")
      tx.finish()
      neo.shutdown
    }
  }

  val unseedTask = unseed := {
    var d: File = new File("var/graphdb")
    d.listFiles.foreach { f => f.delete }
    d.delete
  }

  lazy val project = Project(
    "project",
    file("."),
    settings = hwsettings ++ Seq(seedTask, unseedTask))
}