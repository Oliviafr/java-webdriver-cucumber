package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static support.TestContext.getDriver;


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

//    @Given(value = "I print url for {string} page")
//    public void iPrintUrlForGooglePage(String str) {
////        String google = null;
//        if (str.contains("google"))
//            System.out.println("https://www.google.com/" + str + "!");
//        else if (str.contains("quote"))
//        {
//            System.out.println("https://skryabin.com/market/quote.html" + str +"!");
//        }
//        else
//            System.out.println("not google! and not quote!");
//
//    }
// Slava's example
    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com/");
        } else if (site.equalsIgnoreCase("yahoo")){
            System.out.println("https://www.yahoo.com/");
        } else if (site.equalsIgnoreCase("quote")) {
            System.out.println("https://skryabin.com/market/quote.html");
        } else {
            System.out.println("Unsupported site: " + site);
        }
    }

    @Given("I print myarr")
    public void iPrintMyarr() {
        String[]myarr={"a","b","c","d"};
        System.out.println(myarr[1]);
        for(String item : myarr)
        {
            System.out.println(item);
        }
        ArrayList <String>  myarrlist = new ArrayList<>();
        myarrlist.add("lala");
        myarrlist.add("baba");
        List <String> myarrList = List.of("al","bl","cl","dl");
        for (String item : myarrList) {
            System.out.println(item);
        }
    }

    @Given("I print myarr[{int}] from Array")
    public void iPrintMyarrFromArray(int arrnum) {
        String[]myarr={"a","b","c","d"};
        System.out.println(myarr[arrnum]);
    }

    @Given("I work with maps")
    public void iWorkWithMaps() {
//        Map <String, String> mymap = Map.of("key1","val1","key2","val2","key3","val3")
        Map<String,String> map=new HashMap<>();
        map.put("firstname", "John");
        map.put("lastname", "Josopovich");
//        System.out.println(map.get("firstname"));
        System.out.println(map);
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