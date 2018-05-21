package sort;


import java.util.Arrays;

/*
* Cubic maximum contiguous subsequence sum algorithm
* */
public class MaxSubSum1 {
    public static void main(String[] args) {
        System.out.println(max3(5,10,1));
        int[] arr = SortHelper.getRandomArrayContainMinus();
        //test time
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            maxSubSum(arr);
        }
        System.out.println(maxSubSum(arr));
        long period = System.currentTimeMillis() - start;
        System.out.println("time" + Long.toString(period));

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            maxSubSum2(arr);
        }
        long period1 = System.currentTimeMillis() - start1;
        System.out.println("time" + Long.toString(period1));
        System.out.println(maxSubSum2(arr));
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            maxSubSum4(arr);
        }
        long period2 = System.currentTimeMillis() - start2;
        System.out.println("time" + Long.toString(period2));
        System.out.println(maxSubSum4(arr));
//        int[] arr=SortHelper.getRandomArrayContainMinus();
//        System.out.println(Arrays.toString(arr));
//        System.out.println(maxSubSum2(SortHelper.getCopyArray()));
//        System.out.println(maxSubSum2(arr));
    }
    public static int maxSubSum4(int[] arr){
        int maxsum=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            sum+=arr[i];
            if(sum>maxsum) maxsum=sum;
            else if(sum<0) sum=0;
        }
        return maxsum;
    }

    private static int maxSubSum(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                //sum=i+...+j,
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                if (sum > maxSum)
                    maxSum = sum;

            }
        }
        return maxSum;
    }

    public static int maxSubSum2(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }



    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right) // Base case
            if (a[left] > 0)
                return a[left];
            else
                return 0;

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

      return max3(maxLeftSum, maxRightSum,
               maxLeftBorderSum + maxRightBorderSum);

    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        return maxLeftSum>maxRightSum?(maxLeftSum>i?maxLeftSum:i):(maxRightSum>i?maxRightSum:i);
    }


    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

}
