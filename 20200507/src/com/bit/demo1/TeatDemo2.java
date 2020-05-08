package com.bit.demo1;

/**
 * @program: 20200507
 * @description
 * @author: LiuXinYu
 * @create: 2020-05-07 15:03
 **/
class Base{
    public int a;
}
class Derive extends Base{
    public int b;
}
public class TeatDemo2 {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);
    }

    public static void main1(String[] args) {
        Derive derive = new Derive();
        derive.a = 99;
    }
}
