package datastructure;

public class Euclid {
    public static void main(String[] args) {
        System.out.println(gcd(21,9));
    }

    private static long gcd(long i, long j) {

        while(j!=0) {
            long n = i % j;
            i = j;
            j = n;
        }
        return i;
    }
}
