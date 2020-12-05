package com.rick.wxFacade

import faithful.Future

import scala.scalajs.js
import scala.scalajs.js.Object.entries
import scala.scalajs.js.UndefOr

object wxRoute {
  private def query(o: js.Object): String =
    "?" + entries(o).map(e => s"${e._1}=${e._2}").mkString("&")

  def navigateTo[T <: js.Object](pageName: String, data: T = js.Dynamic.literal()): Future[js.Object] = {
    new Callback[js.Object] with Url {
      override val url: UndefOr[String] = js.defined {
        s"../${pageName}/${pageName}" + query(data)
      }
    }.toFuture(wx.navigateTo)
  }

  def redirectTo[T <: js.Object](pageName: String, data: T = js.Dynamic.literal()): Future[js.Object] = {
    new Callback[js.Object] with Url {
      override val url: UndefOr[String] = js.defined {
        s"../${pageName}/${pageName}" + query(data)
      }
    }.toFuture(wx.redirectTo)
  }

  def navigateBack(deltaVal: Int = 1): Future[js.Object] = {
    new Callback[js.Object] {
      val delta: UndefOr[Int] = js.defined {
        deltaVal
      }
    }.toFuture(wx.navigateBack)
  }
}
