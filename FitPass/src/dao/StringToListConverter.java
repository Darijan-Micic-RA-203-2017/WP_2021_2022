package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringToListConverter {
	public StringToListConverter() {}
	
	public static ArrayList<Long> convertToLongArrayList(String listAsString) {
		listAsString = listAsString.substring(1, listAsString.length() - 1);
		
		ArrayList<Long> list = new ArrayList<Long>();
		if (listAsString.length() <= 2) {
			return list;
		}
		
		StringTokenizer stringTokenizer = new StringTokenizer(listAsString, ", ");
		while (stringTokenizer.hasMoreTokens()) {
			list.add(Long.parseLong(stringTokenizer.nextToken().trim()));
		}
		
		return list;
	}
	
	public static ArrayList<Integer> convertToIntegerArrayList(String listAsString) {
		listAsString = listAsString.substring(1, listAsString.length() - 1);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listAsString.length() <= 2) {
			return list;
		}
		
		StringTokenizer stringTokenizer = new StringTokenizer(listAsString, ", ");
		while (stringTokenizer.hasMoreTokens()) {
			list.add(Integer.parseInt(stringTokenizer.nextToken().trim()));
		}
		
		return list;
	}
	
	public static ArrayList<String> convertToStringArrayList(String listAsString) {
		listAsString = listAsString.substring(1, listAsString.length() - 1);
		
		ArrayList<String> list = new ArrayList<String>();
		if (listAsString.length() <= 2) {
			return list;
		}
		
		StringTokenizer stringTokenizer = new StringTokenizer(listAsString, ", ");
		while (stringTokenizer.hasMoreTokens()) {
			list.add(stringTokenizer.nextToken().trim());
		}
		
		return list;
	}
}
