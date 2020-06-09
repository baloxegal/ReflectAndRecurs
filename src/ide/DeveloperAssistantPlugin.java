package ide;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import source.Button;

public class DeveloperAssistantPlugin {
	
	public static List<String> getSuggestions(Class<?> sourceClass) {
		
		if (sourceClass == Button.class) {
			List<String> methodList = new ArrayList<String>();
			Method[] methods = sourceClass.getDeclaredMethods();
			Stream.of(methods).forEach(method -> methodList.add(method.getName()));
			return methodList;
		}
		
		List<String> List = new ArrayList<String>();
		Method[] methods = sourceClass.getDeclaredMethods();
		Stream.of(methods).forEach(method -> List.add(method.getName()));
		List.addAll(getSuggestions(sourceClass.getSuperclass()));
		return List;
	}
}
