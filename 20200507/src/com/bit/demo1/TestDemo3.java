package com.bit.demo1;

/**
 * @program: 20200507
 * @description
 * @author: LiuXinYu
 * @create: 2020-05-07 15:37
 **/
class Test{
    int a;//默认权限--> 包访问权限 --> 只能在同一个包中访问
}
public class TestDemo3 {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);
    }
}
