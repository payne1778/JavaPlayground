package DelayedConstCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class DelayedConstCollection {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "blueberry")); 
        
        System.out.println("Before editing: ");
        fruits.forEach(System.out::println);

        fruits.add("pineapple");
        System.out.println("Added \"pineapple\": ");
        fruits.forEach(System.out::println);

        fruits = Collections.unmodifiableList(fruits);  // acts like delayed const

        fruits.add("orange");                           // throws exception
        fruits.forEach(System.out::println);

        fruits.remove(1);                               // throws exception
        fruits.forEach(System.out::println);

        fruits.set(1, "strawberry");                    // throws exception
        fruits.forEach(System.out::println);
    }
}
