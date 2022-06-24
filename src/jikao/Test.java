package jikao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 44;

		String str = String.valueOf(a);
		System.out.println(Integer.parseInt(str.replace('4', '5')));

		List<Set<Integer>> xSet = new ArrayList<>(9);
		if(xSet.get(6)==null) {
			System.out.println("null");
		}

	}

}
