
public class Smoothie extends Beverage{
	private boolean protienPowder;
	private int numFruits;
	
	private final double PPOWDERCOST = 1.5;
	private final double EFRUITCOST = .5;

	
	public Smoothie(String name, SIZE size, int numFruits, boolean protienPowder) {
		super(name, TYPE.SMOOTHIE, size);
		this.numFruits = numFruits;
		this.protienPowder = protienPowder;
	}

	@Override
	public String toString() {
		String str = "Beverage name: " + getBevName() + ", Beverage size: " + getSize() + ", Number of Fruits: "
				+ numFruits + ", Is there protein powder: ";
		if (protienPowder) {
			str += "True, ";
		} else {
			str += "False, ";
		}
		str += "Price: " + calcPrice();
		return str;
	}

	
	public boolean equals(Smoothie smoothie) {
		if (super.equals(smoothie) && numFruits == smoothie.getNumOfFruits()
				&& protienPowder == smoothie.getAddProtien()) {
			return true;
		} else {
			return false;
		}
	}

	
	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		} else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		price += numFruits * EFRUITCOST;
		if (protienPowder) {
			price += PPOWDERCOST;
		}
		return price;
	}

	
	public int getNumOfFruits() {
		return numFruits;
	}

	
	public boolean getAddProtien() {
		return protienPowder;
	}

	
	public double getFruitCost() {
		return EFRUITCOST;
	}

	
	public double getProteinCost() {
		return PPOWDERCOST;
	}

	
	public void setNumOfFruits(int numFruits) {
		this.numFruits = numFruits;
	}

	
	public void setProteinPowder(boolean proteinPowder) {
		this.protienPowder = proteinPowder;
	}
}
