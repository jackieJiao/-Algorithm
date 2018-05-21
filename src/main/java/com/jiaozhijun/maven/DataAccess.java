package com.jiaozhijun.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
    数据存取
    假设数组元素map的key value都是String
 */
public class DataAccess {
    public static void main(String[] args) {
        DataAccess dataAccess=new DataAccess();
        //手动生成一个数组
        HashMap[] a= dataAccess.getArrayA();
        //store
        String text=dataAccess.store(a);
        //load
        HashMap[] b= load(text);

    }

    private static HashMap[] load(String text) {
        System.out.println("This is in load Method");
        String[] stringArray=text.split("\\\\n");
        HashMap[] b=new HashMap[stringArray.length];
        for (int i=0;i<b.length;i++
                ) {
            HashMap hashmap=getMapFromString(stringArray[i]);
            b[i]=hashmap;
        }
        System.out.println(stringArray.length);
        System.out.println(stringArray[0]);
        return  b;
    }

    private static HashMap getMapFromString(String s) {
        HashMap hashMap=new HashMap();
        for (String string:s.split(";")
             ) {
                hashMap.put(string.split("=")[0],string.split("=")[1]);
        }
        return hashMap;
    }

    private HashMap[] getArrayA() {
        HashMap[] a;
        a=new HashMap[2];
        HashMap map1=new HashMap();
        map1.put("key1","value1");
        map1.put("key2","value2");
        HashMap map2=new HashMap();
        map2.put("keyA","valueA");
        a[0]=  map1;
        a[1]=  map2;
        return a;
    }

    private String store(HashMap[] a) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<a.length;i++
             ) {//循环，组装每一个hashmap，键值对之间用分号隔开，去掉最后一个分号。
            Iterator iter= a[i].keySet().iterator();
            StringBuilder builer=new StringBuilder();
            while (iter.hasNext()){
                String key=(String)iter.next();
                String value= (String) a[i].get(key);
                builer.append(key+"="+value+";");
            }
            stringBuilder.append(builer);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append("\\n");
        }
        return stringBuilder.toString();
    }
}
