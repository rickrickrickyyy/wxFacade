package com.rick.wxFacade

object wxOpenApi {

  def login(o: Callback[Code]): Unit = {
    wx.login(o)
  }

  def checkSession(o: Callback[Unit]) = {
    wx.checkSession(o)
  }

  def navigateToMiniProgram[T](o: NavigateToMiniProgramCallback[T]): Unit = {
    wx.navigateToMiniProgram(o)
  }

  def navigateBackMiniProgram[T](o: NavigateBackMiniProgramCallback[T]): Unit = {
    wx.navigateToMiniProgram(o)
  }

  def getUserInfo(o: GetUserInfoCallback): Unit = {
    wx.getUserInfo(o)
  }

  //  def getUserInfo[T](KEY: String): Future[T] = {
  //
  //  }
}
