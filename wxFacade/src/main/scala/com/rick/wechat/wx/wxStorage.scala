package com.rick.wechat.wx

import com.rick.wechat.facade.wxObject
import faithful.Future

import scala.scalajs.js
import scala.scalajs.js.UndefOr

//数据缓存
trait GetStorageResult[T] extends Data[T] with ErrMsg

trait GetStorageInfoResult extends js.Object {
  val keys: js.UndefOr[js.Array[String]] = js.undefined
  val currentSize: js.UndefOr[Long] = js.undefined
  val limitSize: js.UndefOr[Long] = js.undefined
}

private class clearStorage extends Callback[Unit]

object clearStorage {
  def apply(): Future[Unit] = new clearStorage().future(wxObject.clearStorage)
}

private class getStorage[T](override val key: js.UndefOr[String]) extends Callback[GetStorageResult[T]] with Key

object getStorage {
  def apply[T](key: UndefOr[String]): Future[GetStorageResult[T]] = new getStorage[T](key).future(wxObject.getStorage)
}

private class getStorageInfo extends Callback[GetStorageInfoResult]

object getStorageInfo {
  def apply(): Future[GetStorageInfoResult] = new getStorageInfo().future(wxObject.getStorageInfo)
}

private class removeStorage(override val key: js.UndefOr[String]) extends Callback[ErrMsg] with Key

object removeStorage {
  def apply(key: UndefOr[String]): Future[ErrMsg] = new removeStorage(key).future(wxObject.removeSavedFile)
}

private class setStorage[T](override val key: js.UndefOr[String], override val data: UndefOr[T]) extends Callback[ErrMsg] with Key with Data[T]

object setStorage {
  def apply[T](key: UndefOr[String], data: UndefOr[T]): Future[ErrMsg] = new setStorage(key, data).future(wxObject.setStorage)
}