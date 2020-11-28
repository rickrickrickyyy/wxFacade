package com.rick.ui

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import com.rick.wxFacade.Page

@JSExportTopLevel("Pages")
object Pages {

  @JSExport
  def indexPage(): Unit = {
    val debug = new IndexPage()
    Page(debug)
  }
}
