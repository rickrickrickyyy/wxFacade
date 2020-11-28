package com.rick.wxFacade

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import faithful.{Future, Promise}
import faithful.cats.Instances._
import cats.syntax.all._

//数据缓存
object wxStorage {
  def setStorageSync[T](key: String, value: T): Unit = {
    wx.setStorageSync(key, value.asInstanceOf[js.Object])
  }

  def setStorage[T](e: SetStorageCallback[T]): Unit = {
    wx.setStorage(e)
  }

  def setStorage[T](KEY: String, DATA: T): Future[ErrMsg] = {
    new SetStorageCallback[T] {
      override val key: UndefOr[String] = KEY
      override val data: UndefOr[T] = DATA
    }.toFuture(wx.setStorage)
  }

  def removeStorageSync(key: String): Unit = {
    wx.removeStorageSync(key)
  }

  def removeStorage(e: RemoveStorageCallback): Unit = {
    wx.removeStorage(e)
  }

  def removeStorage(key: String): Future[ErrMsg] = {
    new RemoveStorageCallback(key).toFuture(wx.removeStorage)
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
    new Callback[GetStorageInfoResult]().toFuture(wx.getStorageInfo)
  }

  def getStorage[T](e: GetStorageCallback[T]): Unit = {
    wx.getStorage(e)
  }


  def getStorage[T](KEY: String): Future[Option[T]] = {
    new GetStorageCallback[T] {
      override val key: UndefOr[String] = KEY
    }.toFuture(wx.getStorage).map(e => e.data.toOption)
  }

  def clearStorageSync(): Unit = {
    wx.clearStorageSync()
  }

  def clearStorage(e: Callback[Unit]): Unit = {
    wx.clearStorage(e)
  }

  def clearStorage(): Future[_] = {
    new Callback[Unit]().toFuture(wx.clearStorage)
  }
}