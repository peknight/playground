import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val playground = (project in file("."))
  .settings(name := "playground")
  .aggregate(
    playgroundApp.jvm,
    playgroundApp.js,
  )

lazy val playgroundApp = (crossProject(JVMPlatform, JSPlatform) in file("playground-app"))
  .enablePlugins(JavaAppPackaging)
  .settings(name := "playground-app")
  .settings(dockerSettings)
  .settings(
    Docker / packageName := "peknight/playground-app",
  )
