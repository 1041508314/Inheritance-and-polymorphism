package com.bit.demo3;




class Animal{
protected String name;
public Animal(String name){
        this.name = name;
        System.out.println("Animal(String)");
        }
public void eat(){
    System.out.println(this.name + "Animal::eat()");//与下面的eat方法构成重写
    }
private void sleep(){
    System.out.println("Animal::sleep()");
    }
}

//重载 overload：方法名相同 参数列表不同（参数的个数和类型） 返回值不做要求 同一个类当中
//重写 override：方法名相同 返回值相同 参数列表相同 在不同的类（继承关系上）
//关于重写需要注意的事项 ：  1.需要重写的方法 不能被final修饰  2.被重写的方法 访问修饰限定符一定不能是private
//                           3.被重写的方法 子类中的访问修饰限定要大于等于父类的访问修饰限定
//                           4.被static修饰的方法是不能被重写的

class Cat extends Animal {
    public int count = 99;
    public Cat(String name) {
        super(name);
        System.out.println("Cat(String)");
    }
    public void eat(){

        System.out.println(this.name + "一二三Cat::eat()");//与上面的eat方法构成重写
    }
}


class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }
    public void fly(){
        System.out.println(this.name + "Bird::fly()");
    }
}


public class TestMain {
    //注意 ： 在构造方法当中 可以发生动态绑定

    /**
     * 演示不安全的向下转型
     * @param args
     */
    public static void main(String[] args) {
        Animal animal = new Cat("八哥");

        if( animal instanceof  Bird){//instanceof   A instanceof B  代表判断A是B的一个实例
            //向下转型
            Bird bird = (Bird)animal;
            bird.fly();
        }else {
            System.out.println("sadasda");
        }

//        Bird bird = (Bird)animal;
//        bird.fly();//会发生类型转换异常
    }



    /**
     * 演示向下转型
     * 注意：向下转型非常不安全 很少会使用向下转型
     * @param args
     */
    public static void main6(String[] args) {
        Animal animal = new Bird("八哥");
        animal.eat();

        //animal.fly;// 是错误的

        //向下转型  父类的引用赋值给了子类
        Bird bird = (Bird)animal;
        bird.fly();
    }

    /**
     * 多态
     * 发生运行时绑定
     * 父类引用子类对象  同时通过父类引用调用同名的覆盖方法
     * 此时就会发生运行时绑定（也叫做动态绑定）
     * @param args
     */
    public static void main5(String[] args) {
        Animal animal = new Cat("咪咪");
        animal.eat();
    }


    //发生向上转型的时机
    //a。返回值
    //b。传参
    //c。直接赋值
    public static Animal func(){
//        Cat cat = new Cat("咪咪");
//        return cat;
        return new Cat("咪咪");
    }
    public static void main4(String[] args) {
        Animal animal = func();
        animal.eat();
    }


    public static void func(Animal animal){
        animal.eat();
    }
    public static void main3(String[] args) {
        Cat cat = new Cat("咪咪");
        func(cat);
    }



    //向上转型
    public static void main2(String[] args) {
        Animal animal = new Cat("咪咪");//向上转型 --》 父类引用 引用子类对象
        animal.eat();
        //animal.count 是错的
        // 向上转型后，通过父类的引用，只能访问父类自己的方法
        //父类引用只能访问自己特有的
    }


    public static void main1(String[] args) {
        Animal animal = new Animal("豆豆");
        Cat cat = new Cat("咪咪");
    }
}
