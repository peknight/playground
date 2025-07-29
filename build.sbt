ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.1"

ThisBuild / organization := "com.peknight"

ThisBuild / versionScheme := Some("early-semver")

ThisBuild / publishTo := {
  val nexus = "https://nexus.peknight.com/repository"
  if (isSnapshot.value)
    Some("snapshot" at s"$nexus/maven-snapshots/")
  else
    Some("releases" at s"$nexus/maven-releases/")
}

ThisBuild / credentials ++= Seq(
  Credentials(Path.userHome / ".sbt" / ".credentials")
)

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xfatal-warnings",
    "-language:strictEquality",
    "-Xmax-inlines:64"
  )
)

lazy val playground = (project in file("."))
  .aggregate(
    playgroundCore.jvm,
    playgroundCore.js,
  )
  .settings(commonSettings)
  .settings(
    name := "playground",
  )

lazy val playgroundCore = (crossProject(JSPlatform, JVMPlatform) in file("playground-core"))
  .settings(commonSettings)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "playground-core",
    dockerBaseImage := "eclipse-temurin:21",
    Docker / packageName := "pek/playground-app",
    Docker / maintainer := "peknight <JKpeknight@gmail.com>",
    dockerRepository := Some("docker.peknight.com"),
    dockerBuildOptions ++= Seq(
      "--platform", "linux/amd64"
    ),
    libraryDependencies ++= Seq(
    )
  )
