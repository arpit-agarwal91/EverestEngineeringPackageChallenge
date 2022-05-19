package EverestChallenge;
public enum Offer {
	
	OFR001(10, "0-200","70-200"),
	OFR002(7, "50-150", "100-250"),
	OFFR002(7, "50-150", "100-250"),
	OFFR003(5, "50-250", "10-150"),
	OFR003(5, "50-250", "10-150");
	
	private int discount;
	private String distanceRange;
	private String weightRange;
	
	Offer(int discount, String distanceRange, String weightRange){
		this.discount = discount;
		this.distanceRange = distanceRange;
		this.weightRange = weightRange;
	}

	public int getDiscount() {
		return discount;
	}

	public String getDistanceRange() {
		return distanceRange;
	}

	public String getWeightRange() {
		return weightRange;
	}
	
	
}
