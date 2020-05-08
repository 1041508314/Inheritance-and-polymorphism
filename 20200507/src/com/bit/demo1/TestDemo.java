package com.bit.demo1;

/**
 * @program: 20200507
 * @description
 * @author: LiuXinYu
 * @create: 2020-05-07 14:50
 **/
class Animal{
    protected String name;

    public Animal(String name){
        this.name = name;
        System.out.println("Animal(String)");
    }
    //子类在构造的时候 要先帮助父类进行构造

    public void eat(){

        System.out.println(this.name + "Animal::eat()");
    }
    private void sleep(){

        System.out.println("Animal::sleep()");
    }
}

//1.在java中，使用关键字extends只能继承一个类
//2.对于父类的private字段和方法，子类中是无法访问的，并不是说没有被继承

class Cat extends Animal{//继承 可以达到代码的复用
    //子类继承了父类除构造方法外的所有
    public Cat(String name){//子类在构造的时候 要先帮助父类进行构造
        super(name);//显式调用父类的东西      //必须放到第一行
        System.out.println("Cat(String)");
        //this和super的区别
        //this 当前对象的引用
        //this（） 调用本类其他的构造方法
        //this.data 访问当前类当中的属性
        //this.func() 调用本类的其他的成员方法

        //super代表父类对象的引用
        //super() 调用父类的构造方法
        //super.data 访问父类的属性
        //super.func() 访问父类的成员方法
    }
//    public String name;
//    public void eat(){
//        System.out.println("Cat::eat()");
//    }
}
final class ChineseGardenCat extends Cat{
    //final int a = 10   修饰常量 只能被初始化一次，接下来就不能被修改了
    //final修饰类  密封类  特性：不能被继承了    一旦一个类被final所修饰，那么这个类必然不能被继承
    public ChineseGardenCat(String name) {
        super(name);
    }//继承最多继承三次
}




class Bird extends Animal{

    public Bird(String name) {
        super(name);
    }

    public void fly(){

        System.out.println(this.name + "Bird::fly()");
    }
}

public class TestDemo {
    public static void main(String[] args) {

    }


    public static void main2(String[] args) {
        ChineseGardenCat chineseGardenCat = new ChineseGardenCat("haha");
        chineseGardenCat.eat();
    }

    public static void main1(String[] args) {
     Cat cat = new Cat("mimi");
     //cat.name = "mimi";
     cat.eat();//可以访问自己的
     Bird bird = new Bird("八哥");
     bird.fly();//可以访问自己的
     bird.eat();//可以访问父类的
    }
}
