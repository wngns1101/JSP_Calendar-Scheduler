package calendar;

import java.util.*;

public class calInfo {
	
	public static boolean isLeepYear(int yy) {
		return (yy%400==0 || yy%4==0 && yy % 100 != 0);
	}
	
	public static int lastDay(int yy, int mm) {
		int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		lastDay[1] = isLeepYear(yy)? 29:28;
		return lastDay[mm-1];
	}
	
	public static int totalDay(int yy, int mm, int dd) {
		int total = (yy-1)*365 + (yy-1)/4 - (yy-1)/100 + (yy-1)/400;
		for(int i=1; i<mm; i++) {
			total += lastDay(yy, i);
		}
		total += dd;
		return total;
	}
	
	public static int weekDay(int yy, int mm, int dd) {
		return totalDay(yy, mm, dd) % 7 + 1;
	}
	
	public static String currentMonth(int mm) {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String month = months[mm-1];
		return month;
	}
}
