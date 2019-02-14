package it.techgap.challenge.java.senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Challenge01CollectionMethods {
	
	public static int max(int[] in){
		Arrays.sort(in);
		return in[in.length-1];
	}
	
	public static int min(int[] in){
		Arrays.sort(in);
		return in[0];
	}
	
	public static int[] sortIt(int[] in){
		Arrays.sort(in);
		return in;
	}
	
	public static Boolean[] sortIt(Boolean[] in){
		Arrays.sort(in, Collections.reverseOrder());
		return in;
	}
	
	public static int[] removeNegative(int[] in){
		int[] out = Arrays.stream(in).filter(x -> x >= 0).toArray();
		Arrays.sort(out);
		return out;
	}
	
	public static int count(String[] in, String e){
		List<String> arrayList = Arrays.asList(in);  
		return Collections.frequency(arrayList, e);
	}
	
	public static int maxRepetitions(String[] in){
		int maxRepetitions = 0;
		int frequency = 0;
		List<String> arrayList = Arrays.asList(in);
		Set<String> set = new HashSet<>(arrayList);
		for (String s : set) {
			frequency = Collections.frequency(arrayList, s);
		    if (frequency > maxRepetitions) {
		    	maxRepetitions = frequency;
		    }
		}
		return maxRepetitions;
	}
	
	public static int[] mergeAndSort(int[]... in){
		List<Integer> completeMerge = new ArrayList<>();
		for (int[] array : in) {
			completeMerge.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
		}
		
		Set<Integer> set = new HashSet<>(completeMerge);
		completeMerge.clear();
		completeMerge.addAll(set);
		
		Collections.sort(completeMerge);
		int[] out = new int[completeMerge.size()];
		for (int i=0; i<completeMerge.size(); i++) {
			out[i] = completeMerge.get(i);
		}
		return out;
	}

}
