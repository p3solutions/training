package IFClause;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        int start = 1;
        int end = 100;
        
        System.out.println("Prime numbers between " + start + " and " + end + " are:");
        
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i+" ");
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
       
        for (int i = 2; i <= (num/2); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

