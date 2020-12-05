package com.rick.wechat.wx

import com.rick.wechat.facade.wxObject
import faithful.Future

import scala.scalajs.js
import scala.scalajs.js.UndefOr


private class navigateTo[T <: js.Object](path: String, data: Option[T] = None) extends Callback[T] with Url {
  override val url: UndefOr[String] = js.defined {
    path + data.map(query).getOrElse("")
  }
}

object navigateTo {
  def apply[T <: js.Object](path: String, data: Option[T] = None): Future[UndefOr[T]] = new navigateTo(path, data).future(wxObject.navigateTo)
}

object redirectTo {
  def apply[T <: js.Object](path: String, data: Option[T] = None): Future[T] = new navigateTo(path, data).future(wxObject.redirectTo)
}

private class navigateBack(val delta: UndefOr[Int] = js.undefined) extends Callback[Unit]

object navigateBack {
  def apply(delta: UndefOr[Int]): Future[Unit] = new navigateBack(delta).future(wxObject.navigateBack)
}
