
* [JAVA-学习笔记汇总](#Title)
    * [2015年12月2日~2015年12月4日](#20151202)
      * [java 小知识点](#java001)：
      * [java 面向对象思想（多态，继承，封装](#java002)
      * [java封装性](#java003)
      * [java继承性](#java004)
      * [java抽象类，final关键字，接口](#java005)
      * [java常用类：](#java006)
      * [java多态性：](#java007)
      * [Note！Note！Note!](#java008)
      * [java异常](#java009)
    * [2015年12月7日](#20151207)
        * [java泛型](#java010)：
        * [java集合－collection](#java011)：
        * [java中的文件类](#java012)：
        * [java中的IO操作](#java013)：
    * [2015年12月8日](#20151208)
        * [java多线程](#java014)：
        * [Android中的数据传递](#java015)：
        * [Android中的Intent](#java016)：
        * [Android中的Context](#java017)：
        * [Android中的Service](#java018)：
    * [2015年12月9日](#20151209)
        * [Android中的BroadcastReceiver](#java019)：
        * [Android中的Fragment](#java020)：
        * [Android中的常用布局](#java021)：
    * [2015年12月10日](#20151210)
        * [Android中的Adapter](#java022)：
        * [Android中的重要细节](#java023)：
    * [2015年12月11日](#20151211)
        * [Android中的事件处理（回调，监听)](#java024)：
        * [Handle,Loop, MessageQueue的工作原理](#java025)：
        * [AsyncTask任务](#java026)：
    * [2015年12月14日](#20151214)
        * [Action，Category，Data，Type的作用](#java027)：
        * [Android的数据存储与IO](#java028)：
    * [2015年12月15日](#20151215)
        * [Android中的ContentProvider](#java029)：
        * [Android中的Service详解](#java030)：
        * [Android中的多媒体应用](#java031)：
    * [2015年12月16日](#20151216)
        * [Andorid中的网络应用](#java032)：
    * [2015年12月22日](#20151222)
        * [Android中的常用单位](#java033)：
    * [2016年1月5日](#20160105)
        * [Android合理的管理内存](#java034)：
    * [2016年1月11日](#20160111)
        * [Android中的DataBinding技术](#java035)：
    * [2016年1月13日](#20160113)
        * [Android中的Reference](#java036)：
        * [Android中的Handle，Runnable，Timertask作用](#java037)：
    * [2016年1月14日](#20160114)
        * [Android中的Task和AsynTask](#java038)：
        * [Android中的动画](#java039)：
    * [2016年1月15日](#20160115)
        * [Android中的synchronized详解](#java040)：
        * [AIDL介绍](#java041)：











# <a name="Title"/>**JAVA-学习笔记汇总**
作为java学习过程中的笔记承载文件

## <a name="20151202"> **2015年12月2日～2015年12月4日**
### <a name="java001"> **java 小知识点：**
- 接受控制台数据，利用Scanner类即可，具体用法查询API手册输入输出：name ＝ sccaner（）；
- Debug调试,跟xcode一样（改下快捷键)
- 调试小技巧 ,自动对其（cmd＋alt＋L）等，注意调试细节，堆栈调试
- java编译过程   -     java文件-javac.exe-.class文件-java.exe解释器-内存方法区，静态方法创建
- Static ，与类的生命周期相同。由java虚拟机自动初始化。使用static方法的时候，只能访问static声明的变量和方法。静态方法尽量用类名来调用。
- 访问权限（private，public，default，protect）类似于c++，不过访问权限牵涉到一个包的概念

### <a name="java002"> **java 面向对象思想（多态，继承，封装）**
- 方法重载
类似于C++的重载规则（注意点就是返回值不同，不算重载）
- 方法递归规则
类似于c++中的方法递归
- 内存（堆，栈，思想）


### <a name="java003"> **java封装性**
- 保护属性和方法不被外部看见（类似于ios中的访存器）
- 构造方法与c＋＋类似
- 匿名对象的使用类似于：new people().age；
- 引用传递的概念，其实就是一个别名;
- 还有这种用法this();

### <a name="java004"> **java继承性**
- 继承主要是扩展父类的功能
- 基本语法时 class 子类 extends 父类｛｝
-继承的限制（只允许单继承，子类不能直接访问父类私有成员）
- 方法重写：类似于C++中的方法覆盖，子类有优先权，覆盖父类的方法。
- super 指向父类的指针。

### <a name="java005"> **java抽象类，final关键字，接口**
- final声明的类不能被继承
- final声明的方法不能被重写
- final声明的变量变成常量，常量是不可以被修改的。
- 包含抽象方法的类事抽象类，（利用abstract关键字声明的方法）
   抽象类被子类继承，子类必须重写所有的抽象类方法。
格式：abstract class classname｛
属性
方法
抽象方法 类似于public abstract void say();
｝

- 接口（类似于iOS中的protocol）
格式 ：interface interfaceName｛
    全局变量，  这点注意，和ios的protocol还有区别。这里的接口可以带常量（final）
    抽象方法
｝
- 接口也是可以多实现的。类似于IOS中的protocol可以多实现。
- 接口也可以继承接口，可以多继承接口，不可以继承抽象类
例如：
interface inter1 extends inter1 inter2｛

｝


### <a name="java006"> **java常用类：**
- String类，比较用equals（）函数
- StringBuffer类，是个操作类，缓冲区也是操作字符串（其实类似于可改变的字符串，NSMutableString）
- StringBuilder，用在字符串缓冲区被单个使用的时候，建议优先考虑该类。（其实类似于StringBuffer的简单替换）

### <a name="java007"> **java多态性：**
- 父类指向子类和C++一样，子类指向父类会有一些区别。
- java中有一个instanceof关键字判断一个对象到底是不是一个类的实例。（类似于ios中isclassof）用法： （a instanceof A）返回值boolean类型。
- 抽象类中还可以实现方法，跟C++有所不同，还要记住一点，无论什么时候，最好不要继承一个完成好的类。

### <a name="java008"> **Note！Note！Note!**
- java中的当有类继承自接口，可以视为interface是父类（这样不严谨，但是多态行为，和继承自父类一样）

### <a name="java009"> **java异常**
- 利用try catch来捕获
- throws关键字 抛出异常，抛出上层函数，类似于责任链机制。
- 看参考视频

## <a name="20151207"> **2015年12月7日**

### <a name="java010"> **java泛型**
- 认识泛性（跟c+＋中的模版template一样）
- java中的泛型有通配符的概念？
- java也有类似于C++中的泛型数组，泛型方法。详情见代码清单

### <a name="java011"> **java集合-collection**
- List接口饰collection的子接口
- List中的常用方法，参考API即可(跟C++中的Vector容器基本一样)
- ArrayList和Vector有一定的区别
  ArrayList异步非线程安全，Vector同步线程安全
- Set(数学概念上的集合，不能重复的元素)
 HashSet(散列方法，无序存放)
 TreeSet(有序的存放，可以内部自动排序)
- Iterator饰标准的迭代访问器，最好遵循集合就使用Iterator进行遍历（类似于一个指针）
```
//Iterator 简单使用
Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            String str = iter.next();
            if ("B".equals(str)) {
                iter.remove();
            } else {
                System.out.println(str);
            }
        }
```
- 注意区分Iterator中的remove和list等集合的remove方法的区别
  在迭代输出的过程中不要轻易删除元素
- Map类似于oc中的NSDictory(Key－value对,key不允许重复)
```
//map的简单使用
       Map<String,String> map = new HashMap<String,String>();
       map.put("key1","xiaoyu");
       map.put("key2","xiaomingg");

       Set<String> set = map.keySet();
       Iterator<String> iterator = set.iterator();
       while(iterator.hasNext())
       {
           System.out.println(iterator.next());
       }
```
- 详细用法，请参阅API

### <a name="java012"> **java中的文件类**
- File类常用属性可参阅API文档
- FileInputStream 是一个字节流，承载文件输入
- InputStreamReader 是一个字符流，从字符流转过来的时候需要指定编码类型。
- BufferedReader  具有缓冲功能的一个Reader（使用完均须关闭）
  对磁盘的操作叫少。

```

        File file = new File("Hello.txt");
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                InputStreamReader isr = null;
                try {
                    isr = new InputStreamReader(fis, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                try {
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

```

- 输出流于上面类似，注意编码潜在问题即可。

### <a name="java013"> **java中的IO操作**
- 区分字节流和字符流

```
public static void ioRead() {
       FileInputStream fis = null;
       try {
           fis = new FileInputStream("test.txt");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       byte input[] = new byte[10];
       try {
           fis.read(input);
       } catch (IOException e) {
           e.printStackTrace();
       }
       String inputString = new String(input);
       System.out.println(inputString);
       try {
           fis.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static void ioWrite() {
       FileOutputStream fos = null;
       try {
           fos = new FileOutputStream("outWrite");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       String outWriter = "写出到文件上面";
       byte output[] = outWriter.getBytes();
       try {
           fos.write(output);
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           fos.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
```

- FileWrite/FileRead
- Apache 提供了很优秀的IO库，可以简单尝试一下

```
public static void useApache() {
        File file = new File("test.txt");
        String str = null;
        try {
            str = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);

    }
```
## <a name="20151208"> **2015年12月8日**
### <a name="java014"> **java多线程**
- java中线程的实现（继承Thread类，实现Runnable接口）
- 线程中的状态
  创建状态：准备好了一个多线程的对象
  就绪状态：调用了start（）方法，等待cpu进行调度
  运行状态：执行run（）方法
  阻塞状态：暂时停止执行，可能将资源交给其他线程使用
  终止状态：（死亡状态）：线程销毁
- Thread类常用方法（getname，currentthread，isalive，join，sleep）
- synchronized(同步代码块，同步方法) 有效避免资源竞争

### <a name="java015"> **Android中的数据传递**
- Activity简单来说是一个界面的承载体，类似于ios中的Controller，可以通过其进行页面切换
  （可切换至网页）回退等()。
- Activity 传递简单数据
  传递数据Intent.putExtra();
  获取Intent getIntent()
  获取数据:  getStringData()

- 传递数据包Bundle

- 传递值对象（类似于ios中的dataModel）
   * 值对象需要implement  Serializable
   * 值对象或者需要实现Parcelable（Android提供的）
- 在使用内存的时候，Parcelable比Serializable性能高，所以推荐使用Parcelable

```
public class User implements Parcelable {

    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source.readString(), source.readInt());
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}

```
- Serializable在序列化的时候会产生大量的临时变量，从而引起频繁的GC

- 获取Activity返回参数

```
btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data", editText.getText().toString());
                setResult(1, i);
                finish();
            }
        });

```
类似于回调的东西

```
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView1.setText(data.getStringExtra("data"));
    }

```
- 标准的Activity启动模式也是堆栈管理的，跟navigationcontroller一样
- 注意一下，Activity的启动模式的区别。（明确了四种任务站的方式）

### <a name="java016"> **Android中的Intent**
- Intent可以作为数据的承载，也可以作为启动Activity时的一个媒介
- 隐饰Intent，可以在manifest.XML 配置（启动其他应用程序中的activity，可利用export配置响应属性 ）
- Intent过滤器相关（配置属性参考文档即可）
- 内部浏览器可以启动本机上的activity

### <a name="java017"> **Android中的Context**
- Context是一个用来访问全局信息的接口，便于访问资源（信息共享的桥梁）
- 继承自application 的类，可以全局获得，作为全局上下文的载体（共享数据）对与同一个应用程序是唯一的。
- application的 onCreate函数会比Activity的onCteate函数先执行，这对于做一些提前配置操作非常有用

### <a name="java018"> **Android中的Service**
- 可以使程序在后台运行
  startService（）
  stopService（）
  onStartCommand（）当外界开始startService候，开始执行。
- 绑定服务(也是启动服务的一种方法)
  bindService（）;
  unBindService();

## <a name="20151209"> **2015年12月9日**

### <a name="java019"> **Android中的BroadcastReceiver**
- BroadcastReceiver消息接收器，跟IOS中的NSNotificationCenter类似
- 消息也有对应的注册和注销跟IOS中的addNotification/removeNotification一样
- 消息有优先级的机制，另外可以在优先级高的响应中abortReceiver（）阻断其他消息
- Android 的权限管理（可以在manifest文件中进行配置）
- 也可以为组件添加权限控制

### <a name="java020"> **Android中的Fragment**
- Fragment较Activity轻量级，做界面切换比较灵活（适用于同一程序内部快速跳转）
- Fragment的[生命周期](http://developer.android.com/intl/zh-cn/guide/components/fragments.html
)

### <a name="java021"> **Android中的常用布局**
- FrameLayout布局（类似于图层）
- LineLayout布局 （代码尝试）
  layout_weight 属性控制其所占父容器的比重
- Relativelayout布局
  类似于IOS中的autolayout中的constrain的添加

## <a name="20151210"> **2015年12月10日**
### <a name="java022"> **Android中的Adapter**
- Adapter 可以理解为一个数据源接口，类似于IOS中的代理数据源
- ArrayAdapter,简洁功能有局限，适用于列表是TextView的形式。
- SimpleAdapter 功能较为强大，适用于列表项中的元素多样的形式。
- BaseAdapter  非常适用于拓展的列表项

### <a name="java023"> **Android中的重要细节**
- Handle 的理解，作用（主要接收子线程发送的数据，并用此数据配合住线程更新UI）
  跟IOS开发一样，UI相关操作，必须在主线程中进行,有网络请求的时候一般另开线程
  进行数据请求，请求完毕在传递相应数据到主线程进行UI更新,
- inflate与findViewById的区别  
    * inflate 方法与 findViewById 方法不同；
    * inflater 是用来找 res/layout 下的 xml 布局文件，并且实例化；
    * findViewById() 是找具体 xml 布局文件中的具体 widget 控件(如:Button、TextView 等)。
- NotificationManager的用法和和IOS中的NSNotificationCenter类似，不过其意义不同，IOS中的通知是
指全局中，发广播，而Android中的通知指的是状态栏通知

## <a name="20151211"> **2015年12月11日**
### <a name="java024"> **Android中的事件处理**
- 监听的事件模型（事件源，事件，事件监听器）
   事件源：事情的发生场所，如按钮等
   事件：时间类型，如点击，轻敲，重击
   事件监听器：可以理解为事件响应的代理者，代理者的函数来处理响应
- 基于监听的事件处理
    这种模式跟IOS中类似，利用代理模式的思想（事件源，和事件监听器有效分离）
- 基于回调的事件处理
    这种模式的事件源和事件监听器是在一体的，实现方式是通过集成GUI组件来重写对应方法
- 事件传递机制，采用责任链机制，如果Button的一的回调响应失败，这上报其父容器进行方法的实现
- 基于监听的事件处理模型更佳有优势。

### <a name="java025"> **Handle,Loop, MessageQueue的工作原理**
- Message: Handler接受和处理的消息对象
- Looper: 每个线程智能拥有一个Looper，他的loop方法负责读取MessageQueue中的消息，读到信息滞后就
把消息交给发送该消息的Handler进行处理。(类似于IOS中的Runloop,简单的理解为消息派遣和分发的消息中心)
- MessageQueue 消息队列，跟操作系统里面的消息队列概念一样，先进先出的管理方式

### <a name="java026"> **AsyncTask任务**
- 必须在UI线程中创建AsyncTask的实例
- 必须在UI线程中调用AsynTask的execute()方法
- 每个AsyncTask只能被执行一次，多次调用将会引发异常

## <a name="20151214"> **2015年12月14日**
### <a name="java027"> **Action，Category，Data，Type的作用**
- Action简单来说是一个字符串表示的动作，可以通过给Intent设定Action对应的标示，
从而启动与标示匹配的Activity等组件(若有多个Action，则匹配一个表示，就有可能被启动)
- Catagory 是和Action搭配使用的一个属性，当Action和Category均匹配的时候就可以启动对应的组件
- Data通常向Action属性提供操作的数据，Data属性接受一个Uri对象
- Type属性用于指定Data属性所指的Uri对应的MiME类型。
- Data 可以简单理解为对匹配规则的又一层过滤（通常Data和Action结合使用，来打开特定界面）
### <a name="java028"> **Android的数据存储与IO**
- SharePreferences 方式进行轻量级的数据存储（跟IOS中的NSUserDefault一样）
- File存储（IO流,跟java中的FileInputStream和FileOutputStream一样）
- SQLite数据库操作方式

## <a name="20151215"> **2015年12月15日**

### <a name="java029"> **Android中的ContentProvider**
- Uri 的了解（跟URl资源定位符一样）
  content:// 类似于http://
  org.xxx.xxx.xx 类似于域名
  words 类似于url中的所带有参数
- ContentProvider 可以看作一个提供数据的“服务器”
- ContentResolver 可以看作一个操作数据的“客户端”
- ContentResolver所做的操作，通过Uri标示，在Contentprovider里面做响应的操作
- ContentObserver负责监听ContentProvider数据的改变

### <a name="java030"> **Android中的Service详解**
- 启动Service的方式
  startService（）方法通过该方法启动Service，访问者与Service之间没有关联，即使访问者
  一旦退出了，Service也仍然运行。
  bindService（）方法：使用该方法启动Service，访问者与Service绑定在一起，访问者一旦退出了，Service也
  仍然运行。
- 注意：Android5.0开始以后，Google要求必须使用显示的Intent启动Service组件
- 一般情况下想要鱼Service进行通信，通过返回的IBinder进行实现，IBinder对象，类似于Service组件
  的内部钩子。
- IntentService会创建单独的worker线程来处理所有的Intent的请求
- IntentService会创建单独的worker线程来处理onHandleIntent（）方法实现的代码，因此开发者
无需处理多线程的问题。
- BroadcastReceiver

### <a name="java031"> **Android中的多媒体应用**
- MediaPlayer类中细节
  prepare（）装载资源会阻塞UI线程
  prepareAsync（）是异步的，它不会阻塞UI线程
- AudioEffect 主要控制音效
- SoundPool 主要控制音效的播放。采用内存池的概念来管理多个短促的音效。
  另外SoundPool还支持自行设置声音的品质，音量，播放比率等参数。

## <a name="20151216"> **2015年12月16日**

### <a name="java032"> **Android中的网络应用**
- 使用Socket进行通信
 Socket  accept()此操作会阻塞线程。
 ServerSocket 用于用与监听Socket的连接请求（跟普通的socket编程一样）
- 使用URL访问网络资源
 可以理解URL是URI的特例，可以很方便读取远程资源
- 使用URLConnetion提交网络请求（跟IOS中的NSConnection类似）
- 使用HttpURLConnetion是对URLConnetion的进一步封装，使用更佳方便。
- HttpClient 更加强大的网络类，封装了常用的方法，使用较为简单。

## <a name="20151222"> **2015年12月22日**

### <a name="java033"> **Android中的常用单位**
- Px（Pixel像素）：不同设备显示效果相同。这里的“相同”是指像素数不会变，比如指定UI长度是100px，那不管分辨率是多少UI长度都是100px。也正是因为如此才造成了UI在小分辨率设备上被放大而失真，在大分辨率上被缩小。
 
- Screen Size（屏幕尺寸）：一般所说的手机屏幕大小如1.6英寸、1.9英寸、2.2英寸，都是指的对角线的长度，而不是手机面积。我们可以根据勾股定理获取手机的宽和长，当然还有面积。
 
- Resolution（分辨率）:指手机屏幕垂直和水平方向上的像素个数。比如分辨率是480*320，则指设备垂直方向有480个像素点，水平方向有320个像素点。
 
- Dpi（dots per inch 像素密度）:指每英寸中的像素数。如160dpi指手机水平或垂直方向上每英寸距离有160个像素点。假定设备分辨率为320*240，屏幕长2英寸宽1.5英寸，dpi=320/2=240/1.5=160
 
- Density（密度）:指每平方英寸中的像素数。Density=Resolution/Screen size。注意：在DisplayMetrics类中属性density的值为dpi/160，可用于px与dip的互相转换。
 
- Dip（Device-independent pixel，设备独立像素）:同dp，可作长度单位，不同设备有不同的显示效果,这个和设备硬件有关，一般我们为了支持WVGA、HVGA和QVGA 推荐使用这个，不依赖像素。dip和具体像素值的对应公式是dip值 =dpi/160* pixel值，可以看出在dpi（像素密度）为160dpi的设备上1px=1dip
 
- Sp（ScaledPixels 放大像素）：主要用于字体显示（best for textsize）。根据 google 的建议，TextView 的字号最好使用 sp 做单位，而且查看TextView的源码可知 Android 默认使用 sp 作为字号单位。


## <a name="20160105"> **2016年1月5日**

### <a name="java034"> **Android合理的管理内存**
- 节制的使用Service
- 当界面不可见时释放内存
- 避免在Bitmap上浪费内存
- 使用优化过的数据集合
- 知晓内存的开支情况
我们还应当清楚我们所使用语言的内存开支和消耗情况，并且在整个软件的设计和开发当中都应该将这些信息考虑在内。可能有一些看起来无关痛痒的写法，结果却会导致很大一部分的内存开支，例如：使用枚举通常会比使用静态常量要消耗两倍以上的内存，在Android开发当中我们应当尽可能地不使用枚举。任何一个Java类，包括内部类、匿名类，都要占用大概500字节的内存空间。任何一个类的实例要消耗12-16字节的内存开支，因此频繁创建实例也是会一定程序上影响内存的。在使用HashMap时，即使你只设置了一个基本数据类型的键，比如说int，但是也会按照对象的大小来分配内存，大概是32字节，而不是4字节。因此最好的办法就是像上面所说的一样，使用优化过的数据集合。
详情参考：[Android合理的内存管理](http://blog.csdn.net/guolin_blog/article/details/26365913)

## <a name="20160111"> **2016年1月11日**

### <a name="java035"> **Android中的DataBinding技术**
- DataBinding表达式
Data Binding layout文件有点不同的是：起始根标签是 `layout`，接下来一个 `data` 元素以及一个 `view` 的根元素。这个 `view` 元素就是你没有使用Data Binding的layout文件的根元素。举例说明如下：

```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"/>
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.lastName}"/>
   </LinearLayout>
</layout>

```
在 data 内描述了一个名为user的变量属性，使其可以在这个layout中使用：

```
<variable name="user" type="com.example.User"/>
```
- Data对象
任何Plain old Java object（PO​​JO）可用于Data Binding，但修改POJO不会导致UI更新。Data Binding的真正能力是当数据变化时，可以通知给你的Data对象。有三种不同的数据变化通知机制：Observable对象、ObservableFields以及observable collections。
**Observable 字段**
一些小工作会涉及到创建Observable类，因此那些想要节省时间或者几乎没有几个属性的开发者可以使用ObservableFields。ObservableFields是自包含具有单个字段的observable对象。它有所有基本类型和一个是引用类型。要使用它需要在data对象中创建public final字段：
```
private static class User extends BaseObservable {
   public final ObservableField<String> firstName =
       new ObservableField<>();
   public final ObservableField<String> lastName =
       new ObservableField<>();
   public final ObservableInt age = new ObservableInt();
}
```
就是这样，要访问改值，使用set和get方法。

```
user.firstName.set("Google");
int age = user.age.get();
```
详细内容参阅[DataBinding技术](http://segmentfault.com/a/1190000002876984)

## <a name="20160113"> **2016年1月13日**

### <a name="java036"> **Android中的Reference**
- Reference
是一个抽象类，而 SoftReference，WeakReference，PhantomReference 以及 FinalReference 都是继承它的具体类

- StrongReference：
我们都知道 JVM 中对象是被分配在堆（heap）上的，当程序行动中不再有引用指向这个对象时，这个对象就可以被垃圾回收器所回收。这里所说的引用也就是我们一般意义上申明的对象类型的变量（如 String, Object, ArrayList 等），区别于原始数据类型的变量（如 int, short, long 等）也称为强引用。
```
String tag = new String("T");
```
强引用可以直接访问目标对象。
强引用可能导致内存泄漏。

- SoftReference：
SoftReference 在“弱引用”中属于最强的引用。SoftReference 所指向的对象，当没有强引用指向它时，会在内存中停留一段的时间，垃圾回收器会根据 JVM 内存的使用情况（内存的紧缺程度）以及 SoftReference 的 get() 方法的调用情况来决定是否对其进行回收。（后面章节会用几个实验进行阐述）
具体使用一般是通过 SoftReference 的构造方法，将需要用弱引用来指向的对象包装起来。当需要使用的时候，调用 SoftReference 的 get() 方法来获取。当对象未被回收时 SoftReference 的 get() 方法会返回该对象的强引用。如下：
```
SoftReference<Bean> bean = new SoftReference<Bean>(new Bean("name", 10));   
System.out.println(bean.get());// “name:10”  
```
软引用使用 get() 方法取得对象的强引用从而访问目标对象。
软引用所指向的对象按照 JVM 的使用情况（Heap 内存是否临近阈值）来决定是否回收。
软引用可以避免 Heap 内存不足所导致的异常。
当垃圾回收器决定对其回收时，会先清空它的 SoftReference，也就是说 SoftReference 的 get() 方法将会返回 null，然后再调用对象的 finalize() 方法，并在下一轮 GC 中对其真正进行回收。

- WeakReference：
WeakReference 是弱于 SoftReference 的引用类型。弱引用的特性和基本与软引用相似，区别就在于弱引用所指向的对象只要进行系统垃圾回收，不管内存使用情况如何，永远对其进行回收（get() 方法返回 null）。
弱引用使用 get() 方法取得对象的强引用从而访问目标对象。
一旦系统内存回收，无论内存是否紧张，弱引用指向的对象都会被回收。
弱引用也可以避免 Heap 内存不足所导致的异常。

### <a name="java037"> **Android中的Handle，Runnable，Timertask作用**
- Android中的单线程模型：Android UI操作并不是线程安全的并且这些操作必须在UI线程中执行。（IOS同理）
- Handler：Handler来根据接收的消息，处理UI更新。Thread线程发出Handler消息，通知更新UI。
- Runnable：是一种接口，常常可以作为new Thread（Runnable ～）来使用。
```
Handler myHandler = new Handler() {  
          public void handleMessage(Message msg) {   
               switch (msg.what) {   
                    case TestHandler.GUIUPDATEIDENTIFIER:   
                         myBounceView.invalidate();  
                         break;   
               }   
               super.handleMessage(msg);   
          }   
     };
```

```
class myThread implements Runnable {   
          public void run() {  
               while (!Thread.currentThread().isInterrupted()) {    

                    Message message = new Message();   
                    message.what = TestHandler.GUIUPDATEIDENTIFIER;   

                    TestHandler.this.myHandler.sendMessage(message);   
                    try {   
                         Thread.sleep(100);    
                    } catch (InterruptedException e) {   
                         Thread.currentThread().interrupt();   
                    }   
               }   
          }   
     }
```
- Timertask: 配合定时器Timer使用，较Thread轻量级。
```
public class JavaTimer extends Activity {  

    Timer timer = new Timer();  
    TimerTask task = new TimerTask(){   
        public void run() {  
            setTitle("hear me?");  
        }            
    };  

    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  

         timer.schedule(task, 10000);  

    }  
}
```
- TimerTask+Handler:模拟出定时器
```
public class TestTimer extends Activity {  

    Timer timer = new Timer();  
    Handler handler = new Handler(){   
        public void handleMessage(Message msg) {  
            switch (msg.what) {      
            case 1:      
                setTitle("hear me?");  
                break;      
            }      
            super.handleMessage(msg);  
        }  

    };  

    TimerTask task = new TimerTask(){    
        public void run() {  
            Message message = new Message();      
            message.what = 1;      
            handler.sendMessage(message);    
        }            
    };  

    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  

        timer.schedule(task, 10000);  
    }  
}
```
- Runnable + Handler.postDelayed(runnable,time)
```
private Handler handler = new Handler();  

    private Runnable myRunnable= new Runnable() {    
        public void run() {  

            if (run) {  
                handler.postDelayed(this, 1000);  
                count++;  
            }  
            tvCounter.setText("Count: " + count);  

        }  
    };
```
- 知识点补充：
很多初入Android或Java开发的新手对Thread、Looper、Handler和Message仍然比较迷惑，衍生的有HandlerThread、java.util.concurrent、Task、AsyncTask，今天就这一问题做更系统性的总结。我们创建的Service、Activity以及Broadcast均是一个主线程处理，这里我们可以理解为UI线程。但是在操作一些耗时操作时，比如I/O读写的大文件读写，数据库操作以及网络下载需要很长时间，为了不阻塞用户界面，出现ANR的响应提示窗口，这个时候我们可以考虑使用Thread线程来解决。
对于从事过J2ME开发的程序员来说Thread比较简单，直接匿名创建重写run方法，调用start方法执行即可。或者从Runnable接口继承，但对于Android平台来说UI控件都没有设计成为线程安全类型，所以需要引入一些同步的机制来使其刷新，这点Google在设计Android时倒是参考了下Win32的消息处理机制。

1. 对于线程中的刷新一个View为基类的界面，可以使用postInvalidate()方法在线程中来处理，其中还提供了一些重写方法比如postInvalidate(int left,int top,int right,int bottom) 来刷新一个矩形区域，以及延时执行，比如postInvalidateDelayed(long delayMilliseconds)或postInvalidateDelayed(long delayMilliseconds,int left,int top,int right,int bottom) 方法，其中第一个参数为毫秒

2. 当然推荐的方法是通过一个Handler来处理这些，可以在一个线程的run方法中调用handler对象的 postMessage或sendMessage方法来实现，Android程序内部维护着一个消息队列，会轮训处理这些，如果你是Win32程序员可以很好理解这些消息处理，不过相对于Android来说没有提供 PreTranslateMessage这些干涉内部的方法。

3. Looper又是什么呢? ，其实Android中每一个Thread都跟着一个Looper，Looper可以帮助Thread维护一个消息队列，但是Looper和Handler没有什么关系，我们从开源的代码可以看到Android还提供了一个Thread继承类HanderThread可以帮助我们处理，在HandlerThread对象中可以通过getLooper方法获取一个Looper对象控制句柄，我们可以将其这个Looper对象映射到一个Handler中去来实现一个线程同步机制，Looper对象的执行需要初始化Looper.prepare方法就是昨天我们看到的问题，同时推出时还要释放资源，使用Looper.release方法。

4.Message 在Android是什么呢? 对于Android中Handler可以传递一些内容，通过Bundle对象可以封装String、Integer以及Blob二进制对象，我们通过在线程中使用Handler对象的sendEmptyMessage或sendMessage方法来传递一个Bundle对象到Handler处理器。对于Handler类提供了重写方法handleMessage(Message msg) 来判断，通过msg.what来区分每条信息。将Bundle解包来实现Handler类更新UI线程中的内容实现控件的刷新操作。相关的Handler对象有关消息发送sendXXXX相关方法如下，同时还有postXXXX相关方法，这些和Win32中的道理基本一致，一个为发送后直接返回，一个为处理后才返回 .

5. java.util.concurrent对象分析，对于过去从事Java开发的程序员不会对Concurrent对象感到陌生吧，他是JDK 1.5以后新增的重要特性作为掌上设备，我们不提倡使用该类，考虑到Android为我们已经设计好的Task机制，这里不做过多的赘述，相关原因参考下面的介绍:

6. 在Android中还提供了一种有别于线程的处理方式，就是Task以及AsyncTask，从开源代码中可以看到是针对Concurrent的封装，开发人员可以方便的处理这些异步任务。
## <a name="20160114"> **2016年1月14日**

### <a name="java038"> **Android中的Task和AsynTask**
- Task:Task可以理解为实现一个功能而负责管理所有用到的Activity实例的栈
- AsyncTask：是android提供的轻量级的异步类。相比Handler轻量级。
- 首先明确Android之所以有Handler和AsyncTask，都是为了不阻塞主线程（UI线程），且UI的更新只能在主线程中完成，因此异步处理是不可避免的。
Android为了降低这个开发难度，提供了AsyncTask。AsyncTask就是一个封装过的后台任务类，顾名思义就是异步任务。AsyncTask直接继承于Object类，位置为android.os.AsyncTask。要使用AsyncTask工作我们要提供三个泛型参数，并重载几个方法(至少重载一个)。
AsyncTask定义了三种泛型类型 Params，Progress和Result。
Params 启动任务执行的输入参数，比如HTTP请求的URL。
Progress 后台任务执行的百分比。
Result 后台执行任务最终返回的结果，比如String。
使用过AsyncTask 的同学都知道一个异步加载数据最少要重写以下这两个方法：

doInBackground(Params…) 后台执行，比较耗时的操作都可以放在这里。注意这里不能直接操作UI。此方法在后台线程执行，完成任务的主要工作，通常需要较长的时间。在执行过程中可以调用publicProgress(Progress…)来更新任务的进度。
onPostExecute(Result)  相当于Handler 处理UI的方式，在这里面可以使用在doInBackground 得到的结果处理操作UI。 此方法在主线程执行，任务执行的结果作为此方法的参数返回
有必要的话你还得重写以下这三个方法，但不是必须的：

onProgressUpdate(Progress…)   可以使用进度条增加用户体验度。 此方法在主线程执行，用于显示任务执行的进度。
onPreExecute()        这里是最终用户调用Excute时的接口，当任务执行之前开始调用此方法，可以在这里显示进度对话框。
onCancelled()             用户调用取消时，要做的操作
使用AsyncTask类，以下是几条必须遵守的准则：

Task的实例必须在UI thread中创建；
execute方法必须在UI thread中调用；
不要手动的调用onPreExecute(), onPostExecute(Result)，doInBackground(Params...), onProgressUpdate(Progress...)这几个方法；
该task只能被执行一次，否则多次调用时将会出现异常；

### <a name="java039"> **Android中的动画**
- valueAnimator :可以理解为一款动画过渡器。
- ObjectAnimator:是继承自valueAnimator的一个类，对属性进行范围控制，用法如下：
```
ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "alpha", 1f, 3f, 1f);  
animator.setDuration(5000);  
animator.start();  
```
但是，仔细会发现，textView中并没有alpha属性，这是因为，设置属性的时候是根据访存器来的。

## <a name="20160115"> **2016年1月15日**
### <a name="java040"> **Android中的synchronized详解**
- synchronized 关键字，代表这个方法加锁,相当于不管哪一个线程A每次运行到这个方法时,都要检查有没有其它正在用这个方法的线程B（或者C D等）,有的话要等正在使用这个方法的线程B（或者C D）运行完这个方法后再运行此线程A,没有的话,直接运行它包括两种用法：synchronized 方法和 synchronized 块
**synchronized 方法**
```
public synchronized void accessVal(int newVal);
```
synchronized 方法控制对类成员变量的访问：每个类实例对应一把锁，每个 synchronized方法都必须获得调用该方法的类实例的锁方能执行，否则所属线程阻塞，方法一旦执行，就独占该锁，直到从该方法返回时才将锁释放，此后被阻塞的线程方能获得该锁，重新进入可执行状态。这种机制确保了同一时刻对于每一个类实例，其所有声明为 synchronized的成员函数中至多只有一个处于可执行状态（因为至多只有一个能够获得该类实例对应的锁），从而有效避免了类成员变量的访问冲突（只要所有可能访问类成员变量的方法均被声明为 synchronized）。　

**synchronized 块**
```
synchronized(syncObject)
{　　
//允许访问控制的代码　　
}　
```
一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。　　
二、当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。　　
三、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的除synchronized(this)同步代码块以外的部分。　
四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
　　
**synchronized的一个简单例子**
```
public class TextThread
{
/**
* @param args
*/
public static void main(String[] args)
{
// TODO 自动生成方法存根
        TxtThread tt = new TxtThread();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
}
}
class TxtThread implements Runnable
{
int num = 100;
String str = new String();
public void run()
{
while (true)
{
   synchronized(str)
   {
   if (num>0)
   {
    try
    {
     Thread.sleep(10);
    }
    catch(Exception e)
    {
     e.getMessage();
    }
    System.out.println(Thread.currentThread().getName()+ "this is "+ num--);
   }
   }
}
}
}
```

### <a name="java041"> **AIDL介绍**
- 为使应用程序之间能够彼此通信，Android提供了IPC （Inter Process Communication，进程间通信）的一种独特实现： AIDL （Android Interface Definition Language，Android接口定义语言）在Android中，每个应用（Application）执行在它自己的进程中，无法直接调用到其他应用的资源，这也符合“沙箱”的理念。所谓沙箱原理，一般来说用在移动电话业务中，简单地说旨在部分地或全部地隔离应用程序。详细用法参阅[AIDL详解](http://bbs.51cto.com/thread-1086040-1.html)

**具体用法**
- 定义一个AIDL接口
- 为远程服务（service）实现对应Stub
- 将服务"暴露"给客户端程序使用

## <a name="20160120"> **2016年1月20日**
### <a name="java042"> **Android中LayoutInflater详解**
- LayoutInflater到底干了啥？
故名思意，是用来解释布局的。而我们仅仅利用inflate方法，就可以将一个极其复杂的xml文件，解析出来。其实真正起作用的是，inflate内部利用[pull方式](http://www.cnblogs.com/JerryWang1991/archive/2012/02/24/2365507.html)进行了xml的解析
另付：[LayoutInflater详解](http://blog.csdn.net/guolin_blog/article/details/12921889)
### <a name="java043"> **Android中View绘制详解**
- View是怎样被绘制的？
每一个视图的绘制过程都必须经历三个最主要的阶段，即onMeasure()、onLayout()和onDraw()View系统的绘制流程会从ViewRoot的performTraversals()方法中开始，在其内部调用View的measure()方法。measure()方法接收两个参数，widthMeasureSpec和heightMeasureSpec，这两个值分别用于确定视图的宽度和高度的规格和大小.MeasureSpec的值由specSize和specMode共同组成的，其中specSize记录的是大小，specMode记录的是规格。specMode一共有三种类，EXACTLY，AT_MOST,UNSPECIFIED.
详情参考:[View的绘制过程](http://blog.csdn.net/guolin_blog/article/details/16330267)


## <a name="20160121"> **2016年1月21日**
### <a name="java044"> **Java中的反射机制简单应用**
－ 什么是反射机制？
   反射机制就是可以把一个类,类的成员(函数,属性),当成一个对象来操作,希望读者能理解,也就是说,类,类的成员,我们在运行的时候还可以动态地去操作他们
－ 反射机制的作用？
   简单的来说，就是可以增加编程的灵活性，最常用应用就是ClassFromClassName这种应用。具体详细参考[反射机制](http://blog.csdn.net/coder_pig/article/details/44784399)


## <a name="20160122"> **2016年1月22日**
### <a name="java045"> **MVVM模式，MVC模式，MVP**
