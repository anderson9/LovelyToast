### LovelyToast
Make u Toast become lovely and alive,
* 6 kinds of types(6种的toast类型)
* 3 kinds of show and out animation（3种显示与取消的动画） support custom（支持自定义添加更多）
* 2 kinds of animation location(可选2种动画位置)
* support fast click ，cancel previous animation automatically(支持快速点击，自定取消上次动画)
* listen homekey to cancel Toast.(内部作了home键的监听取消Toast)


###preview
![gif](http://i1.piimg.com/4851/5cdda9ba1f99fed1.gif)
![gif](http://i1.piimg.com/4851/f4e2368d77de3447.gif)
![gif](http://i1.piimg.com/4851/f0877a79ee62a397.gif)
![gif](http://i1.piimg.com/4851/02ee9b9dbe9e141f.gif)
###Dependency

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

type :
LovelyToast.SUCCESS,
LovelyToast.WARNING,
LovelyToast.ERROR，
LovelyToast.CONFUSING，
LovelyToast..INFO，
LovelyToast.DEFAULT。

showanim :
 LovelyToast.SCALE
 LovelyToast.TOP_DOWN
 LovelyToast.LEFT_RIGHT
 custom style,
null=native anim;

leftorright:
LovelyToast.LEFT
LovelyToast.RIGHT
null=LovelyToast.LEFT

####custom style
``` java
LovelyToast.makeText(mActivity.this, " hi guys",LovelyToast.LENGTH_SHORT, LovelyToast.SUCCESS, R.style.customanim , LovelyToast.RIGHT)

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
