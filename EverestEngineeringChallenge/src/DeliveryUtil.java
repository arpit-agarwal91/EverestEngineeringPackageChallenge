import java.util.ArrayList;
import java.util.List;

public class DeliveryUtil {
	
	public static List<Package> updateDeliveryTime(int noOfVehicles, float totalWeight, int totalPackages, int maxWeight, int maxSpeed, List<Package> packages){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		for(int i=0;i<noOfVehicles;i++) {
			vehicles.add(new Vehicle(i,0));
		}
		
		int arr[] = getMax2(packages, maxWeight);
		int p=0;
		while(arr[0]!=-1 && arr[1]!=-1) {
			if(p<noOfVehicles) {
				packages.get(arr[0]).setDeliveryTime(packages.get(arr[0]).getDistance()/(float)maxSpeed);
				packages.get(arr[1]).setDeliveryTime(packages.get(arr[1]).getDistance()/(float)maxSpeed);
				vehicles.get(p).setFreeAfterHours(2*Math.max(packages.get(arr[0]).getDeliveryTime(), packages.get(arr[1]).getDeliveryTime()));
				p++;
			}
			else {
				float minArrival = Float.MAX_VALUE;
				int index=-1;
				for(int i=0;i<vehicles.size();i++) {
					if(vehicles.get(i).getFreeAfterHours()<minArrival) {
						minArrival = vehicles.get(i).getFreeAfterHours();
						index = i;
					}				
				}
				packages.get(arr[0]).setDeliveryTime(minArrival+packages.get(arr[0]).getDistance()/(float)maxSpeed);
				packages.get(arr[1]).setDeliveryTime(minArrival+packages.get(arr[1]).getDistance()/(float)maxSpeed);
				vehicles.get(index).setFreeAfterHours(minArrival+2*Math.max(packages.get(arr[0]).getDeliveryTime(), packages.get(arr[1]).getDeliveryTime()));
			}
			arr = getMax2(packages, maxWeight);
		}
		
		int max = getMax(packages, maxWeight);
		
		while(packages.get(max).getDeliveryTime()==0) {
			if(p<noOfVehicles) {
				packages.get(max).setDeliveryTime(packages.get(max).getDistance()/(float)maxSpeed);
				vehicles.get(p).setFreeAfterHours(2*packages.get(max).getDeliveryTime());
				p++;
			}
			else {
				float minArrival = Float.MAX_VALUE;
				int index=-1;
				for(int i=0;i<vehicles.size();i++) {
					if(vehicles.get(i).getFreeAfterHours()<minArrival) {
						minArrival = vehicles.get(i).getFreeAfterHours();
						index = i;
					}				
				}
				packages.get(max).setDeliveryTime(minArrival+packages.get(max).getDistance()/(float)maxSpeed);
				vehicles.get(index).setFreeAfterHours(minArrival+2*packages.get(max).getDeliveryTime());
			}
			max = getMax(packages, maxWeight);
		}

		return packages;
	}
	
	public static int[] getMax2(List<Package> packages, int maxWeight) {
		int m=-1, n=-1;
		for(int i=0;i<packages.size();i++) {
			for(int j=i+1;j<packages.size();j++) {
				Package first = packages.get(i);
				Package second = packages.get(j);
				if(first.getDeliveryTime()==0 && second.getDeliveryTime()==0 &&
						first.getWeight()+second.getWeight()<=maxWeight) {
					m = i;
					n = j;
				}
			}
		}
		return new int[] {m,n};
	}
	
	public static int getMax(List<Package> packages, int maxWeight) {
		int m=0;
		for(int i=1;i<packages.size();i++) {
			Package first = packages.get(i);
			Package base = packages.get(m);
			if(first.getDeliveryTime()==0 && base.getDeliveryTime()==0 
					&& base.getWeight()<first.getWeight() && first.getWeight()<maxWeight) {
				m=i;
			}
			if(first.getDeliveryTime()==0 && base.getDeliveryTime()==0 
					&& base.getWeight()==first.getWeight() 
					&& first.getWeight()<maxWeight && base.getDistance()<first.getDistance()) {
				m=i;
			}
		}
		return m;
	}

}
