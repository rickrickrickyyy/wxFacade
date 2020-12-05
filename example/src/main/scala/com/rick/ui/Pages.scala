package com.rick.ui

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import com.rick.wechat._
import com.rick.wechat.facade._
import faithful.{Future, Promise}
import faithful.cats.Instances._
import cats.syntax.all._

import scala.scalajs.js
import scala.scalajs.js.UndefOr

@JSExportTopLevel("Pages")
object Pages {

  @JSExport
  def indexPage(): Unit = {
    val debug = new IndexPage()
    Page(debug)
  }
}
