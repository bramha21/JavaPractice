package test.java8.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.java8.functional.interfaces.Book;
import com.java8.functional.interfaces.MyConsumer;
import com.java8.functional.interfaces.Person;
import com.java8.functional.interfaces.SquareRoot;

public class FunctionalInterfacesTest {

	public static void main(String[] args) {
		String s = "http://hrz-navigate5v.ptcnet.ptc.com:20850/Windchill";
		
		System.out.println(s.split("(?<=Windchill)")[0]);
		
		//testFunctionalInterfacesBasics();

		//testFunctionalInterface_Supplier();

		//testFunctionalInterface_Consumer();

		//testFunctionalInterface_Function();
	}

	private static void testFunctionalInterface_Function() {
		List<Book> books = new ArrayList<>();
		Book b1 = new Book("Alchemist", 200, "motivational", "Paul");
		Book b2 = new Book("Ice and Fire", 600, "fiction", "Martin");
		Book b3 = new Book("Harry Potter", 99, "fiction", "Rowling");
		Book b4 = new Book("Morning Miracle", 150, "motivational", "Hal");
		Book b5 = new Book("Clean Code", 1400, "software", "Bob");
		Book b6 = new Book("Algorithms", 1900, "software", "Caigman");
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		books.add(b6);

		BiFunction<String, List<Book>, List<Book>> byTag = (a, b) -> b.stream().filter(c -> c.getTag().contains(a)).collect(Collectors.toList());
		BiFunction<String, List<Book>, List<Book>> byAuthor = (a, b) -> b.stream().filter(c -> c.getAuthor().contains(a)).collect(Collectors.toList());
		Function<List<Book>, List<Book>> sortByPrice = b->b.stream().sorted((x,y)-> x.getPrice().compareTo(y.getPrice())).collect(Collectors.toList());
		Function<List<Book>, Optional<Book>> first = b-> b.stream().findFirst();

		Function<List<Book>, Optional<Book>> cheapest = first.compose(sortByPrice);
		
		Optional<Book> cheapBook = cheapest.apply(books);
	}

	private static void testFunctionalInterface_Consumer() {
		MyConsumer<String> consumer1 = (n) -> {
			System.out.println(n + "_A");
		};
		// consumer1.accept("Bramha");

		MyConsumer<String> consumer2 = (n) -> {
			System.out.println(n + "_B");
		};

		MyConsumer<String> consumer3 = (n) -> {
			System.out.println(n + "_C");
		};

		consumer1.andThen(consumer2).andThen(consumer3).accept("Ravi");
	}

	private static void testFunctionalInterface_Supplier() {
		Supplier<Person> supplier = () -> {
			return new Person("Son", 23, "Koria");
		};
		Person p = supplier.get();
		System.out.println(p);

		IntSupplier intSupplier = () -> (10);

		System.out.println("Integer Suplpier : " + intSupplier.getAsInt());

	}

	private static void testFunctionalInterfacesBasics() {
		int n = 4;

		// SquareRoot sr = (i) -> (Math.sqrt(i));
		SquareRoot sr = (i, j) -> {
			double a = i;
			a = a + 10;

			return a;
		};

		System.out.println(sr.add(n, n));
	}
}
