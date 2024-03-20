package view.inheritance.abstractclass;

public class StandardEmailServiceImpl extends EmailService {

	@Override
	void login() {
		System.out.println("StandardEmailServiceIml -> login");
	}
}
