
public class Package implements Comparable<Package> {

	private String id;
	private float weight;
	private float distance;
	private float discount;
	private float cost;
	private float deliveryTime;
	private String code;
	
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(float deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	@Override
	public int compareTo(Package o) {
		if(o==null) {
			return -1;
		}
		if(this.getWeight()>o.getWeight()) {
			return -1;
		}
		if(this.getWeight()<o.getWeight()) {
			return 1;
		}
		return 0;
	}
	
}
