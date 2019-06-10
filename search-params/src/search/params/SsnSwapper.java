package search.params;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SsnSwapper {

	//////  {1=031661401, 2=031661401, 3=03585803, 4=03585803, 'E', 'P', 'Y'}
	
	private static boolean areElementsContiguous(List<String> arr) 
	{ 
	    
	    for (int i = 1; i < arr.size(); i++) 
	    	if (arr.get(i).equals(arr.get(i-1))) {
	    		return true;
	    	}
	      
	    return false;  
	} 
	
	private static boolean containsDuplicateElements(List<String> elements) {
		for (int i = 0; i < elements.size(); i++) {
			for (int j = i + 1; j < elements.size(); j++) {
				if (elements.get(i).equals(elements.get(j))) {

					return true;
				}
			}
		}

		return false;
	}
			
	
	public static void modifyArray(List<String> arrays) {
		
		List<String> firstSetOfArray = new ArrayList<String>();
		List<String> secondSetOfArray  = new ArrayList<String>();
		List<String> nonSsnParameters = new ArrayList<String>();
		List<String> modifiedParameters = new ArrayList<String>();
		boolean matchedFound = false;
		for (int index = 0; index < arrays.size(); index++) {
			if (arrays.get(index).length() == 9 && isValidSSN(arrays.get(index))) {
				
				if (index % 2 == 0 ) {
					firstSetOfArray.add(arrays.get(index));
				}
				else {
					secondSetOfArray.add(arrays.get(index));
				}
			}
			else {
				nonSsnParameters.add(arrays.get(index));
			}
		}
		
		
		if (firstSetOfArray.size() > 0) {

			for (String v : firstSetOfArray) {
				modifiedParameters.add(v);
			}
		}

		if (secondSetOfArray.size() > 0) {

			for (String v : secondSetOfArray) {
				modifiedParameters.add(v);
			}
		}
		if (nonSsnParameters.size() > 0) {

			for (String v : nonSsnParameters) {
				modifiedParameters.add(v);
			}
		}
		System.out.println("Printing Modified Parameters Set : ");
		printArray(modifiedParameters);
		
		

	}

	private static void differentAlgorithm(List<String> arrays) {
		System.out.println("Array Before modification");
		printArray(arrays);
		List<String> newArray = new ArrayList<String>();
		boolean matchedFound = false;
		for (int index = 0; index < arrays.size(); index++) {
			if (arrays.get(index).length() == 9 && isValidSSN(arrays.get(index))) {

				Integer nextMatchingSsnIndex = getNextDistinctSsnIndex(arrays);
				if (nextMatchingSsnIndex != 0) {
						if (containsDuplicateElements(arrays) &&  areElementsContiguous(arrays)) {
							
							if (index != nextMatchingSsnIndex) {
							swap(arrays.toArray(), index, nextMatchingSsnIndex);
							//newArray.add(arrays.get(index));
							newArray.add(arrays.get(nextMatchingSsnIndex));
							}
						}

					}
			}
			else {
				
			}
		}
		
		printArray(newArray);
	}

				

	private static void printArray(List<String> array) {
		for(String a : array) {
			System.out.println(a);
		}
	}

	private static boolean isValidSSN(String s) {
		if (s.length() != 9) {
			throw new IllegalArgumentException("An SSN length must be 9");
		}
		for (int i = 0; i < 9; i++)
			if (!Character.isDigit(s.charAt(i))) {
				throw new IllegalArgumentException("SSN must have only digits.");
			}
		return (true);
	}
	private static HashMap<Integer, String> getIndexAndValues(List<String> arrays) {

		HashMap<Integer, String> indexSsn = new HashMap<>();

		if (arrays != null && arrays.size() > 0) {

			for (int index = 0; index < arrays.size(); index++) {
				
				if (arrays.get(index).length() == 9 &&  isValidSSN( arrays.get(index))) {
					
					indexSsn.put(index, arrays.get(index));
				}
			}
		}
		
		return indexSsn;
	}
	
	public static List<String> getSwappedArray(List<String> arrays){
		
		//  {1=031661401, 2=031661401, 3=038585803, 4=038585803, 'E', 'P', 'Y'}
		
		Map<Integer, String> swappedHashMap = new HashMap<>();
		Map<Integer, String> indexAndValues = getIndexAndValues(arrays);
		
		
		
		
		
		String currentValue = "";
		 for (Map.Entry<Integer,String> entry : indexAndValues.entrySet())  {
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
	           if (currentValue.equals(entry.getValue())) {
	        	   
	        	   // find the first one that is different and swap the value;;
	        	   
	        	   String firstDifferentSsn = findFirstDifferentSsn(indexAndValues);
	        	   
	        	   Integer currentKey = entry.getKey();
	        	   String currentEntryValue = entry.getValue();
	        	   
	        	   
	        	   if (firstDifferentSsn != "") {
	        		   
	        		   String [] pair = firstDifferentSsn.split(":");
	        		   
	        		   if (pair.length == 2) {
	        			   Integer key  = Integer.parseInt(pair[1]);
	        			   String ssn  = pair[0];
	        			   
	        			   entry.setValue(ssn);
	        			   
	        		   }
	        		   
	        	   }
	        	   
	        	   
	           }
	           else {
	        	   currentValue = entry.getValue();
	        	   swappedHashMap.put(entry.getKey(), entry.getValue());
	           }
		 }
		
		
		List<String> results = new ArrayList<String>();
		if (arrays != null && arrays.size() > 0) {
			
			for(int index = 0; index < arrays.size(); index++) {
				
				
			}
		}
		
		return null;
	}
	
	
	private static Integer getNextDistinctSsnIndex(List<String> ssns) {

		Integer currentIndex = 0;
		String currentSsn = "";

		for (int index = 0; index < ssns.size(); index++) {

			if (!currentSsn.equals(ssns.get(index)) && !currentSsn.equals("")) {

				//firstDiffSsn = ssns.get(index);

				return index;
			} else {
				currentSsn = ssns.get(index);
			}
		}

		return currentIndex;
	}
	
	public static final <T> void swap (T[] a, int i, int j) {
		  T t = a[i];
		  a[i] = a[j];
		  a[j] = t;
		}

	private static String findFirstDifferentSsn(Map<Integer, String> indexAndValues) {
		
		String firstDiffSsn = "";
		String currentValue = "";
		
		 for (Map.Entry<Integer,String> entry : indexAndValues.entrySet())  {
	           
	           if (!currentValue.equals(entry.getValue()) &&  currentValue != "") {
	        	   
	        	   firstDiffSsn =  entry.getValue();
	        	   
	        	   return firstDiffSsn + ":" + entry.getKey();
	           }
	           else {
	        	   currentValue = entry.getValue();
	           }
		 }
		
		return firstDiffSsn;
	}
	
	
}
