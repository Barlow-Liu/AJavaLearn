package jikao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//HJ44
public class Sudoku {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			Unit[][] data = new Unit[9][9];
			List<Set<Integer>> xSet = new ArrayList<>(9);
			List<Set<Integer>> ySet = new ArrayList<>(9);
			List<Set<Integer>> areaSet = new ArrayList<>(9);
			for (int i = 0; i < 9; i++) {
				xSet.add(new HashSet<Integer>());
				ySet.add(new HashSet<Integer>());
				areaSet.add(new HashSet<Integer>());
			}

			for (int i = 0; i < 9; i++) {
				if (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] ss = line.split(" ");
					for (int j = 0; j < 9; j++) {
						int value = Integer.parseInt(ss[j]);
						if (value == 0) {
							data[i][j] = new Unit(value, false, i, j);
						} else {
							data[i][j] = new Unit(value, true, i, j);
							xSet.get(i).add(value);
							ySet.get(j).add(value);
							areaSet.get(i / 3 * 3 + j / 3).add(value);
						}
					}
				}
			}
			Unit maxUnit = null;
			Set<Integer> tempSet = new HashSet<>();
			Stack<Unit> stack = new Stack<>();
			while (true) {
				maxUnit = null;
				first: for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						Unit item = data[i][j];
						if (data[i][j].value > 0) {
							continue;
						}
						tempSet.clear();
						if (maxUnit == null) {
							maxUnit = item;
							tempSet.addAll(xSet.get(i));
							tempSet.addAll(ySet.get(j));
							tempSet.addAll(areaSet.get(i / 3 * 3 + j / 3));
							maxUnit.limit = tempSet.size();
						} else {
							tempSet.addAll(xSet.get(i));
							tempSet.addAll(ySet.get(j));
							tempSet.addAll(areaSet.get(i / 3 * 3 + j / 3));
							item.limit = tempSet.size();
							if (maxUnit.limit < item.limit) {
								maxUnit = item;
							}
						}
						if (maxUnit.limit >= 8) {
							break first;
						}
					}
				}
				if (null == maxUnit) {
					break;
				}
				int nextValue = 0;
				for (int i = maxUnit.value + 1; i < 10; i++) {
					if (!xSet.get(maxUnit.i).contains(i) && !ySet.get(maxUnit.j).contains(i)
							&& !areaSet.get(maxUnit.i / 3 * 3 + maxUnit.j / 3).contains(i)) {
						nextValue = i;
						break;
					}
				}
				if (nextValue > 0) {
					maxUnit.value = nextValue;
					xSet.get(maxUnit.i).add(maxUnit.value);
					ySet.get(maxUnit.j).add(maxUnit.value);
					areaSet.get(maxUnit.i / 3 * 3 + maxUnit.j / 3).add(maxUnit.value);
					stack.add(maxUnit);
				} else {
					while (!stack.isEmpty()) {
						maxUnit = stack.peek();
						xSet.get(maxUnit.i).remove(maxUnit.value);
						ySet.get(maxUnit.j).remove(maxUnit.value);
						areaSet.get(maxUnit.i / 3 * 3 + maxUnit.j / 3).remove(maxUnit.value);
						for (int i = maxUnit.value + 1; i < 10; i++) {
							if (!xSet.get(maxUnit.i).contains(i) && !ySet.get(maxUnit.j).contains(i)
									&& !areaSet.get(maxUnit.i / 3 * 3 + maxUnit.j / 3).contains(i)) {
								nextValue = i;
								break;
							}
						}
						if (nextValue > 0) {
							maxUnit.value = nextValue;
							xSet.get(maxUnit.i).add(maxUnit.value);
							ySet.get(maxUnit.j).add(maxUnit.value);
							areaSet.get(maxUnit.i / 3 * 3 + maxUnit.j / 3).add(maxUnit.value);
							break;
						} else {
							maxUnit.value = 0;
							stack.pop();
						}
					}
					if (stack.isEmpty()) {
						break;
					}
				}
			}
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(data[i][j].value);
					if (j != 8)
						System.out.print(" ");
				}
				System.out.println("");
			}

		}
	}

	static class Unit {
		Unit(int value, boolean isFixed, int i, int j) {
			this.value = value;
			this.isFixed = isFixed;
			this.i = i;
			this.j = j;
		}

		int value = 0;
		boolean isFixed = false;
		int i = 0;
		int j = 0;
		int limit = 0;
	}
}
