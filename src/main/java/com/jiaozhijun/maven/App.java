package com.jiaozhijun.maven;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        StringBuffer sb = new StringBuffer("dfdsfads,");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    public String say(){
        return "hello";
    }
}
