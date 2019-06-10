package search.params;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		
		
		/// 2=890-09-9090, 3=890-09-09, 4=03585803, 'E', 'P', 'Y'}
		
		/*In the given array in Java, [766-09-9090, 766-09-9090, 877-90-9090, 877-90-9090, "S", "T", "U"]
				
		How could we obtain a new array with values like this : 
			[766-09-9090, 877-90-9090, 877-90-9090, 766-90-9090, "S", "T", "U"]
					
		Note : No changes on non SSN values like "S", "T, "U"*/
		
		
		List<String> arrays = new ArrayList<>();
		arrays.add("031661401");
		arrays.add("031661401");
		arrays.add("038585803");
		arrays.add("038585803");
		//arrays.add("038585808");
		//arrays.add("038585808");
		arrays.add("E");
		arrays.add("P");
		arrays.add("Y");
		
		 SsnSwapper.modifyArray(arrays);
		

	}

}
