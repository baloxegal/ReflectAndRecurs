package ide;

import source.AnimatedButton;

public class EditorApplication {

	public static void main(String[] args) {
		
		DeveloperAssistantPlugin.getSuggestions(AnimatedButton.class).stream().forEach(System.out :: println);
	}
}
