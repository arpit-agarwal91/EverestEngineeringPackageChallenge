package EverestChallenge;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int baseDeliveryCost = sc.nextInt();
		
		int totalPackages = sc.nextInt();
		float totalWeight = 0;
		
		List<Package> packages = new ArrayList<Package>();

		
		for(int i=0;i<totalPackages;i++) {
			Package pkg = new Package();
			pkg.setId(sc.next());
			pkg.setWeight(sc.nextFloat());
			totalWeight+=pkg.getWeight();
			pkg.setDistance(sc.nextFloat());
			pkg.setCode(sc.next());
			packages.add(pkg);
		}
		
		int noOfVehicles = sc.nextInt();
		int maxSpeed = sc.nextInt();
		int maxWeight = sc.nextInt();

		Collections.sort(packages, (a,b)-> (int)(a.getWeight()-b.getWeight()));
		
		List<Package> output = DiscountUtility.calculateDiscount(baseDeliveryCost, packages);
		
		output = DeliveryUtil.updateDeliveryTime(noOfVehicles, totalWeight, totalPackages, maxWeight, maxSpeed, packages);
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		for(Package pkg:packages) {
			System.out.println(pkg.getId()+" "+(int)pkg.getDiscount()+" "+(int)pkg.getCost()+" "+Float.valueOf(df.format(pkg.getDeliveryTime())));
		}
		
	}
	
	


}
