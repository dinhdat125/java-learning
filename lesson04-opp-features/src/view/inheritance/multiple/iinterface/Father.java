package view.inheritance.multiple.iinterface;

public interface Father {

	void cooking();
	void running();
	
	default void coding() {
		System.out.println("Father -> coding");
	}
}
