package com.jiaozhijun.maven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Random;

public class CovariantArrayType
{
    public static void main(String[] args) {
        for(;;) {
            try {
                String num=getRS(14);
                String url = "http://redbull.hxrdcode.com/template/verify/verify.html?codeString="+num+"&flag=1";
                Document doc = null;
                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("错误"+url);

                }
                String con = doc.getElementsByClass("dc").text();
                if (!con.equals("数据已激活") && !con.equals("错误数据")) {
                    System.out.println(con);
                    System.out.println(url);


                } else {

                }
            } catch (Exception e) {
                //System.out.println("错误");
            }
        }
    }

    //方法1：length为产生的位数
    public static String getRS(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(36);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }
}
