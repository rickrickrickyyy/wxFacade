package com.rick.wxFacade

import scala.scalajs.js
import js.Dynamic.literal
import scala.util.{Success,Failure}
import scala.concurrent.{Future,Promise}
import scala.concurrent.ExecutionContext.Implicits.global

object Wechat {
  type Callback = () => Unit 
  type ErrorCallback = (Throwable) => Unit
  implicit val callback: Callback = () => {}
  implicit val errorCallback: ErrorCallback = (e: Throwable) => { println(e) }

  def selectComponent(s: String): Component = {
    val current = WXGlobal.getCurrentPages().last
    current.selectComponent(s)
  }

  def selectAllComponents(s: String): js.Array[Component] = {
    val current = WXGlobal.getCurrentPages().last
    current.selectAllComponents(s)
  }

  def setData(o: js.Object,f: Callback = callback): Unit = {
    val current = WXGlobal.getCurrentPages().last
    current.setData(o,f)
  }

  def setData(key: String, data: Future[js.Dynamic])(implicit cb: ErrorCallback): Unit = {
    data.onComplete {
      case Success(i) => this.setData(literal(key -> i))
      case Failure(e) => cb(e)
    }
  }

  def login(cb: =>Unit): Future[js.Dynamic] = {
    val p = Promise[js.Dynamic]()
    val scb = (ret: js.Dynamic) => p.success(ret)
    val fcb = () => p.failure(js.JavaScriptException("wx.login"))
    wx.login(literal(success = scb, fail = fcb, complete = () => cb))
    p.future
  }

  def getUserInfo(withCredentials: Boolean,lang: String)(cb: =>Unit): Future[js.Dynamic] = {
    val p = Promise[js.Dynamic]()
    val scb = (ret: js.Dynamic) => p.success(ret.userInfo)
    val fcb = () => p.failure(js.JavaScriptException("wx.getUserInfo"))
    wx.getUserInfo(literal(withCredentials = withCredentials,
                           lang = lang,
                           success = scb,
                           fail = fcb,
                           complete = () => cb))
    p.future
  }

  def request(url: String,data: js.Dynamic,header: js.Dynamic,method: String)(cb: => Unit): Future[js.Dynamic] = {
    val p = Promise[js.Dynamic]()
    val scb = (ret: js.Dynamic) => p.success(ret)
    val fcb = () => p.failure(js.JavaScriptException("wx.request"))
    wx.request(literal(url = url,
                       data = data,
                       header = header,
                       method = method,
                       success = scb,
                       fail = fcb,
                       complete = () => cb))
    p.future
  }
}
