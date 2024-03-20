package bean;

public class Tuple {

	private int t1;
	private int t2;
	
	public Tuple() {
		// TODO Auto-generated constructor stub
	}

	public Tuple(int t1, int t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}

	public int getT2() {
		return t2;
	}

	public void setT2(int t2) {
		this.t2 = t2;
	}
	
	public int sum() {
		return t1 + t2;
	}

	@Override
	public String toString() {
		return "Tuple [t1=" + t1 + ", t2=" + t2 + "]";
	}
	
	
}
