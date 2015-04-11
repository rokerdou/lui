
##LuiFramework是什么?
一个可以用lua脚本编写android APP的业务框架



##LuiFramework如何使用？

* 如何使用lui框架编写自己的androidAPP
    *  新建Android的工程后MainActivity继承cn.iolove.lui.Activity.BootActivity
    *  然后在Asset目录下新建main.lua文件//(业务代码和UI代码)
    *  在libs目录下添加lui.jar,lua4.jar,armeabi\libluajava.so,四个文件 (四个文件本项目中libs中)可以拷贝到自己的android工程里
    *  接下来的工作将全部在Asset目录中的lua文件实现UI的基本业务逻辑编写
* 基本的控件button edittext view 等控件已经实现
* lui的优点
   *  抛弃原有的XML编写UI，而且Java代码动态生成UI和业务代码捆绑紧密，耦合度高，开发复杂
   *  简化UI编写流程，易于实现相对复杂UI布局,实现android开发的前端和后端核心数据数据服务处理的分离
   *  易于拓展添加自己编写新的UI控件



##有问题反馈
* found  some error not to run project when you import project,please delete lui.jar in libs path.
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件(dou.roker@gmail.com or tzlhk@qq.com)
* QQ: 316766907
* weibo: [@溯源](http://weibo.com/u/2395014387)





##关于作者

```javascript
  var ihubo = {
    nickName  : "roker dou"
  }
```
