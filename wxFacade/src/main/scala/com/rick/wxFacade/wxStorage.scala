package com.rick.wxFacade

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import faithful.{Future, Promise}

//数据缓存
object wxStorage {
  def setStorageSync[T](key: String, value: T): Unit = {
    wx.setStorageSync(key, value.asInstanceOf[js.Object])
  }

  def setStorage[T](e: SetStorageCallback[T]): Unit = {
    wx.setStorage(e)
  }

  def setStorage[T](KEY: String, DATA: T): Future[ErrMsg] = {
    val promise = new Promise[ErrMsg]()
    wx.setStorage(new SetStorageCallback[T] {
      override val key: UndefOr[String] = KEY
      override val data: UndefOr[T] = DATA
      override val success: UndefOr[js.Function1[ErrMsg, _]] = js.defined {
        promise.success
      }
      override val fail: UndefOr[js.Function1[js.Error, _]] = js.defined { e => promise.failure(new Throwable(e.name + ":" + e.message)) }
    })
    promise.future
  }

  def removeStorageSync(key: String): Unit = {
    wx.removeStorageSync(key)
  }

  def removeStorage(e: RemoveStorageCallback): Unit = {
    wx.removeStorage(e)
  }

  def removeStorage(KEY: String): Future[ErrMsg] = {
    val promise = new Promise[ErrMsg]()
    wx.removeStorage(new RemoveStorageCallback {
      override val key: UndefOr[String] = KEY
      override val success: UndefOr[js.Function1[ErrMsg, _]] = js.defined {
        promise.success
      }
      override val fail: UndefOr[js.Function1[js.Error, _]] = js.defined { e => promise.failure(new Throwable(e.name + ":" + e.message)) }
    })
    promise.future
  }

  def getStorageSync[T](key: String): js.UndefOr[T] = {
    wx.getStorageSync(key).asInstanceOf[T]
  }

  def getStorageInfoSync(): js.UndefOr[GetStorageInfoResult] = {
    wx.getStorageInfoSync().asInstanceOf[GetStorageInfoResult]
  }

  def getStorageInfo(e: Callback[GetStorageInfoResult]): Unit = {
    wx.getStorageInfo(e)
  }

  def getStorageInfo(): Future[GetStorageInfoResult] = {
    val promise = new Promise[GetStorageInfoResult]()
    wx.clearStorage(new Callback[GetStorageInfoResult] {
      override val success: UndefOr[js.Function1[GetStorageInfoResult, _]] = js.defined {
        promise.success
      }
      override val fail: UndefOr[js.Function1[js.Error, _]] = js.defined { e => promise.failure(new Throwable(e.name + ":" + e.message)) }
    })
    promise.future
  }

  def getStorage[T](e: GetStorageCallback[T]): Unit = {
    wx.getStorage(e)
  }


  def getStorage[T](KEY: String): Future[T] = {
    val promise = new Promise[T]()
    wx.getStorage(new GetStorageCallback[T] {
      override val key: UndefOr[String] = KEY
      override val success: UndefOr[js.Function1[GetStorageResult[T], _]] = js.defined { e =>
        try {
          promise.success(e.data.get)
        } catch {
          case e: Exception => {
            promise.failure(e)
          }
        }
      }
      override val fail: UndefOr[js.Function1[js.Error, _]] = js.defined { e => promise.failure(new Throwable(e.name + ":" + e.message)) }
    })
    promise.future
  }

  def clearStorageSync(): Unit = {
    wx.clearStorageSync()
  }

  def clearStorage(e: Callback[Unit]): Unit = {
    wx.clearStorage(e)
  }

  def clearStorage(): Future[_] = {
    val promise = new Promise[Unit]()
    wx.clearStorage(new Callback[Unit] {
      override val success: UndefOr[js.Function1[Unit,_]] = js.defined { Unit =>
        promise.success()
      }
      override val fail: UndefOr[js.Function1[js.Error, _]] = js.defined { e => promise.failure(new Throwable(e.name + ":" + e.message)) }
    })
    promise.future
  }
}