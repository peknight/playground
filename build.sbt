import com.peknight.build.sbt.*

buildSettings

nexusSettings

lazy val playground = (project in file("."))
  .aggregate(
    playgroundCore.jvm,
    playgroundCore.js,
  )
  .settings(commonSettings)
  .settings(
    name := "playground",
  )

lazy val playgroundCore = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("playground-core"))
  .settings(commonSettings, dockerSettings)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "playground-core",
    Docker / packageName := "pek/playground-app",
  )
