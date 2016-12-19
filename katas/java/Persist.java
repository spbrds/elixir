
/********
Write a function, persistence, that takes in a positive parameter num and returns 
its multiplicative persistence, which is the number of times you must multiply 
the digits in num until you reach a single digit.

For example:

 persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
                      // and 4 has only one digit

 persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
                       // 1*2*6 = 12, and finally 1*2 = 2

 persistence(4) == 0 // because 4 is already a one-digit number
 
 avarage running 57ms
******/

class Persist {
	public static int persistence(long n) {
    boolean isOne = false;
		//first validation
    if(n<10){
      return 0;
    }
    
    //iterating
    int iterations = 0;
    long number = n;
    while(!isOne){
    
      iterations++;
      number = getLongFromString(number);
      isOne = (number < 10);
    }
    
    return iterations;
	}
  
  public static Long getLongFromString(long number){
    //iterating numbers that compose the "number"
      char[] charArr = ((Long)number).toString().toCharArray();
      long accumulator = 1;
      for(char c: charArr){
        accumulator *= new Long(""+c);
      }
      
      return accumulator;
  }
}