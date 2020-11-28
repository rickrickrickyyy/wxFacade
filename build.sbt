import sbt.Resolver
// Define task to  copy html files
val copyJS = taskKey[Unit]("Copy js file")

// Implement task
copyJS := {
  import Path._

  val src = (Compile / baseDirectory).value / "example/target/scala-2.13/"
  val dst = (Compile / baseDirectory).value / "miniProgram/pages/"

  // get the files we want to copy
  val jsFiles: Seq[File] = (src ** "example-opt.js").get()

  // use Path.rebase to pair source files with target destination in crossTarget
  val pairs = jsFiles pair rebase(src, dst)

  // Copy files to source files to target
  IO.copy(pairs, CopyOptions.apply(overwrite = true, preserveLastModified = true, preserveExecutable = false))
}

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
    name := "example",
    version := "0.1",
    resolvers += Resolver.bintrayRepo("hmil", "maven"),
    scalaVersion := "2.13.4",
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule)
    },
    libraryDependencies ++= Seq(
    )
  ).dependsOn(wxFacade)

