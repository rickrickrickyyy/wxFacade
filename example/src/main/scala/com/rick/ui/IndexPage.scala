package com.rick.ui

import java.util.concurrent.atomic.AtomicBoolean

import com.rick.wxFacade._

import scala.scalajs.js
import scala.scalajs.js.{ThisFunction1, UndefOr}

class IndexPage extends js.Object with PageLifeCycle[IndexData] with Data[IndexData] {
  var image: Option[String] = None
  var shoeId: Option[String] = None
  val isUploadingImage: AtomicBoolean = new AtomicBoolean(false)
  //  def query(o: js.Object): String =
  //    entries(o).map(e => s"${e._1}=${e._2}").mkString("&")

  override val data: UndefOr[IndexData] = js.defined {
    new IndexData("defaultImage")
  }

  override val onLoad: UndefOr[ThisFunction1[Page, IndexData, _]] = js.defined { (page, data) =>
    image = data.image.toOption
    page.setData(data, Wechat.callback)
  }
}
