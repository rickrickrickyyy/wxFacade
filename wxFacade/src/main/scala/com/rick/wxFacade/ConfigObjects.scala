package com.rick.wxFacade

import scala.scalajs.js
import scala.scalajs.js.UndefOr


trait Success[T] extends js.Object {
  val success: js.UndefOr[js.Function1[T, _]] = js.undefined
}

trait Fail extends js.Object {
  val fail: js.UndefOr[js.Function1[ErrMsg, _]] = js.undefined
}

trait Complete extends js.Object {
  val complete: js.UndefOr[js.Function0[_]] = js.undefined
}

trait Callback[T]
  extends Success[T]
    with Fail
    with Complete

trait Key extends js.Object {
  val key: js.UndefOr[String] = js.undefined
}

trait Data[T] extends js.Object {
  val data: js.UndefOr[T] = js.undefined
}

trait Code extends js.Object {
  val code: js.UndefOr[String] = js.undefined
}

trait Lang extends js.Object {
  val lang: js.UndefOr[String] = js.undefined
}

trait ExtraData[T] extends js.Object {
  val extraData: js.UndefOr[T] = js.undefined
}

trait Timeout extends js.Object {
  val timeout: js.UndefOr[Long] = js.undefined
}

trait ErrMsg extends js.Object {
  val errMsg: js.UndefOr[String] = js.undefined
}

trait PageLifeCycle[T] extends js.Object {
  val onLoad: js.UndefOr[js.ThisFunction1[Page, T, _]] = js.undefined

  val onShow: js.UndefOr[js.ThisFunction0[Page, _]] = js.undefined

  val onReady: js.UndefOr[js.ThisFunction0[Page, _]] = js.undefined

  val onHide: js.UndefOr[js.ThisFunction0[Page, _]] = js.undefined

  val onUnload: js.UndefOr[js.ThisFunction0[Page, _]] = js.undefined
}

trait onPullDownRefresh extends js.Object {
  val onPullDownRefresh: js.UndefOr[js.ThisFunction0[Page, _]] = js.undefined
}

trait onReachBottom extends js.Object {
  val onReachBottom: js.UndefOr[js.ThisFunction0[Page, _]] = js.undefined
}

trait onPageScrollEvent extends js.Object {
  val scrollTop: js.UndefOr[Int] = js.undefined
}

trait onPageScroll extends js.Object {
  val onPageScroll: js.UndefOr[js.ThisFunction1[Page, onPageScrollEvent, _]] = js.undefined
}


trait onAddToFavoritesEvent extends js.Object {
  val webViewUrl: js.UndefOr[String] = js.undefined
}

trait onAddToFavoritesResult extends js.Object {
  val title: js.UndefOr[String] = js.undefined
  val imageUrl: js.UndefOr[String] = js.undefined
  val query: js.UndefOr[String] = js.undefined
}


trait onAddToFavorites extends js.Object {
  val onAddToFavorites: js.UndefOr[js.ThisFunction1[Page, onAddToFavoritesEvent, onAddToFavoritesResult]] = js.undefined
}

trait onShareAppMessageEvent extends js.Object {
  val from: js.UndefOr[String] = js.undefined
  val target: js.UndefOr[js.Object] = js.undefined
  val webViewUrl: js.UndefOr[String] = js.undefined
}

trait onShareAppMessageResult extends js.Object {
  val title: js.UndefOr[String] = js.undefined
  val path: js.UndefOr[String] = js.undefined
}


trait onShareAppMessage extends js.Object {
  val onShareAppMessage: js.UndefOr[js.ThisFunction1[Page, onShareAppMessageEvent, onShareAppMessageResult]] = js.undefined
}

trait onShareTimelineResult extends js.Object {
  val title: js.UndefOr[String] = js.undefined
  val query: js.UndefOr[String] = js.undefined
  val imageUrl: js.UndefOr[String] = js.undefined
}

trait onShareTimeline extends js.Object {
  val onShareTimeline: js.UndefOr[js.ThisFunction0[Page, onShareTimelineResult]] = js.undefined
}

trait onResize extends js.Object {
  val onResize: js.UndefOr[js.ThisFunction1[Page, js.Object, _]] = js.undefined
}

@js.native
trait TabItem extends js.Object {
  val index: js.UndefOr[String] = js.native
  val pagePath: js.UndefOr[String] = js.native
  val text: js.UndefOr[String] = js.native
}

trait onTabItemTap extends js.Object {
  val onTabItemTap: js.UndefOr[js.ThisFunction1[Page, TabItem, _]] = js.undefined
}

trait SetStorageCallback[T] extends Callback[ErrMsg] with Key with Data[T]

trait GetStorageCallback[T] extends Callback[GetStorageResult[T]] with Key

trait RemoveStorageCallback extends Callback[ErrMsg] with Key

trait GetStorageResult[T] extends Data[T] with ErrMsg

trait GetStorageInfoResult extends js.Object {
  val keys: js.UndefOr[js.Array[String]] = js.undefined
  val currentSize: js.UndefOr[Long] = js.undefined
  val limitSize: js.UndefOr[Long] = js.undefined
}

class NavigateToMiniProgramCallback[T](
                                        val appId: String,
                                        val path: js.UndefOr[String] = js.undefined,
                                        override val extraData: js.UndefOr[T] = js.undefined,
                                        val envVersion: js.UndefOr[String] = js.undefined,
                                        override val success: UndefOr[js.Function1[Unit, _]] = js.undefined,
                                        override val complete: UndefOr[js.Function0[_]] = js.undefined,
                                        override val fail: UndefOr[js.Function1[ErrMsg, _]] = js.undefined
                                      ) extends Callback[Unit] with ExtraData[T]

class NavigateBackMiniProgramCallback[T](override val extraData: js.UndefOr[T] = js.undefined,
                                         override val success: UndefOr[js.Function1[Unit, _]] = js.undefined,
                                         override val complete: UndefOr[js.Function0[_]] = js.undefined,
                                         override val fail: UndefOr[js.Function1[ErrMsg, _]] = js.undefined
                                        ) extends Callback[Unit] with ExtraData[T]

class UserInfo(val openid: js.UndefOr[String] = js.undefined,
               val nickname: js.UndefOr[String] = js.undefined,
               val headimgurl: js.UndefOr[String] = js.undefined,
               val province: js.UndefOr[String] = js.undefined,
               val city: js.UndefOr[String] = js.undefined,
               val country: js.UndefOr[String] = js.undefined,
               val phone: js.UndefOr[String] = js.undefined,
               val sex: js.UndefOr[Int] = js.undefined,
               val errcode: js.UndefOr[Int] = js.undefined,
               val errmsg: js.UndefOr[String] = js.undefined,
               val unionid: js.UndefOr[String] = js.undefined) extends js.Object

class GetUserInfoResponse(
                           val userInfo: js.UndefOr[UserInfo] = js.undefined,
                           val rawData: js.UndefOr[String] = js.undefined,
                           val signature: js.UndefOr[String] = js.undefined,
                           val encryptedData: js.UndefOr[String] = js.undefined,
                           val iv: js.UndefOr[String] = js.undefined,
                           val cloudID: js.UndefOr[String] = js.undefined,
                         ) extends js.Object

class GetUserInfoCallback(
                           override val success: UndefOr[js.Function1[GetUserInfoResponse, _]] = js.undefined,
                           override val fail: UndefOr[js.Function1[ErrMsg, _]] = js.undefined,
                           override val complete: UndefOr[js.Function0[_]] = js.undefined,
                           val withCredentials: js.UndefOr[Boolean] = js.undefined,
                           override val lang: js.UndefOr[String] = js.undefined,
                         ) extends Callback[GetUserInfoResponse] with Lang
