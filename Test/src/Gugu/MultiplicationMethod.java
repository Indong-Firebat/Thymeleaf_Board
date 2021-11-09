package Gugu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MultiplicationMethod extends MultiplicationMain {

	public void Horizontal() {
		System.out.println("Horizontal Multiplication");
		ArrayList horilist = new ArrayList();
			for (int i = 1; i < 10; i++) {
				System.out.print(i + "단" + "\t");
				for (int j = 1; j < 10; j++) {
					System.out.print(i + "X" + j + " = " + i * j + " | ");
						horilist.add(i + "X" + j + "=" + i * j);
				}
			}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("horilist" + horilist);
		//System.out.println(Arrays.toString(horiarr));
	}
	
	public void Vertical() {
		System.out.println("Vertical Multiplication");
		String[] vertiarr = new String[1];
		ArrayList vertilist = new ArrayList();
		
		for (int i = 1; i < 10; i++) {
			System.out.println(i + "단");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "X" + j + " = " + i * j);
				System.out.println();
				for(int n = 0; n < vertiarr.length; n++) {
					vertiarr[n] += i + "X" + j + "=" + i * j +  "\n";
					vertilist.add(i + "X" + j + "=" + i * j + "\n");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("vertilist" + "\n" + vertilist);
		//System.out.println(Arrays.toString(vertiarr));
	}

	
	public void Input() throws InputException, NumberFormatException {
		
		System.out.println("Input Multiplication");
		System.out.print("값을 입력해주세요 : ");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		int n = Integer.parseInt(data);
		String[] inputarr = new String[1];
		
		for (int i = 1; i < 10; i += n) {
			if(n >= 10) {
				throw new InputException();
			}
			for (int j = 1; j < 10; j++) {
				for (int k = i; k < n + i; k++) {
					System.out.print(k + "x" + j + "=" + k * j + "\t");
					if (k == 9) {
						break;
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(inputarr));
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		MultiplicationMethod g = new MultiplicationMethod();
		
		g.Horizontal();
		g.Vertical();
		
		while (true) {
			try {
				g.Input();
			} catch (InputException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("에러 : "+ e.getMessage() + " 숫자만 입력해주세요.");
			} finally {
				System.out.println("종료하려면 exit, 진행하려면 아무키나 입력해주세요.");
				String stop = sc.nextLine();
				if(stop.equals("exit")) {
					System.out.println("종료");
					break;
				}
			}
		}
	}
}
