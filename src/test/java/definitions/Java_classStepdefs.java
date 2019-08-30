package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.Animal;
import pages.Cat;
import pages.Dog;
import pages.Lion;

import java.util.*;

public class Java_classStepdefs {
//    @Given("I say hello world")
//    public void iSayHelloWorld() {
//        System.out.println("Hello World!");
//
//        String greeting = "hello";
//        String name = "I'm Slava";
//
//        System.out.println(greeting.toUpperCase() + " " + name);
//    }

//    @Given("I act on {string} and {string}")
//    public void iActOnAnd(String str1, String str2) {
//        System.out.println(str1);
//        System.out.println(str2);
//
//        System.out.println(str1.toUpperCase());
//        System.out.println(str2.toUpperCase());
//
//        System.out.println(str1.length());
//        System.out.println(str2.length());
//
//        System.out.println("Exact comparison ==: " + str1 == str2);
//        System.out.println("Exact comparison equals: " + str1.equals(str2));
//
//        System.out.println(str1.toLowerCase().equals(str2.toLowerCase()));
//
//        System.out.println(str1.contains(str2));
//    }

//    @Given("I compare {string} and {string}")
//    public void iCompareAnd(String str1, String str2) {
//        if (str1.equals(str2)) {
//            System.out.println("Strings are equal: " + str1 + " " + str2);
//        } else {
//            System.out.println("Strings are not equal: " + str1 + " " + str2);
//        }
//
//    }

//    @Given("I print url for {string} page")
//    public void iPrintUrlForPage(String site) {
//        if (site.equalsIgnoreCase("google")) {
//            System.out.println("https://www.google.com/");
//        } else if (site.equalsIgnoreCase("yahoo")){
//            System.out.println("https://www.yahoo.com/");
//        } else if (site.equalsIgnoreCase("quote")) {
//            System.out.println("https://skryabin.com/market/quote.html");
//        } else {
//            System.out.println("Unsupported site: " + site);
//        }
//    }

//    @Given("I work with arrays")
//    public void iWorkWithArrays() {
//
//        int[] intArray = {3, 2, 55, 2};
//
//        String[] groceryList = {"kiwi", "apples", "oranges", "plum"};
//
//        System.out.println("------ forEach -----------");
//
//        for(String item : groceryList) {
//            System.out.println(item);
//        }
//
//        System.out.println("------- regular for ----------");
//
//        for(int i = 0; i < groceryList.length; i++) {
//            System.out.println(groceryList[i]);
//        }
//
//        System.out.println("-----------------");
//
//
//        System.out.println(groceryList[1]);
//
//        List<String> groceryArray = List.of("kiwi", "apples", "oranges", "plum");
//
//        System.out.println("------ forEach -----------");
//
//        for(String item : groceryArray) {
//            System.out.println(item);
//        }
//
//        System.out.println("------ regular for -----------");
//
//        for(int i = 0; i < groceryArray.size(); i++) {
//            System.out.println(groceryArray.get(i));
//        }
//
//        System.out.println("-----------------");
//
//
//
//        System.out.println(groceryArray.get(1));
//
//
//        String str1 = new String("name");
//        String str2 = "name";
//        Integer i1 = new Integer(5);
//        Integer i2 = 5;
//
//        List<String> groceryArray2 = new ArrayList<>();
//        groceryArray2.add("kiwi");
//        groceryArray2.add("orange");
//
//        Map<String, String> map = new HashMap<>();
//        map.put("firstName", "John");
//        map.put("listName", "Doe");
//    }

//    @Given("I work with maps")
//    public void iWorkWithMaps() {
//        Map<String, String> user = Map.of("firstName", "Slava", "lastName", "Skryabin");
//        System.out.println(user.get("lastName"));
//        System.out.println(user.get("firstName"));
//
//        Map<String, String> admin = Map.of("firstName", "John", "lastName", "Doe");
//        System.out.println(admin.get("lastName"));
//        System.out.println(admin.get("firstName"));
//
//
//
//    }

//    public boolean isDivisibleBy3(int num) {
//        if (num % 3 == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Given("I swap variables")
//    public void iSwapVariables() {
//        int x = 5;
//        int y = 3;
//
//        System.out.println("x: " + x);
//        System.out.println("y: " + y);
//
//        int temp = x;
//        x = y;
//        y = temp;
//
//        System.out.println("x: " + x);
//        System.out.println("y: " + y);
//
//        System.out.println();
//        System.out.println();
//    }
//
//    @And("I print numbers")
//    public void iPrintNumbers() {
//        int num = 10;
//
//        for (int i = 1; i <= num; i++) {
//            if (i % 3 == 0) {
//                System.out.println(i);
//            }
//        }
//    }

    @Given("I work with classes")
    public void iWorkWithClasses() {

        Animal tom = new Cat("Tom");
        tom.walk();
        tom.sleep();
        tom.eat("fish");
        tom.speak();

        Animal jack = new Dog();
        jack.walk();
        jack.sleep();
        jack.eat("bone");
        jack.speak();

        Animal lion_king = new Lion("lion_king","African");
        lion_king.walk();
        lion_king.sleep();
        lion_king.eat("meat");
        lion_king.speak("lion","African");


    }
}