// Write a Java program to find the nth prime number. 
// The value of n should be input by the user.

// Sample Input:
// ---------------
// 5

// Sample Output:
// -----------------
// 11

import java.util.*;

class PrimeFinder {

    public static int findNthPrime(int n) {
        // Implement this method.
        int num = 1;
        int count = 0;
        while(count < n){
            num++;
            if(isPrime(num)){
                count++;
            }
        }
        return num;
    }
    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = findNthPrime(n);
        System.out.println(result);
    }
}
