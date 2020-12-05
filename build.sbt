import sbt.Resolver
import complete.DefaultParsers._

val circeVersion = "0.13.0"

val wxFacade = project
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := "2.13.3",
    libraryDependencies ++= Seq(
      "org.julienrf" %%% "faithful" % "2.0.0",
      "org.julienrf" %%% "faithful-cats" % "2.0.0"
    )
  )

val example = project
  .enablePlugins(ScalaJSPlugin)
  .settings(
    Compile / fastOptJS / artifactPath := baseDirectory.value / "miniProgram" / "pages" / "main-opt.js",
    Compile / fullOptJS / artifactPath := baseDirectory.value / "miniProgram" / "pages" / "main-opt.js",
    name := "example",
    version := "0.1",
    resolvers += Resolver.bintrayRepo("hmil", "maven"),
    scalaVersion := "2.13.4",
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule)
    },
    scalaJSUseMainModuleInitializer := false,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.1.0",

      "io.circe" %%% "circe-core" % circeVersion,
      "io.circe" %%% "circe-generic" % circeVersion,
      "io.circe" %%% "circe-parser" % circeVersion
    )
  ).dependsOn(wxFacade)

