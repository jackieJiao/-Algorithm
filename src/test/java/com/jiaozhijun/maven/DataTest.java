package com.jiaozhijun.maven;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class DataTest {
    public static void main(String[] args) {
        System.out.println((transformTimeToStamp("20/Dec/2017:04:13:53")-transformTimeToStamp("20/Dec/2017:04:10:53"))+"ms");
    }

    public static long transformTimeToStamp(String time){
        new HashMap<>();
        SimpleDateFormat old_sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        //SimpleDateFormat new_sdf = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss",Locale.US);
        Date date = null;
        try {
            date = old_sdf.parse(time);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
