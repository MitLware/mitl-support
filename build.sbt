lazy val root = (project in file(".")).
  settings(
    name := "MitLware-support",
    version := "1.1",
    scalaVersion := "2.12.0"
  )

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.5"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1"
