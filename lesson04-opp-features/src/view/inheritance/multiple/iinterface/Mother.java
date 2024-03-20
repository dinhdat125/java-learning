package view.inheritance.multiple.iinterface;

public interface Mother {

	void cooking();
	void playGame();
	default void coding() {
		System.out.println("Mother -> coding");
	}
}
