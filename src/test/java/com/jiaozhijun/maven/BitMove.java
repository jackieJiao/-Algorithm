package com.jiaozhijun.maven;

public class BitMove {
    public static void main(String[] args) {
        /*System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(10>>>1));
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(100>>3));
        System.out.println(Integer.toBinaryString(100^10));
        System.out.println(100^10);*/
        long start=System.currentTimeMillis();
        for (int i=0;i<100000000;i++){
            int j=1000>>1;

        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
