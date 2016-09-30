### LovelyToast
Make u Toast become lovely and alive,
* 6 kinds of types(6种的toast类型)
* 3 kinds of show and out animation（3种显示与取消的动画） support custom（支持自定义添加更多）
* 2 kinds of animation location(可选2种动画位置)
* support fast click ，cancel previous animation automatically(支持快速点击，自定取消上次动画)
* listen homekey to cancel Toast.(内部作了home键的监听取消Toast)


###preview
![gif](https://github.com/anderson9/LovelyToast/blob/master/gif/3anim.gif)
![gif](https://github.com/anderson9/LovelyToast/blob/master/gif/6type.gif)
![gif](https://github.com/anderson9/LovelyToast/blob/master/gif/quickclick.gif)
![gif](https://github.com/anderson9/LovelyToast/blob/master/gif/left_or_right.gif)

###Dependency(引入)

```
dependencies {
	compile 'com.ljs.lovelytoast:LovelyToast:1.0.0'
}
```
###This Demo
[this demo download](http://download.csdn.net/detail/luojiusan520/9643109)

###Usage （用法）

``` java
LovelyToast.makeText(mActivity.this, " SUCCESS!!", LovelyToast.LENGTH_SHORT,
                        LovelyToast.SUCCESS);

LovelyToast.makeText(mActivity.this, " Hi guys !",LovelyToast.LENGTH_SHORT , LovelyToast.SUCCESS, LovelyToast.SCALE , LovelyToast.RIGHT);
```
**public static void makeText(Context context, String msg, int length, int type, @Nullable int showanim, @Nullable int leftorright)**





####parms

type :(六种Toast类型分别)
- LovelyToast.SUCCESS,
- LovelyToast.WARNING,
- LovelyToast.ERROR，
- LovelyToast.CONFUSING，
- LovelyToast..INFO，
- LovelyToast.DEFAULT。

showanim :（三种Toast展示动画）
-  LovelyToast.SCALE
-  LovelyToast.TOP_DOWN
-  LovelyToast.LEFT_RIGHT
-  custom style,（可以自定义）
- null=native anim;（不填默认原生动画）

leftorright:(二种动画位置)
- LovelyToast.LEFT
- LovelyToast.RIGHT
- null=LovelyToast.LEFT（不填默认左边动画）

####custom style
``` java
LovelyToast.makeText(mActivity.this, " hi guys",LovelyToast.LENGTH_SHORT, LovelyToast.SUCCESS, R.style.customanim , LovelyToast.RIGHT)
//引用自定义写的toast展示与退出动画，必须是R.style下的文件
<style name="customanim">
        <item name="android:windowEnterAnimation">@anim/toast_enter</item>
        <item name="android:windowExitAnimation">@anim/toast_out</item>
    </style>
```

###Thanks
[https://github.com/geftimov/android-pathview](https://github.com/geftimov/android-pathview)

###Contributors
I want to update this Toast and make it better. So any help will be appreciated. Make and pull - request and we can discuss it.
###Licence
This Licence,
don't need a Public Licence!i don't care!
If u like the LovelyToast,
give me a star,
don't be such a dick,
u just do what u want to do.
（不需要licence，大家想怎么用怎么用，给个star即可，thanks！！ ）
