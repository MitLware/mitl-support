lazy val root = (project in file(".")).
  settings(
    name := "metaxa",
    version := "1.0",
    scalaVersion := "2.11.8"
  )

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.5"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1"
