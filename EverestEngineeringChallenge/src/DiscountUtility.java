import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DiscountUtility {
	
	public static List<Package> calculateDiscount(int baseCost, List<Package> packages) {
		
		List<Package> output = new ArrayList<Package>();
		
		for(Package pkg:packages) {
			float cost = baseCost + (pkg.getWeight()*10) + (pkg.getDistance()*5);
			float discountPercent = 0;
				if(validOffer(pkg.getCode())) {
					Offer ofr = Offer.valueOf(pkg.getCode());
					if(isInRange(pkg.getDistance(), ofr.getDistanceRange()) &&
					isInRange(pkg.getWeight(), ofr.getWeightRange())) {
						discountPercent = ofr.getDiscount();
					}
				}

			pkg.setDiscount((discountPercent/100)*cost);
			pkg.setCost((1-(discountPercent/100))*cost);
			output.add(pkg);
		}

		return output;
		
	}
	
	public static boolean validOffer(String code) {
		boolean result=false;
		for(Offer o: Offer.values()) {
			if(o.name().equals(code)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static boolean isInRange(float pkgDistance, String range) {
		return pkgDistance<=Integer.parseInt(range.split("-")[1]) && pkgDistance>=Integer.parseInt(range.split("-")[0]);
	}

}
