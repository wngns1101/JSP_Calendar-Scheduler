package calendar;

import java.util.*;

public class calInfo {
	
	
	public String calDate(int x){
		Calendar cal = Calendar.getInstance();
		
		int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE) + x;
		
		if(m == 13){
			y++;
			m = 1;
		}
		
		if(d > lastDay[m-1]){
			m++;
			d = d - lastDay[m-1];
		}
		
		return y + "-" + m + "-" +d;
		
	}
}
