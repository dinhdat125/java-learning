package view.inheritance.multiple.iinterface;

public class Child implements Father, Mother {

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void running() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coding() {
		Father.super.coding();
		Mother.super.coding();
		// System.out.println();
	}

}
