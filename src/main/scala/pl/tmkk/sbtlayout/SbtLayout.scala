package pl.tmkk.sbtlayout
import sbt._
import Keys._
/***
lazy val hello = taskKey[Unit]("Prints 'Hello world'")

hello := { println("hello world!") }

lazy val intTask = taskKey[Int]("Returns some Int")

lazy val createStdDirs = taskKey[Seq[File]]("Create standard repos")

lazy val stringTask = taskKey[String]("Return some String")

intTask := 1+2

stringTask := "Tomek" + intTask.value

lazy val createStdDirsImpl = 
Def.task { 
	val s: TaskStreams = streams.value
	val src = sourceDirectory.value;
	val dirs =for{
		i <- Seq("main","test");
		j <- Seq("scala","java","resources")
	} yield (src / i / j);
	val missingDirs = dirs.filter(!_.exists)
	missingDirs.foreach(_.mkdirs)
	if(!missingDirs.isEmpty)
		s.log.info(s"""Created: ${missingDirs.mkString(",")}""")
	missingDirs
}

createStdDirs := createStdDirsImpl.value

*/