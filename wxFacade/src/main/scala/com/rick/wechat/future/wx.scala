package com.rick.wechat.future

import com.rick.wechat.facade.wxObject
import faithful.Future

import scala.scalajs.js
import scala.scalajs.js.UndefOr

object wx {
  //wxRoute.scala
  def switchTab(path: String): Future[Unit] = new RouteCallback(path, None).future(wxObject.switchTab)

  def reLaunch[T <: js.Object](path: String, data: Option[T] = None): Future[Unit] = new RouteCallback(path, data).future(wxObject.reLaunch)

  def navigateTo[T <: js.Object](path: String, data: Option[T] = None): Future[EventChannel] = new navigateToCallBack[T, EventChannel](path, data).future(wxObject.navigateTo)

  def redirectTo[T <: js.Object](path: String, data: Option[T] = None): Future[Unit] = new RouteCallback(path, data).future(wxObject.redirectTo)

  def navigateBack(delta: UndefOr[Int]): Future[Unit] = new navigateBack(delta).future(wxObject.navigateBack)

  //wxOpenApi.scala
  def login(): Future[Code] = new login().future(wxObject.login)

  def checkSession(): Future[Unit] = new checkSession().future(wxObject.checkSession)

  def navigateToMiniProgram[T](appId: String, path: UndefOr[String], extraData: UndefOr[T], envVersion: UndefOr[String]): Future[Unit] = new navigateToMiniProgram(appId, path, extraData, envVersion).future(wxObject.navigateToMiniProgram)

  def navigateBackMiniProgram[T](extraData: UndefOr[T]): Future[Unit] = new navigateBackMiniProgram(extraData).future(wxObject.navigateBackMiniProgram)

  def getUserInfo(withCredentials: UndefOr[Boolean] = js.undefined, lang: UndefOr[String] = js.undefined): Future[GetUserInfoResponse] = new getUserInfo(withCredentials, lang).future(wxObject.getUserInfo)


  //wxStorage.scala
  def clearStorage(): Future[ErrMsg] = new clearStorage().future(wxObject.clearStorage)

  def getStorageInfo(): Future[GetStorageInfoResult] = new getStorageInfo().future(wxObject.getStorageInfo)

  def removeStorage(key: UndefOr[String]): Future[ErrMsg] = new removeStorage(key).future(wxObject.removeStorage)

  def setStorage[T](key: UndefOr[String], data: UndefOr[T]): Future[ErrMsg] = new setStorage(key, data).future(wxObject.setStorage)

  def getStorage[T](key: UndefOr[String]): Future[GetStorageResult[T]] = new getStorage[T](key).future(wxObject.getStorage)
}
