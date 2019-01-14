
public class InstanceVarExample {

	String myInstanceVar ="instance variable";
	
	public static void main(String args[]) {
		InstanceVarExample obj = new InstanceVarExample();
		InstanceVarExample obj2 = new InstanceVarExample();
		InstanceVarExample obj3 = new InstanceVarExample();
		
		//All three will display "class or static variable"
		System.out.println(obj.myInstanceVar);
		System.out.println(obj2.myInstanceVar);
		System.out.println(obj3.myInstanceVar);
		
		//changing the value of static variable using obj2
		obj2.myInstanceVar = "Changed Text";
		
		//All three will display "Changed Text"
		System.out.println(obj.myInstanceVar);
		System.out.println(obj2.myInstanceVar);
		System.out.println(obj3.myInstanceVar);
	}
	
}
