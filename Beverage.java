
public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	final double BASEPRICE = 2.00;
	final double SIZEPRICE = 1.00;
	
	Beverage(String name, TYPE type, SIZE size){
		this.name = name;
		this.size = size;
		this.type = type;
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		String x = "Beverage name: " + name + " Beverage size: " + size;
		return x;
	}
	
	public boolean equals(Beverage beverage) {
		if (name.equals(beverage.getBevName()) && type.equals(beverage.getType()) && size.equals(beverage.getSize())) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getBevName() {
		return name;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public double getBasePrice() {
		return BASEPRICE;
	}
	
	public double getSizePrice() {
		return SIZEPRICE;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(TYPE type) {
		this.type = type;
	}
	
	public void setSize(SIZE size) {
		this.size = size;
	}
}
