package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi {
//汉诺塔
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		Stack<Integer> c = new Stack<Integer>();
		while(sc.hasNextInt()) {
			a.clear();b.clear();c.clear();
			int num = sc.nextInt();
			for (int i = num; i >0; i--) {
				a.push(i);
			}
		}


	}

}
