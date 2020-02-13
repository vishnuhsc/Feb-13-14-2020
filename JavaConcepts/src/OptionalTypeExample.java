import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTypeExample {

	static Map<Integer, String> romanNumerals = new HashMap<>();
	
	public static void main(String[] args) {
		romanNumerals.put(1, "I");
		romanNumerals.put(2, "II");
		romanNumerals.put(3, "III");
		romanNumerals.put(4, "IV");
		
		String one = getRomanNumeralOf(1);
		System.out.println(one + ", " + one.length());
		
		String two = getRomanNumeralOf(2);
		System.out.println(two + ", " + two.length());
		
		String ten = getRomanNumeralOf(10);
		if(ten != null) {
			System.out.println(ten + ", " + ten.length());	
		}
		
		Optional<String> oneVal = getValueOf(1);
		if(oneVal.isPresent()) {
			System.out.println(oneVal.get());
		}
		else {
			System.out.println("one is not available");
		}
		Optional<String> seven = getValueOf(7);
		if(seven.isPresent()) {
			System.out.println(seven.get());
		}
		
	}
	
	static Optional<String> getValueOf(int number) {
		Optional<String> output = Optional.ofNullable(romanNumerals.get(number));
		return output;
	}
	
	
	
	
	
	
	
	
	
	static String getRomanNumeralOf(int number) {
		String output = null;
		output = romanNumerals.get(number);
		return output;
		
		
	}

}
