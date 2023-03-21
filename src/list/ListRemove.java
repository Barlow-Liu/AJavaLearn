package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemove {
	public static class Student {
		public Student(String gender) {
			this.gender = gender;
		}

		private String gender = "";

		public String getGender() {
			return gender;
		}
//		@Override
//		public String toString() {
//			return gender;
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		list.add(new Student("male"));
		list.add(new Student("female"));
		list.add(new Student("female"));
		list.add(new Student("male"));
		list.add(new Student("male"));
		list.add(new Student("male"));

		// 遍历删除,除去男生
		Iterator<Student> iterator = list.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if ("male".equals(student.getGender())) {
				iterator.remove();// 使用迭代器的删除方法删除
			}
		}
		System.out.println(list.toString());

	}

}
