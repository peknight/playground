ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.0"

ThisBuild / organization := "com.peknight"

ThisBuild / versionScheme := Some("early-semver")

ThisBuild / publishTo := {
  val nexus = "https://nexus.peknight.com:8443/repository"
  if (isSnapshot.value)
    Some("snapshot" at s"$nexus/maven-snapshots/")
  else
    Some("releases" at s"$nexus/maven-releases/")
}

ThisBuild / credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

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
  .settings(
    name := "playground-core",
    libraryDependencies ++= Seq(
    )
  )
