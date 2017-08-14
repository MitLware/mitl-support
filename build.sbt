name := "mitl-support"

version := "0.1.0"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:existentials", "-language:higherKinds")    

javacOptions in doc ++= Seq("-source", "1.5")

publishArtifact in (Compile, packageDoc) := false

publishMavenStyle := true

sources in (Compile,doc) := Seq.empty

scalaVersion := "2.12.0"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.5"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
