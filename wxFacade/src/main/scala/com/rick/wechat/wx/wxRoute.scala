package com.rick.wechat.wx

import com.rick.wechat.facade.wxObject
import faithful.Future

import scala.scalajs.js
import scala.scalajs.js.UndefOr
//TODO:
class EventChannel()

private class RouteCallback[T <: js.Object](path: String, data: Option[T] = None) extends navigateToCallBack[T, Unit](path, data)

private class navigateToCallBack[T <: js.Object, EventChannel](path: String, data: Option[T] = None) extends Callback[EventChannel] with Url {
  override val url: UndefOr[String] = js.defined {
    path + data.map(query).getOrElse("")
  }
}

object switchTab {
  def apply(path: String): Future[Unit] = new RouteCallback(path, None).future(wxObject.switchTab)
}

object reLaunch {
  def apply[T <: js.Object](path: String, data: Option[T] = None): Future[Unit] = new RouteCallback(path, data).future(wxObject.reLaunch)
}

object navigateTo {
  def apply[T <: js.Object](path: String, data: Option[T] = None): Future[EventChannel] = new navigateToCallBack[T, EventChannel](path, data).future(wxObject.navigateTo)
}

object redirectTo {
  def apply[T <: js.Object](path: String, data: Option[T] = None): Future[Unit] = new RouteCallback(path, data).future(wxObject.redirectTo)
}

private class navigateBack(val delta: UndefOr[Int] = js.undefined) extends Callback[Unit]

object navigateBack {
  def apply(delta: UndefOr[Int]): Future[Unit] = new navigateBack(delta).future(wxObject.navigateBack)
}
