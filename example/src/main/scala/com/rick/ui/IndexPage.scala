package com.rick.ui

import java.util.concurrent.atomic.AtomicBoolean

import com.rick.wechat.facade.{Page, Wechat}
import com.rick.wechat.wx.{Data, PageLifeCycle}

import scala.scalajs.js
import scala.scalajs.js.{ThisFunction1, UndefOr}
import com.rick.wechat._
import com.rick.wechat.facade._
import faithful.{Future, Promise}
import faithful.cats.Instances._
import cats.syntax.all._

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

    wx.getUserInfo()
      .flatMap(_ => wx.getUserInfo())
      .flatMap(_ => wx.login())({ e =>
        console.log("login oho no.efewefeawf")
        console.log(e)
        console.log("wefef")
      }, { e =>

      })
    page.setData(data, Wechat.callback)
  }
}
