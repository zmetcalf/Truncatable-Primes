import java.lang.Math;

public class TruncatablePrimes 
{
    private int[] truncArray = new int[11];
    
    public TruncatablePrimes() {  
    }
    
    public int getSumTruncatablePrimes() {
        int arrayCounter = 0;
        int primeCounter = 100;
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
        char[] destArray;
        String primeString = Integer.toString(primeNum);
        String testString;
        int initializeInt;
        
        for(int i = 0; i < primeString.length() - 1; i++) {
            initializeInt = primeString.length() - i;
            destArray = new char[initializeInt];
            primeString.getChars(i, primeString.length() - 1, destArray, 0);
            testString = new String(destArray);
            if(checkPrime(Integer.valueOf(testString)) == false) {
               return false;
            }
        }
        
        return true;
    }
    
    private boolean checkPrime(int checkNum) {
        int i = 2;
	    double maxCheck;

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