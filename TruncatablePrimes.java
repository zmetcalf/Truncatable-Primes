import java.lang.Math;

public class TruncatablePrimes 
{
    private int[] truncArray = new int[11];
    
    public TruncatablePrimes() {  
    }
    
    public int getSumTruncatablePrimes() {
        int arrayCounter = 0;
        int primeCounter = 10;
        int sum = 0;
        
        while(arrayCounter < 11) {
            if(checkPrime(primeCounter)) {
                if(checkTruncatablePrime(primeCounter)) {
                    truncArray[arrayCounter] = primeCounter;
                    arrayCounter++;
                }
            }
            primeCounter++;
        }
        for(int i: truncArray) {
            sum += i;
        }
        return sum;
    }
    
    private boolean checkTruncatablePrime(int primeNum) {
        String wholeString = Integer.toString(primeNum);
        String testString = "";
        
        for(int i = 1; i < wholeString.length(); i++) {
            for(int x = i; x < wholeString.length(); x++) {
                testString = testString + wholeString.charAt(x);
            }
            if(checkPrime(Integer.valueOf(testString)) == false) {
               return false;
            }
            testString = "";
        }
        
        for(int i = 0; i < wholeString.length() - 1; i++) {
            for(int x = 0; x < wholeString.length() - i - 1; x++) {
                testString = testString + wholeString.charAt(x);
            }
            if(checkPrime(Integer.valueOf(testString)) == false) {
               return false;
            }
            testString = "";
        }
        return true;
    }
    
    private boolean checkPrime(int checkNum) {

        int i = 2;
        double maxCheck;

        if(checkNum == 1) {
            return false;
        }

	    maxCheck = Math.sqrt((double) checkNum);

	    while(i <= maxCheck) {
	        if(checkNum % i == 0) {
	            return false;
	        }
	        i++;
	    }
	    return true;
	}
}