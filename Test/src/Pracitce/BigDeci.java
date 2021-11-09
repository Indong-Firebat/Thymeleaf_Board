package Pracitce;

import java.math.BigDecimal;

public class BigDeci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigDecimal bigNumber1 = new BigDecimal("100000.12345");
		BigDecimal bigNumber2 = new BigDecimal("10000");
		
		float fNumber = (float) 10000.123456789123456789123456789; 
		double dNumber = 10000.123456789123456789123456789;
						
		System.out.println("덧셈(+) :" +bigNumber1.add(bigNumber2));
		System.out.println("뺄셈(-) :" +bigNumber1.subtract(bigNumber2));
		System.out.println("곱셈(*) :" +bigNumber1.multiply(bigNumber2));
		System.out.println("나누기(/) :" +bigNumber1.divide(bigNumber2));
		System.out.println("나머지(%) :" +bigNumber1.remainder(bigNumber2));
		
		System.out.println(fNumber);
		System.out.println(dNumber);
		
	}

}
