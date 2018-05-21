package com.jiaozhijun.maven;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
JSON格式转换 在某个特定应用场景中，我们有一个从JSON获取的内容，
比如： m = { "a": 1, "b": { "c": 2, "d": [3,4] } } 现在需要把这个层级的结构做展开，只保留一层key/value结构。
对于上述 输入，需要得到的结构是： o = {"a": 1, "b.c": 2, "b.d": [3,4] } 也就是说，
原来需要通过 m["b"]["c"] 访问的值，在展开后可以通过 o["b.c"] 访问。
请实现这个“层级结构展开”的代码。 输入：任意JSON（或者map/dict） 输出：展开后的JSON（或者map/dict）
 */
public class JsonRDim {
    static String m = "{ \"a\": 1, \"b\": { \"c\": { \"c\": 2, \"d\": [3,4] }, \"d\": { \"c\": 2, \"d\": [3,4] } } }";

    static Gson gson = new Gson();
    static Map<String, Object> mapOrigin = gson.fromJson(m, HashMap.class);

    static Map<String, Object> mapResult = new HashMap<>();

    public static void main(String[] args) {

        new JsonRDim().reduction(mapOrigin);

        for (String key : mapResult.keySet()) {
            System.out.println(key + "-------" + mapResult.get(key));
        }

    }

    //使用递归
    private void reduction(Map<String, Object> mapOrigin) {
        Iterator iter = mapOrigin.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            Object value = mapOrigin.get(key);
            if (isDone(value)) {
                mapResult.put(key, value);
            } else {//降低维度1次后产生的mapTemp，递归

                Map<String, Object> mapValue = gson.fromJson(value.toString(), HashMap.class);
                Map<String, Object> mapTemp = new HashMap<>();
                Iterator iter1 = mapValue.keySet().iterator();
                while (iter1.hasNext()) {
                    String key1 = (String) iter1.next();
                    Object value1 = mapValue.get(key1);
                    mapTemp.put(key + "." + key1, value1);
                }
                reduction(mapTemp);

            }
        }
    }
    //该方法可以优化
    private boolean isDone(Object value) {

        if (value.toString().startsWith("{"))
            return false;
        else return true;
    }
}
