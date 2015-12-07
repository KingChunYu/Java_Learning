package com.example;

// 设置单个泛性
class Point<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
//设置多个泛性

class Circle<T, K> {
    public Circle(T t, K k) {
        this.t = t;
        this.k = k;
    }

    private T t;
    private K k;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }
}

class Star<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Star{" +
                "t=" + t +
                '}';
    }
}
//泛性接口

public class MyClass {


    public static void main(String args[]) {
        //测试单个泛性
        Point<String> point = new Point<String>();
        point.setX("Hello");
        point.setY("World");
        System.out.println(point.getX());
        //测试多个泛性(泛性类型应当是对象object类型，不能使用常用的数据类型)
        Circle<String, Integer> circle = new Circle<String, Integer>("Wrold", 3);
        System.out.println(circle.getK());
        System.out.println(circle.getT());
        //通配符使用测试：
        Star<String> star = new Star<String>();
        star.setT("通配符测试成功");
        printStar(star);
        tell("泛性方法测试成功！");
    }

    public static void printStar(Star<?> star) {
        System.out.println(star.toString());
    }

    public static <T> void tell(T t) {
        System.out.println(t);
    }


}
