package main.java.classes;

public enum TargetEnvironment {
	TESTING("jdbc:h2:./src/test/resources/testDataBase"),
	APP("jdbc:h2:./src/main/resources/appDataBase");
	
	public final String environmentLabel;
	
	private TargetEnvironment(String label) {
		this.environmentLabel = label;
	}
}
