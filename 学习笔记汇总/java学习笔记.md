Title:走一步，再走一步！

[TOC]
# **JAVA-学习笔记汇总**
作为java学习过程中的笔记承载文件
## **2015年12月2日～2015年12月4日**
### **java 小知识点：**
- 接受控制台数据，利用Scanner类即可，具体用法查询API手册输入输出：name ＝ sccaner（）；
- Debug调试,跟xcode一样（改下快捷键)
- 调试小技巧 ,自动对其（cmd＋alt＋L）等，注意调试细节，堆栈调试
- java编译过程   -     java文件-javac.exe-.class文件-java.exe解释器-内存方法区，静态方法创建
- Static ，与类的生命周期相同。由java虚拟机自动初始化。使用static方法的时候，只能访问static声明的变量和方法。静态方法尽量用类名来调用。
- 访问权限（private，public，default，protect）类似于c++，不过访问权限牵涉到一个包的概念

### **java 面向对象思想（多态，继承，封装）**
- 方法重载
类似于C++的重载规则（注意点就是返回值不同，不算重载）
- 方法递归规则
类似于c++中的方法递归
- 内存（堆，栈，思想）

### **java封装性**
- 保护属性和方法不被外部看见（类似于ios中的访存器）
- 构造方法与c＋＋类似
- 匿名对象的使用类似于：new people().age；
- 引用传递的概念，其实就是一个别名;
- 还有这种用法this();

### **java继承性**
- 继承主要是扩展父类的功能
- 基本语法时 class 子类 extends 父类｛｝
-继承的限制（只允许单继承，子类不能直接访问父类私有成员）
- 方法重写：类似于C++中的方法覆盖，子类有优先权，覆盖父类的方法。
- super 指向父类的指针。

### **java抽象类，final关键字，接口**
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


### **java常用类：**
- String类，比较用equals（）函数
- StringBuffer类，是个操作类，缓冲区也是操作字符串（其实类似于可改变的字符串，NSMutableString）
- StringBuilder，用在字符串缓冲区被单个使用的时候，建议优先考虑该类。（其实类似于StringBuffer的简单替换）

### **java多态性：**
- 父类指向子类和C++一样，子类指向父类会有一些区别。
- java中有一个instanceof关键字判断一个对象到底是不是一个类的实例。（类似于ios中isclassof）用法： （a instanceof A）返回值boolean类型。
- 抽象类中还可以实现方法，跟C++有所不同，还要记住一点，无论什么时候，最好不要继承一个完成好的类。

### **Note！Note！Note!**
- java中的当有类继承自接口，可以视为interface是父类（这样不严谨，但是多态行为，和继承自父类一样）

### **java异常**
- 利用try catch来捕获
- throws关键字 抛出异常，抛出上层函数，类似于责任链机制。
- 看参考视频

## **2015年12月7日**

### **java泛型**
- 认识泛性（跟c+＋中的模版template一样）
- java中的泛型有通配符的概念？
- java也有类似于C++中的泛型数组，泛型方法。详情见代码清单

### **java集合-collection**
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

** java中的文件类
- File类
