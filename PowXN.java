/***
 * Implement pow(x, n).
 * Ignore case when x < 0, n % 2 euqls 0, and n < 0;
 */
public class PowXN{

    public double pow(double x, int n) {
        if (n == 0)
            return 1.0;
///*
        //binary power
        double half = pow(x, n/2);
        if(n % 2 == 0){
            return half * half;
        }else if (n > 0){
            return half * half * x;
        }else{
            return half * half / x;
        }
//*/
    }
    public static void main(String[] args){
        PowXN powxn = new PowXN();

        System.out.format("5e0 is: %f\n", powxn.pow(5, 0));
        System.out.format("3e-1 is: %f\n", powxn.pow(3, -1));
        System.out.format("2e4 is: %f\n", powxn.pow(2, 4));
    }

}
