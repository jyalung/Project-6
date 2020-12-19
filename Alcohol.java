
public class Alcohol extends Beverage{
	private boolean weekend;
    private final double WCOST = .60;
    
    public Alcohol(String name, SIZE size, boolean weekend) {
            super(name, TYPE.ALCOHOL, size);
            this.weekend = weekend;
    }
    
    public String toString() {
    	String str = "Beverage name: " + getBevName() + ", Beverage size: " + getSize() + ", Offered on the weekend: ";
		if (weekend) {
			str += "True, ";
		} else {
			str += "False, ";
		}
		str += "Price: " + calcPrice();
		return str;
    }
    
    public boolean equals(Alcohol alcohol) {
            if (super.equals(alcohol) && weekend == alcohol.getWeekend()) {
                    return true;
            }
            else {
                    return false;
            }
    }
    
    public double calcPrice() {
            double price = super.getBasePrice();
            
            if (super.getSize() == SIZE.MEDIUM) {
                    price += super.getSizePrice();
            }
            else if (super.getSize() == SIZE.LARGE) {
                    price += 2 * super.getSizePrice();
            }
            
            if (weekend) {
                    price += WCOST;
            }
            
            return price; 
    }
    
    public boolean getWeekend() {
            return weekend;
    }
    
    public double getWeekendFee() {
            return WCOST;
    }
    
    public void setWeekend(boolean weekend) {
            this.weekend = weekend;
    }
}
