sbt-layout
==========

Generates standard directories for your project so you don't have to!


How to install:

* Clone this repo.
* Call 'publishLocal' in sbt on this project.
* addSbtPlugin("pl.tmkk" %% "sbt-layout" % "1.0.0-SNAPSHOT") or event better add this to your global list of plugins.

If you need more dirs add this to your build.sbt:

otherDirs in createStdDirs ++= Seq(
	baseDirectory.value / "foo",
    	baseDirectory.value / "bar"
)

it will create for you std layout of dirs and two additional dirs: foo and bar.

