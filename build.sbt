import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val playground = (project in file("."))
  .settings(name := "playground")
  .aggregate(
    playgroundCore.jvm,
    playgroundCore.js,
  )

lazy val playgroundCore = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("playground-core"))
  .enablePlugins(JavaAppPackaging)
  .settings(name := "playground-core")
  .settings(com.peknight.build.sbt.dockerSettings)
  .settings(
    Docker / packageName := "pek/playground-app",
  )
