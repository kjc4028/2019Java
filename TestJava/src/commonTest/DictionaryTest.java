package commonTest;

import java.util.Dictionary;
import java.util.Hashtable;

public class DictionaryTest {

	
	private static Dictionary<Object, Object> ins = new Hashtable<>();
	
	public static class TestObj{
		
		String name;
		
		public TestObj(String str) {
			name = str;
		}
		
		public String getName() {
			return name;
		}
		
		public void store(){
			ins.put(this.getName(), this);
		}
	}
	
	public static void main(String[] args) {
		
		new TestObj("test01").store();
		new TestObj("test02").store();
		new TestObj("test03").store();
		
		
		System.out.println(ins.size());
	}

}
