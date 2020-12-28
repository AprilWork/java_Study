package genericsStudy;


class NaturalNumber {

	private int i;

	public NaturalNumber() {
		this.i = 0;
	}
	
    public NaturalNumber(int i) {
    	this.i = i; 
    }
    // ...
    
    public int intValue() {
    	return i;
    }
    
    public NaturalNumber valueOf(int i) {
    	return new NaturalNumber(i);
    }
    
    public String toString() {
    	return Integer.toString(i); 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NaturalNumber num = new NaturalNumber(3);
		System.out.println(num);
		
		//NaturalNumber.Color colorNumber = new Color(150,0,45);
		//System.out.println(colorNumber);
		
		//System.out.println(num + " " + num.color.toString());
		
		//NaturalNumber.Sound snd = num.new Sound("mooo!");
		
		//snd.speak();
		
	}
    
    
}


