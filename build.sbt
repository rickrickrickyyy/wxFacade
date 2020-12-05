import sbt.Resolver
import complete.DefaultParsers._

def copyDir(src: sbt.File, target: sbt.File, fileType: String, preserveLastModified: Boolean): Set[sbt.File] = {
  import Path._

  // get the files we want to copy
  val srcManagedJVM: Seq[File] = (src ** fileType).get()

  // use Path.rebase to pair source files with target destination in crossTarget
  val pairs = srcManagedJVM pair rebase(src, target)

  // Copy files to source files to target
  IO.copy(pairs, CopyOptions.apply(overwrite = true, preserveLastModified = preserveLastModified, preserveExecutable = false))
}
lazy val copyFile = inputKey[Unit]("")
copyFile := {
  val arguments = spaceDelimited("<arg>").parsed
  val arg1: String = arguments.head
  val arg2: String = arguments(1)
  val src = (Compile / baseDirectory).value / s"${arg1}/target/scala-2.13/"
  val dst = (Compile / baseDirectory).value / s"${arg2}/pages/"
  println(src)
  println(dst)
  copyDir(src, dst, "*-opt.js", false)
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

commands += Command.command("wxJS") { state =>
    "example/fullOptJS" ::
    "copyFile example miniProgram" ::
    state
}

