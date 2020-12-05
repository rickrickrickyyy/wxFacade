package com.rick.wechat.wx

import com.rick.wechat.facade.wxObject
import faithful.Future

import scala.scalajs.js
import scala.scalajs.js.UndefOr

private class login extends Callback[Code]

object login {
  def apply(): Future[Code] = new login().future(wxObject.login)
}

private class checkSession() extends Callback[Unit]

object checkSession {
  def apply(): Future[Unit] = new checkSession().future(wxObject.checkSession)
}

private class navigateToMiniProgram[T](
                                        val appId: String,
                                        val path: js.UndefOr[String] = js.undefined,
                                        override val extraData: js.UndefOr[T] = js.undefined,
                                        val envVersion: js.UndefOr[String] = js.undefined,
                                      ) extends Callback[Unit] with ExtraData[T]

object navigateToMiniProgram {
  def apply[T](appId: String, path: UndefOr[String], extraData: UndefOr[T], envVersion: UndefOr[String]): Future[Unit] = new navigateToMiniProgram(appId, path, extraData, envVersion).future(wxObject.navigateToMiniProgram)
}

private class navigateBackMiniProgram[T](override val extraData: js.UndefOr[T] = js.undefined) extends Callback[Unit] with ExtraData[T]

object navigateBackMiniProgram {
  def apply[T](extraData: UndefOr[T]): Future[Unit] = new navigateBackMiniProgram(extraData).future(wxObject.navigateBackMiniProgram)
}

class UserInfo(val nickName: js.UndefOr[String] = js.undefined,
               val avatarUrl: js.UndefOr[String] = js.undefined,
               val gender: js.UndefOr[Int] = js.undefined,
               val country: js.UndefOr[String] = js.undefined,
               val province: js.UndefOr[String] = js.undefined,
               val city: js.UndefOr[String] = js.undefined,
               val language: js.UndefOr[String] = js.undefined) extends js.Object

class GetUserInfoResponse(
                           val userInfo: js.UndefOr[UserInfo] = js.undefined,
                           val rawData: js.UndefOr[String] = js.undefined,
                           val signature: js.UndefOr[String] = js.undefined,
                           val encryptedData: js.UndefOr[String] = js.undefined,
                           val iv: js.UndefOr[String] = js.undefined,
                           val cloudID: js.UndefOr[String] = js.undefined,
                         ) extends js.Object

private class getUserInfo(val withCredentials: js.UndefOr[Boolean] = js.undefined,
                          override val lang: js.UndefOr[String] = js.undefined) extends Callback[GetUserInfoResponse] with Lang

object getUserInfo {
  def apply(withCredentials: UndefOr[Boolean] = js.undefined, lang: UndefOr[String] = js.undefined): Future[GetUserInfoResponse] = new getUserInfo(withCredentials, lang).future(wxObject.getUserInfo)
}

