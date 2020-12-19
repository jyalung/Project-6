import java.util.ArrayList;
//import java.util.*;

public class BevShop implements BevShopInterfce {
	private int numOfAlcohol;
	private int currentOrder;
	private ArrayList<Order> orders;

	public BevShop() {
		orders = new ArrayList<>();
	}


	public String toString() {
		String str = "Monthly Orders\n";

		for (Order o : orders) {
			str += o.toString();
		}
		str += "Total Sale: " + totalMonthlySale();

		return str;
	}


	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}


	public boolean validAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}


	public boolean eligibleForMore() {
		if (numOfAlcohol < 3) {
			return true;
		}
		return false;
	}


	public boolean isMaxFruit(int num) {
		if (num > MAX_FRUIT) {
			return true;
		}
		return false;
	}


	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrder = orders.indexOf(order);
		numOfAlcohol = 0;
	}


	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}


	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		orders.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}


	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrder).addNewBeverage(bevName, size);
		numOfAlcohol++;
	}

	//@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}


	//@Override
	public double totalOrderPrice(int orderNo) {
		double price = 0;
        for (Order order : orders) {
            if (orderNo == order.getOrderNo()) {
                price = order.calcOrderTotal();
            }
        }
        return price;
	}


	public double totalMonthlySale() {
		double totalSale = 0.0;

		for (Order order : orders) {
			for (Beverage beverage : order.getBeverages()) {
				totalSale += beverage.calcPrice();
			}
		}

		return totalSale;
	}


	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}


	//@Override
	public void sortOrders() {
		for (int i = 0; i < orders.size() - 1; i++) {
			int minOrderNumIdx = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo()) {
					minOrderNumIdx = j;
				}
			}

			Order temp = orders.get(minOrderNumIdx);
			orders.set(minOrderNumIdx, orders.get(i));
			orders.set(i, temp);
		}
	}


	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}


	public Order getCurrentOrder() {
		return orders.get(currentOrder);
	}


	public int getNumOfAlcoholDrink() {
		return numOfAlcohol;
	}


	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}


	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

}
