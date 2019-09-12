package com.java8.functional.interfaces;

import java.util.Objects;

@FunctionalInterface
public interface MyConsumer<T> {

	void accept(T t);

	default MyConsumer<T> andThen(MyConsumer<? super T> after) {
		Objects.requireNonNull(after);
		
	return new MyConsumer<T>() {
			@Override
			public void accept(T t) {
				MyConsumer.this.accept(t);
				after.accept(t);	
			}
		};
		
		/*return (T t) -> {
			accept(t);
			after.accept(t);
		};*/
		
	}	
}
