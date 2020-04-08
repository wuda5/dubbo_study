package com.luban.dubbo_vip_xml_demo.consumer;

public class test {

    public static void main(String[] args) {

        System.out.println(test1());
    }

    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block---1 ");
//            int x = b/0;

            return b += 80;
        }
        catch (Exception e) {

            System.out.println("catch block----2");
        }
        finally {

            System.out.println("finally block-----3 ---finally");
                return  b+100; //测试家和不加--还要结合是否异常来看
//                return 33; //测试家和不加

        }

//        return b;
    }

}