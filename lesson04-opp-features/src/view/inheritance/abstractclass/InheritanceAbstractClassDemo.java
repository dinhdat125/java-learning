package view.inheritance.abstractclass;

public class InheritanceAbstractClassDemo {

	public static void main(String[] args) {
		// anonymous class
		EmailService es = new EmailService() {
			
			@Override
			void login() {
				System.out.println("login");
			}
		};
		es.login();
		
		
	}
}
