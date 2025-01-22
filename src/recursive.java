
public class recursive {
	
		int additionSum = 0;
		int powerSum = 1;
		public int addition(int number) {
			if(number == 0) {
				return additionSum;
			}
			else {
				additionSum += number;
				number --;
				return(addition(number));
			}
		}
		
		public int power(int base, int p) {
			if(base == 0 && p == 0) {
				return -1;
			}
			else if(base == 0 && p != 0) {
				return 0;
			}
			else if(base != 0 && p == 0) {
				return powerSum;
			}
			else {
				powerSum *= base;
				p --;
				return(power(base, p));
			}
		}
}
