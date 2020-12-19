import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;

	public int randomNum() {
		Random rand = new Random();
		int randInt = rand.nextInt(90_000 - 10_000) + 10_000;
		return randInt;
	}

	
	public Order(int orderTime, DAY orderDay, Customer customer) {
		orderNumber = getOrderNo();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		beverages = new ArrayList<>();
	}

	
	public void addNewBeverage(String name, SIZE size, boolean extraShotCoffee, boolean extraShotSyrup) {
		Coffee coffee = new Coffee(name, size, extraShotCoffee, extraShotSyrup);
		beverages.add(coffee);
	}

	
	public void addNewBeverage(String name, SIZE size, int numFruits, boolean proteinPowder) {
		Smoothie smoothie = new Smoothie(name, size, numFruits, proteinPowder);
		beverages.add(smoothie);
	}

	
	public void addNewBeverage(String name, SIZE size) {
		boolean weekend = false;
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			weekend = true;
		}
		Alcohol alcohol = new Alcohol(name, size, weekend);
		beverages.add(alcohol);
	}

	
	public String toString() {
		String str = "Order number: " + getOrderNo() + ", Order time: " + orderTime + ", Order day: " + getOrderDay()
				+ "\n" + customer.toString();

		for (Beverage beverage : beverages) {
			str += "\n" + beverage.toString();
		}
		str += "\n Order cost: " + calcOrderTotal();

		return str;
	}

	
	public boolean isWeekend() {
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		return false;
	}

	
	public Beverage getBeverage(int num) {
		return beverages.get(num);
	}

	
	public int compareTo(Order order) {
		if (orderNumber == order.getOrderNo()) {
			return 0;
		} else if (orderNumber > order.getOrderNo()) {
			return 1;
		} else {
			return -1;
		}
	}

	
	public double calcOrderTotal() {
		double orderTotal = 0;

		for (Beverage beverage : beverages) {
			orderTotal += beverage.calcPrice();
		}

		return orderTotal;
	}

	
	public int findNumOfBeveType(TYPE type) {
		int count = 0;

		for (Beverage beverage : beverages) {
			if (beverage.getType() == type) {
				count++;
			}
		}

		return count;
	}

	
	public int getTotalItems() {
		return beverages.size();
	}

	
	public int getOrderNo() {
		return orderNumber;
	}

	
	public int getOrderTime() {
		return orderTime;
	}

	
	public DAY getOrderDay() {
		return orderDay;
	}

	
	public Customer getCustomer() {
		return new Customer(customer);
	}

	
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	
	public void setOrderNum(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	
	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}