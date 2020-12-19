
public class Customer {
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	public Customer(Customer customer) {
		name = customer.getName();
		age = customer.getAge();
	}

	
	public String toString() {
		String str = "Customer name: " + getName() + ", Customer age: " + getAge();
		return str;
	}

	
	public String getName() {
		return name;
	}

	
	public int getAge() {
		return age;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setAge(int age) {
		this.age = age;
	}
}
