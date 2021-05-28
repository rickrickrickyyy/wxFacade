# wxFacade

在https://github.com/kaiwu/weui-scalajs复制了facade.scala，wechat.scala两个文件。
给facade.scala的接口一个type，并将这些接口封装成一个future。目前还没有把全部接口都封装起来。

这里跟weui-scalajs不一样的地方是把所有界面都输出到同一个js文件，然后调用指定的方法加载指定的界面。
