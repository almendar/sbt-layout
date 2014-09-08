sbtPlugin := true

organization := "pl.tmkk"

name := "sbt-layout"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
)

publishMavenStyle := false

