
public class Coffee extends Beverage{
	public boolean extraShotCoffee;
	public boolean extraSyrup;
	final double EXTRACOFFEE = .50; 
	final double EXTRASYRUP = .50;
	
	Coffee(String name, SIZE size, boolean eShotCoffee, boolean eSyrup){
		super(name, TYPE.COFFEE, size);
		extraShotCoffee = eShotCoffee;
		extraSyrup = eSyrup;
	}
	
	@Override
	public String toString() {
		String str = "Beverage name: " + getBevName() + ", Beverage size: " + getSize() + ", Extra shot of Coffee: ";
		if (extraShotCoffee) {
			str += "True ,";
		} else {
			str += "False ,";
		}
		if (extraSyrup) {
			str += "Extra shot of Syrup: True.";
		} else {
			str += "Extra shot of Syrup: False, ";
		}
		str += "price: " + calcPrice();
		return str;
	}
	
	@Override
	public double calcPrice() {
		double price = super.getBasePrice();

		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		} else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		if (extraShotCoffee) {
			price += EXTRACOFFEE;
		}
		if (extraSyrup) {
			price += EXTRASYRUP;
		}
		return price;
	}
	
	public boolean equals(Coffee coffee) {
		if (super.equals(coffee) && extraShotCoffee == coffee.getExtraShot()
				&& extraSyrup == coffee.getExtraSyrup()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getExtraShot() {
		return extraShotCoffee;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public double getCoffeeCost() {
		return EXTRACOFFEE;
	}
	
	public double getSyrupCost() {
		return EXTRASYRUP;
	}
	
	public void setExtraShotCoffee(boolean bool) {
		extraShotCoffee = bool;
	}
	
	public void setExtraSyrup(boolean bool) {
		extraSyrup = bool;
	}
}
