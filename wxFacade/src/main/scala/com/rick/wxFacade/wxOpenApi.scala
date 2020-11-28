package com.rick.wxFacade

import faithful.{Future, Promise}

import scala.scalajs.js
import scala.scalajs.js.UndefOr

object wxOpenApi {
  def login(o: Callback[Code]): Unit = {
    wx.login(o)
  }

  def checkSession(o: Callback[Unit]) = {
    wx.checkSession(o)
  }

  def navigateToMiniProgram(o: Callback[Unit]): Unit = {
    wx.navigateToMiniProgram(o)
  }


  //  def getUserInfo[T](KEY: String): Future[T] = {
  //
  //  }
}
