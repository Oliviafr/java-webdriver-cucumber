package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Collections;

import static java.util.Arrays.*;
import static java.util.Arrays.sort;
import static support.TestContext.getDriver;


public class JavaStepDefs {
    @Then("I say Hello World One")
    public void iSayHelloWorldOne() {
        System.out.println("Hello World! One!\r\n");
    }

    @Then("Print Hello, I'm a student")
    public void printHelloIMAStudent() {
        String greeting = "Hello";
        String text = "I'm a student";
        System.out.println(greeting + "," + text);

    }

    @Given("I act on {string} and {string}")
    public void iActOnAnd(String str_1, String str_2) {
        System.out.println(str_1);
        System.out.println(str_2);
        System.out.println(str_1.toUpperCase());
        System.out.println("Exacly comperisson ==: " + str_1.equals(str_2));
        System.out.println(("Exac compericon equal:" + str_1.equals(str_2)));
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
        System.out.println("Here is my concatenation:" + str1 + " " + str2.toLowerCase());
    }

    @Given("Create object from Date_custom")
    public void iCreateDate() {
        Date_custom date = new Date_custom();
    }

    // Slava's example
    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com/");
        } else if (site.equalsIgnoreCase("yahoo")) {
            System.out.println("https://www.yahoo.com/");
        } else if (site.equalsIgnoreCase("quote")) {
            System.out.println("https://skryabin.com/market/quote.html");
        } else {
            System.out.println("Unsupported site: " + site);
        }
    }

    @Given("I print myarr")
    public void iPrintMyarr() {
        String[] myarr = {"a", "b", "c", "d"};
        System.out.println(myarr[1]);
//        for(String item : myarr)
//        {
//            System.out.println(item);
//        }
        ArrayList<String> myarrlist = new ArrayList<>();
        myarrlist.add("lala");
        myarrlist.add("baba");
        List<String> myarrList = List.of("al", "bl", "cl", "dl");
        List<Integer> myintLisy = List.of(1, 10, 2, 15, 57, 1);
        System.out.println(myintLisy);
//        for (Integer item : myintLisy) {
//            System.out.println(item);
//        }
//        swap operation
//        int temp = myintLisy.get(2);

        for (int i = 0; i < myarr.length; i++) {
            System.out.println(myarr[2]);
        }
        for (int i = 0; i < myarrList.size(); i++) {
            System.out.println(myarrList.get(2));
        }

    }


    @Given("I print myarr[{int}] from Array")
    public void iPrintMyarrFromArray(int arrnum) {
        String[] myarr = {"a", "b", "c", "d"};
//        Immutable
        System.out.println(myarr[arrnum]);
    }

    @Given("I work with maps")
    public void iWorkWithMaps() {
//        Map <String, String> mymap = Map.of("key1","val1","key2","val2","key3","val3")
        Map<String, String> map = new HashMap<>();
        map.put("firstname", "John");
        map.put("lastname", "Josopovich");
//        System.out.println(map.get("firstname"));
        System.out.println(map);
    }

    @Given("Given I go to {string} page")
    public void givenIGoToPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com/");
        } else if (site.equalsIgnoreCase("yahoo")) {
            getDriver().get("https://www.yahoo.com/");
        } else if (site.equalsIgnoreCase("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
            try {
                Thread.sleep(0b1111101000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Unsupported site: " + site);
        }
    }

    @Given("I sort my Array")
    public void iSortMyArray() {
//        int[] array = new int[10];
//        Random rand = new Random();
//        for (int i = 0; i < array.length; i++)
//            array[i] = rand.nextInt(100) + 1;
////        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//// in reverse order
//        for (int i = array.length - 1; i >= 0; i--)
//            System.out.print(array[i] + " ");
//        System.out.println();

        List<Integer> arraylist = List.of(1, 10, 2, 15, 57, 1);
        System.out.println(arraylist);
//        int[]myarro= new int[]{1, 8, 4, 7, 5, 2};
        SortMyArray(arraylist);
    }

    private void SortMyArray( List<Integer> array ) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.size() - j; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    tmp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, tmp);
                    swapped = true;

                }
            }
        }
//            public void bubbleSort(int[] array) {
//                boolean swapped = true;
//                int j = 0;
//                int tmp;
//                while (swapped) {
//                    swapped = false;
//                    j++;
//                    for (int i = 0; i < array.length - j; i++) {
//                        if (array[i] > array[i + 1]) {
//                            tmp = array[i];
//                            array[i] = array[i + 1];
//                            array[i + 1] = tmp;
//                            swapped = true;
//                        }
//                    }
//                }
//            }
    }

    @Given("I print time now {string}")
    public void iPrintTimeNow( String pagetime ) {
        Time_custom time = new Time_custom();
        System.out.println(time.TimeNow(pagetime));
    }
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