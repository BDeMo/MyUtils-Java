package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class compare {
	public static int max(int... a) {
		List<Integer> nums = new ArrayList<Integer>();
		for(int  i=0 ; i<a.length; i++) {
			nums.add(a[i]);
		}
		return Collections.max(nums);
	}
}
