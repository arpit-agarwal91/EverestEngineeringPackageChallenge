
public class Vehicle {

	private int id;
	private float freeAfterHours;
	
	Vehicle(int id, float freeAfterHours){
		this.id = id;
		this.freeAfterHours = freeAfterHours;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getFreeAfterHours() {
		return freeAfterHours;
	}
	public void setFreeAfterHours(float freeAfterHours) {
		this.freeAfterHours = freeAfterHours;
	}
	
}
