package valores;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Valores implements ValoresITF {
	
	private int[] number = new int[10];

	@Override
	public boolean ins(int v) {
		if (v > 0) {
			for (int i = 0; i < number.length; i++) {
				if (number[i] == 0) {
					number[i] = v;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int del(int i) {
		int oldValue = number[i];
		if (number[i] > 0 && i < number.length) {
			number[i] = 0;
			return oldValue;
		}
		return -1;
	}

	@Override
	public int size() {
		int count = (int) Arrays.stream(number).filter(i -> i>0).count();
		return count;
	}

	@Override
	public double mean() {
	    OptionalDouble average = Arrays.stream(number).average();

		return average.getAsDouble() > 0 ? average.getAsDouble() : -1;
	}

	@Override
	public int greater() {
		OptionalDouble max = Arrays.stream(number).filter(i -> i>0).mapToDouble(v -> v).max();
		return max.isPresent() ? (int) max.getAsDouble() : -1;
	}

	@Override
	public int lower() {
		OptionalDouble min = Arrays.stream(number).filter(i -> i>0).mapToDouble(v -> v).min();
		return min.isPresent() ? (int) min.getAsDouble() : -1;
	}

}
