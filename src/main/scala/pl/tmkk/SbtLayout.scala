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

object SbtLayout extends AutoPlugin {
	object autoImport {
    //val rssList = settingKey[Seq[String]]("The list of RSS urls to update.")
    val createStdDirs = taskKey[Seq[File]]("Create standard repos")
    val otherDirs = settingKey[Seq[File]]("Other dirs")
  }

  // If you change your auto import then the change is automatically reflected here..
  import autoImport._

  override def projectSettings: Seq[Setting[_]] = Seq(
    create,others
  )

  override def trigger = allRequirements


  def others :Setting[_] = otherDirs in createStdDirs := Seq.empty

  def create: Setting[_] = createStdDirs := {
  	val s: TaskStreams = streams.value
	val src = sourceDirectory.value;
	val dirs =for{
		i <- Seq("main","test");
		j <- Seq("scala","java","resources")
	} yield (src / i / j);
	val missingDirs = (
			dirs ++ 
			(otherDirs in createStdDirs).value
		).filter(!_.exists)
	missingDirs.foreach(_.mkdirs)
	if(!missingDirs.isEmpty)
		s.log.info(s"""Created: ${missingDirs.mkString(",")}""")
	missingDirs
  }
}