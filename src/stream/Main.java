package stream;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<>();
		words.add("a");
		words.add("bb");
		words.add("ccc");
		words.add("dddd");
		words.add("eeeee");
		words.add("ffffff");
		
		long count = words.stream().filter(e->e.length()>3).count();
		System.out.println(count);
		
		
	}

}
