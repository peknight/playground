import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val playground = (project in file("."))
  .settings(name := "playground")
  .aggregate(playgroundApp.projectRefs *)

lazy val playgroundApp = (projectMatrix in file("playground-app"))
  .enablePlugins(JavaAppPackaging)
  .settings(name := "playground-app")
  .settings(dockerSettings)
  .settings(
    Docker / packageName := "peknight/playground-app",
  )
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
