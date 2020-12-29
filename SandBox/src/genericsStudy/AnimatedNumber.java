package genericsStudy;

public class AnimatedNumber extends NaturalNumber{
	private Color color;
	private Sound sound;
	
	public AnimatedNumber(int i) {
		// TODO Auto-generated constructor stub
		super(i);
		this.color = new Color();
		this.sound = new Sound("moo!");
	}
	
	public void live() {
		//this.sound = new Sound("Coco!");
		Sound innerCowSound = this.new Sound("Moo!");
		innerCowSound.speak();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimatedNumber cow3 = new AnimatedNumber(3);
		AnimatedNumber.Sound cowSound = cow3.new Sound("Moo!");
		cow3.live();
	}
	
	public class Sound {

		private String sound;
		public Sound() {
			// TODO Auto-generated constructor stub
			this.sound = "";
		}

		public Sound(String sound) {
			this.sound = sound;
		}

		private void speak() {
			for (int k=0; k < intValue(); k++) { // Sound object use outerClass  instance field
				System.out.print(sound + " ");
			}
		}

	}

	public static class Color {
    	private int R,G,B;
    	private String Hex;
    	
		public Color() {
			// TODO Auto-generated constructor stub
			this.R = 0;
			this.G = 0;
			this.B = 255;
			this.Hex = Integer.toHexString((R*65536)+(G*256)+B);
		}
		
		public Color(int R,int G,int B) {
			setRGB(R,G,B);
		}
		

		public String getHex() {
			return this.Hex;
		}

		public void setRGB(int R,int G,int B) {
			this.R = R;
			this.G = G;
			this.B = B;
			this.Hex = Integer.toHexString((R*65536)+(G*256)+B);
		}

		public String toString() {
			return getHex();
		}

	}

}
