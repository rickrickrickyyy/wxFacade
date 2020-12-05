package com.rick.ui

import java.util.concurrent.atomic.AtomicBoolean

import com.rick.wechat._
import com.rick.wechat.facade.{Page, Wechat, _}
import com.rick.wechat.future.{Data, GetStorageResult, PageLifeCycle, login, wx}
import faithful.Future
import faithful.cats.Instances._
import cats.syntax.all._

import scala.scalajs.js
import scala.scalajs.js.{ThisFunction1, UndefOr}

case class JavaScriptException(exception: Any) extends RuntimeException {
  override def toString() = exception.toString()
}

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
    wx.setStorage[String]("shoe", "shoe set set set ")
      .flatMap(e => wx.removeStorage("shoe"))
      .flatMap(e => wx.removeStorage("shoe"))
      .flatMap(e => wx.removeStorage("shoeefe"))
      .flatMap(e => wx.removeStorage("shoe"))
      .flatMap(e => wx.removeStorage("shoe"))({ e =>
        console.log("success:")
        console.log(e)
      }, { e =>
        console.log("error:")
        console.log(e)
      })
    page.setData(data, Wechat.callback)
  }
}
