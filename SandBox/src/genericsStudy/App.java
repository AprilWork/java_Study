package genericsStudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class App {

	public <T> T getData(T t1, T t2) {
		return t2;
	}
	
	Serializable s = getData("Hello world!", new ArrayList<String>());
	

	
	public static <T> void addStore(T t, List<Bucket<T>> list) {
		Bucket<T> bucket = new Bucket<>();
		bucket.setItem(t);
		System.out.println(t.toString()+" has been added to the list...");
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Bucket<String>> list = new ArrayList<>();
		App.addStore("Maria", list);
	}

}

	class Bucket<T> {
		private T item;
		
		public void  setItem(T item) {
			this.item = item;
		}
		
		public T getItem() {
			return this.item;
		}
	}