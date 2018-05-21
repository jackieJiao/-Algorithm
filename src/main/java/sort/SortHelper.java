package sort;

import java.util.Arrays;
import java.util.Random;

public class SortHelper {
    static  int testVR= 8;
    static  void settestvr(int a){
        testVR=a;
    }
    static int[] arr;
    /*
    * 生成一个随机数据
    * length 长度
    * maxint 最大值
    * */
    static int[] getRandomArray(int length,int maxInt) {
        arr=new int[length];
        for (int i=0;i<length;i++){
            Random random = new Random();
            arr[i]=random.nextInt(maxInt);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRandomArray(8,300)));
        System.out.println(Arrays.toString(getCopyArray()));

    }
    /*
    * return 上个数组的copy
    * */
    public static int[] getCopyArray() {
        return arr;
    }

    public static int[] getRandomArrayContainMinus() {
        //int [] a=new int[]{-2,11,-4,-5,-5,-2,9};
        int[] a=getRandomArray(100,100);
        int num=new Random().nextInt(100);
        for(int i=0;i<num;i++){
            int k=new Random().nextInt(100);
            if(a[k]>=0)
            a[k]=Integer.parseInt("-"+Integer.toString(a[k]));
        }
        return a;

    }
}
