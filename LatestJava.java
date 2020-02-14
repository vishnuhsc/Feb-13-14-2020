public class LatestJava  {
	public static void main(String[] args) {
		int num = 12 % 2;
		//String result = "";
		
		String result = switch(num) {
			case 0 -> "Even";
			case 1 -> "Odd";
			default -> "Huh!";
		};
		
		String result = "Even" if num == 0 else "odd";
		
		
		// switch(num) {
		// 	case 1:
		// 	 result = "Odd";
		// 	 break;
		// 	case 0:
		// 	 result = "Even";
		// 	 break;
		// 	default:
		// 	 result = "Huh!";
		// };
		System.out.println(result);
	}
}