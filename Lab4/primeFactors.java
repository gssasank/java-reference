package Lab4;
import Lab3.StackOfIntegers;

public class primeFactors {
    public static StackOfIntegers prime_factor(int num) {
        StackOfIntegers ans = new StackOfIntegers();
        if(num == 1){
            return ans;
        }
        int divisor = 2;
        while(divisor*divisor <= num && num > 1){
            while(num % divisor == 0){
                ans.push(divisor);
                num /= divisor;
            }
            divisor++;
        }
        if(num>1)
            ans.push(num);
        return ans;
    }
}

