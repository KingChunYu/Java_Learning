
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
## <a name="20151202"> **2015年12月8日**
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
