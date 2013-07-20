public class TruncatablePrimesTest 
{
    public static void main(String[] args) 
    {
        TruncatablePrimes tPrimes = new TruncatablePrimes();
        System.out.printf("The sum of all Truncatable Primes is %d", 
                            tPrimes.getSumTruncatablePrimes());
    }
}