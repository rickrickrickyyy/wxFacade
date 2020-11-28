package com.rick.wxFacade

import faithful.Future

object wxOpenApi {

  def login(): Future[Code] = {
    new Callback[Code]().toFuture(wx.login)
  }

  def checkSession(): Future[Unit] = {
    new Callback[Unit]().toFuture(wx.checkSession)
  }

  def navigateToMiniProgram[T](o: NavigateToMiniProgramCallback[T]): Future[Unit] = {
    o.toFuture(wx.navigateToMiniProgram)
  }

  def navigateBackMiniProgram[T](o: NavigateBackMiniProgramCallback[T]): Future[Unit] = {
    o.toFuture(wx.navigateToMiniProgram)
  }

  def getUserInfo(o: GetUserInfoCallback): Future[GetUserInfoResponse] = {
    o.toFuture(wx.getUserInfo)
  }

  //  def getUserInfo[T](KEY: String): Future[T] = {
  //
  //  }
}
