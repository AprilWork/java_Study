package genericsStudy;

class EvenNumber extends NaturalNumber {

	public EvenNumber() {
		super();
	}
    public EvenNumber(int i) { super(i); }
    // ...
	public static void main(String[] args) {
		EvenNumber e = new EvenNumber();
		System.out.println(e);
	}
		
}
