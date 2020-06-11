package ide;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import source.Button;

public class DeveloperAssistantPlugin {
	
	public static List<String> getSuggestions(Class<?> sourceClass) {
				
		if (sourceClass == Button.class) {
			
			List<String> methodList = new ArrayList<String>();

			Arrays.asList(sourceClass.getDeclaredMethods()).forEach(method -> methodList.add(method.getName()));
						
			return methodList;
		}
		
		List<String> List = new ArrayList<String>();
		
		Arrays.asList(sourceClass.getDeclaredMethods()).forEach(method -> List.add(method.getName()));
		
		List.addAll(getSuggestions(sourceClass.getSuperclass()));
		
		return List;
	}
}
