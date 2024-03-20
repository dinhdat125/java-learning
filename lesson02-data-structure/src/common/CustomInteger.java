package common;

public class CustomInteger {
	public int value;
	 
    public CustomInteger(int value) {        // ham khoi tao
        this.value = value;
    }
 
    public int getValue() {           // ham tra ve gia tri num
        return value;
    }
 
    public void setValue(int value) {   // ham set gia tri num
        this.value = value;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "" + this.value;
    }
}
