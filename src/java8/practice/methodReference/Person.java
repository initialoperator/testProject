package java8.practice.methodReference;

public class Person {
    /*
    * this Person class contains several method that goes with the same format as Supplier, Consumer, Function, Bifunction
    * */

    private String name;
    private int age;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    //supplier
    public String getName(){
        return this.name;
    }

    //consumer
    public void setName(String newName){
        this.name = newName;
    }

    //Function
    public String introduce(String subject){
        return "Hi "+ subject +", My name is "+this.name+".";
    }

    //static Function
    public static int countLength(String name){
        return name.length();
    }

    //Bifunctional static method
    public static Person createPerson(String firstName, String lastName){
        Person newp = new Person();
        newp.setName(firstName + " "+ lastName);
        return newp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Predicate static method
    public static boolean isMajor(Person p){
        return p.age >= 18;
    }


    public boolean isYoungerThan(Integer inputAge){
        return inputAge > this.age;
    }
}
