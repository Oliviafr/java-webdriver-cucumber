package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class JavaStepDefs {
    @Then("I say Hello World One")
    public void iSayHelloWorldOne() {
        System.out.println("Hello World! One!\r\n");
    }

    @Then("Print Hello, I'm a student")
    public void printHelloIMAStudent() {
        String greeting ="Hello";
        String text = "I'm a student";
        System.out.println(greeting + "," + text);

    }

    @Given("I act on {string} and {string}")
    public void iActOnAnd(String str_1, String str_2) {
        System.out.println(str_1);
        System.out.println(str_2);
        System.out.println(str_1.toUpperCase());
        System.out.println("Exacly comperisson ==: " + str_1.equals(str_2));
        System.out.println(("Exac compericon equal:" +str_1.equals(str_2)));
        System.out.println("Compericon lower case equal:" + str_1.toLowerCase().equals(str_2.toLowerCase()));
        System.out.println("Compericon lower case contans:" + str_1.toLowerCase().contains(str_2.toLowerCase()));

    }

    @Given("I would like to compare {string} with {string}")
    public void iWouldLikeToCompareWith(String str_1, String str_2) {
        System.out.println("I compare:" + str_1 + " and " + str_2);
      if (str_1.equals(str_2))
        System.out.println("equal!");
      else
        System.out.println("not equal!");
    }

    @Given("^I concatenate \"(.+)\" and \"(.+)\"$")
    public void iContatenateStrings(String str1, String str2) {
        System.out.println("Here is my concatenation:" + str1 +" "+ str2.toLowerCase());
    }

    @Given("Create object from Date_custom")
    public void iCreateDate() {
        Date_custom date = new Date_custom();
    }


//    //date today type localDate
//    @Given("^today is")
//    public LocalDate today_is() {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        return localDate;
//    }
    //date today type Date

}
// Slava's def

//package definitions;
//
//        import cucumber.api.java.en.Given;
//
//public class JavaStepDefs {
//    @Given("I say hello world")
//    public void iSayHelloWorld() {
//        System.out.println("Hello World!");
//
//        String greeting = "hello";
//        String name = "I'm Slava";
//
//        System.out.println(greeting.toUpperCase() + " " + name);
//    }
//
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
//
//    @Given("I compare {string} and {string}")
//    public void iCompareAnd(String str1, String str2) {
//        if (str1.equals(str2)) {
//            System.out.println("Strings are equal: " + str1 + " " + str2);
//        } else {
//            System.out.println("Strings are not equal: " + str1 + " " + str2);
//        }
//
//    }
//}