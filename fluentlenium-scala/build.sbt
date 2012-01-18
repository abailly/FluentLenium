name := "hello"

version := "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "1.6.1",
                           "org.fluentlenium" % "fluentlenium-core" % "0.5.5-SNAPSHOT")

resolvers += "Local repo" at "file:///home/arnaud/projects/repository"
