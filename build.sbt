com.peknight.build.sbt.commonSettings

lazy val playground = (project in file("."))
  .aggregate(
    playgroundCore.jvm,
    playgroundCore.js,
  )
  .settings(
    name := "playground",
  )

lazy val playgroundCore = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("playground-core"))
  .enablePlugins(JavaAppPackaging)
  .settings(com.peknight.build.sbt.dockerSettings)
  .settings(
    name := "playground-core",
    Docker / packageName := "pek/playground-app",
  )
