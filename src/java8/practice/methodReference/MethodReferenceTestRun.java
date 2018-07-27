package java8.practice.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTestRun {

    public static void main(String[] args) {
        Person p = new Person();
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                p.setName(s);
            }
        };
        Supplier<String> supplier = p::getName;
        Function<String, String> function = p::introduce;

        Function<String, Integer> f = Person::countLength;

        BiFunction<String, Integer, Person> constructWithParameters = Person::new;

        consumer.accept("You");
        System.out.println(supplier.get());
        System.out.println(function.apply("Ava"));

        BiFunction<String, String, Person> biFunction = Person::createPerson;
        Person cz = biFunction.apply("Chrystian", "Zhang");
        System.out.println(cz.getName());

        cz.setAge(1);
        Predicate<Person> predicate = Person::isMajor;
        System.out.println(predicate.test(cz));

        //Constructor method reference
        Supplier<Person> construct = Person::new;
        BiFunction<String, Integer, Person> constructWithArgs = (name, age) -> new Person(name, age);


        p.setAge(18);

        List<Integer> ages = Arrays.asList(10, 19, 20, 1, 2, 25, 20, 15);
        ages.stream().filter(p::isYoungerThan).forEach(System.out::println);
    }
}
