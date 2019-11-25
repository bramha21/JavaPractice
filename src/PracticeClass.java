import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class PracticeClass {
	public static void main(String[] args) {
		System.out.println(fixedLengthString("Bramha", 10));
	}

	public static String fixedLengthString(String s, int length) {
		return String.format("%1$"+length+"s", s);
	}
	
	private static void example2() {
		System.out.println(doWorkImpl(() -> {
			return "Bramha";
		}));
	}

	public static String doWorkImpl(MyInterface in) {
		return in.doWork();
	}

	private static void example1() {
		String s1 = new String("a");
		String s2 = "a";

		HashMap<String, Integer> m = new HashMap<String, Integer>();
		m.put(s1, 1);
		m.put(s2, 2);

		System.out.println(m.size());

		m.forEach((key, value) -> {
			System.out.printf("Key : %s, Value : %d\n", key, value);
		});
	}
}

@FunctionalInterface
interface MyInterface {

	public String doWork();

	String toString();
}
