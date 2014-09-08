//val root = (project in file(".")).enablePlugins(SbtLayout)

otherDirs in createStdDirs ++= Seq(
	baseDirectory.value / "hello",
    baseDirectory.value / "hello1"
)
