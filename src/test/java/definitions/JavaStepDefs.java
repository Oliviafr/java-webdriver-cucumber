package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import java.util.HashMap;

import java.util.*;

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
    public void iActOnAnd( String str_1, String str_2 ) {
        System.out.println(str_1);
        System.out.println(str_2);
        System.out.println(str_1.toUpperCase());
        System.out.println("Exacly comperisson ==: " + str_1.equals(str_2));
        System.out.println(("Exac compericon equal:" + str_1.equals(str_2)));
        System.out.println("Compericon lower case equal:" + str_1.toLowerCase().equals(str_2.toLowerCase()));
        System.out.println("Compericon lower case contans:" + str_1.toLowerCase().contains(str_2.toLowerCase()));

    }

    @Given("I would like to compare {string} with {string}")
    public void iWouldLikeToCompareWith( String str_1, String str_2 ) {
        System.out.println("I compare:" + str_1 + " and " + str_2);
        if (str_1.equals(str_2))
            System.out.println("equal!");
        else
            System.out.println("not equal!");
    }

    @Given("^I concatenate \"(.+)\" and \"(.+)\"$")
    public void iContatenateStrings( String str1, String str2 ) {
        System.out.println("Here is my concatenation:" + str1 + " " + str2.toLowerCase());
    }

    @Given("Create object from Date_custom")
    public void iCreateDate() {
        Date_custom date = new Date_custom();
    }

    // Slava's example
    @Given("I print url for {string} page")
    public void iPrintUrlForPage( String site ) {
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
    public void iPrintMyarrFromArray( int arrnum ) {
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
    public void givenIGoToPage( String site ) {
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
        List<Integer> arraylist = List.of(1, 10, 2, 15, 57, 1);
        System.out.println(arraylist);
//        int[]myarro= new int[]{1, 8, 4, 7, 5, 2};
        SortMyArray(arraylist);
    }

    private void SortMyArray( List<Integer> array ) {
        int n = array.size();
        int temp;
        ArrayList sortedlist;
        sortedlist = new ArrayList();
        for (int i = 0; i < n; i++) // Looping through the array length
        {
            System.out.println("Sort Pass Number " + (i + 1));
            for (int j = 1; j < (n - i); j++) {
                System.out.println("Comparing " + array.get(j - 1) + " and " + array.get(j));
                int c = array.get(j);
                int d = array.get(j - 1);
//                Collections.sort(array);
//                for (Integer item:array){
//                    System.out.println(item);
//                }
//                swap elements
                if (c < d) {
                    temp = c;
                    sortedlist.set(j - 1, c);
                    sortedlist.set(j, temp);
                    System.out.println(array.get(j) + " is greater than " + array.get(j - 1));
                    System.out.println("Swapping Elements: New Array After Swap");
                }
            }
        }
//        PrintArrayList(array);
    }
//        static void bubbleSort(int[] array)
//        {
//            int n = array.length;
//            int temp = 0;
//            for(int i=0; i < n; i++) // Looping through the array length
//            {  System.out.println("Sort Pass Number "+(i+1));
//                for(int j=1; j < (n-i); j++)
//                {
//                    System.out.println("Comparing "+ array[j-1]+ " and " + array[j]);
//                    if(array[j-1] > array[j])
//                    {
//
//                        //swap elements
//                        temp = array[j-1];
//                        array[j-1] = array[j];
//                        array[j] = temp;
//                        System.out.println(array[j]  + " is greater than " + array[j-1]);
//                        System.out.println("Swapping Elements: New Array After Swap");
//                        PrintArray(array);
//                    }
//
//                }
//            }
//
//        }


    @Given("I print time now {string}")
    public void iPrintTimeNow( String pagetime ) {
        Time_custom time = new Time_custom();
        System.out.println(time.TimeNow(pagetime));
    }


    @Given("I print array with sum zero for {int}")
    public static int[] iPrintArrayWithSumZeroFor( int num ) {
        int[] array = new int[num];
        int i;
        int sum = 0;
        for (i = 0; i < array.length - 1; i++) {
//            array[i] = i;
            sum += array[i];
//            System.out.println(i);
        }
        int laste = -sum;
        array[num - 1] = laste;
        System.out.println(laste);
//        System.out.println(sum + laste);
        System.out.println();
        PrintArray(array);
        return array;
    }

    private static void PrintArray( int[] arr ) {
        for (int item : arr)
            System.out.println(item);
    }

    private static void PrintArrayList( List<Integer> array ) {
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }

    private static void PrintArrayChar( char[] array ) {
        for (char c : array) {
            System.out.println(c);
        }
    }

    private static int sumArray( int[] array ) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    @Given("I swap variables")
    public void iSwapVariables() {
        int x = 5;
        int y = 3;
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("x: " + x);
        System.out.println("y: " + y);

    }

    @Given("Create an array mult of {int}")
    public ArrayList createAnArrayMultOf( int num ) {
        ArrayList arr = new ArrayList();
        for (int i = 1; i < num; i++) {
            if (i % 2 == 0) {
                arr.add(i);
                System.out.println(i);
            }
        }
        return arr;

    }

    @Given("I print console logs")
    public void iPrintConsoleLogs() throws InterruptedException {
        Thread.sleep(3000);
        LogEntries logs;
        logs = getDriver().manage().logs().get("browser");
        for (LogEntry log : logs) {
            System.out.println(log);
        }
        System.out.println("____________");
    }

    @Given("I write the code to exchange first and last numbers in an array")
    public void iWriteTheCodeToExchangeFirstAndLastNumbersInAnArray() {
        int[] array = new int[]{1, 8, 4, 7, 5, 2};
        int n = array.length;
        int temp = array[0];
        array[0] = array[n - 1];
        array[n - 1] = temp;
        PrintArray(array);
    }

    @Given("I write a loop even numbers from {int} to {int}")
    public void iWriteALoopEvenNumbersFrom( int num1, int num2 ) {
        ArrayList arr = new ArrayList();
        for (int i = num1; i <= num2; i++) {
            if (i % 2 == 0) {
                arr.add(i);
            }
        }
        PrintArrayList(arr);
    }

    @Given("I write the code to print the characters from {int}rd position to {int}th in a string")
    public void iWriteTheCodeToPrintTheCharactersFromRdPositionToThInAString( int pos1, int pos2 ) {
        String str = "iWriteTheCodeToPrintTheCharactersFromRdPositionToThInAString";
//        System.out.println(str.substring(pos1 - 1, pos2));
//        char[] chars = str.toCharArray();
        for (int i = 2; i <= 7; i++) {
            System.out.println(str.charAt(i));
        }
    }

    @Given("Reverse a string")
    public void reverseAString() {
        String str = "AString";
//        System.out.println(str.substring(pos1 - 1, pos2));
//        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println("Reversed string is:");
        System.out.println(sb.toString());
    }

    @Given("Print every {int}rd character")
    public void printEveryRdCharacter( int num ) {
        String str = "Numberofcharacters";
        for (int i = 0; i <= str.length() - 1; i++) {
            if ((i + 1) % num == 0) {
                if (i != 0) {
                    System.out.println(str.charAt(i));
                }
            }
        }
    }

    @Given("Check if number is divisible by {int} but not divisible by {int}")
    public void checkIfNumberIsDivisibleByButNotDivisibleBy( int d1, int d2 ) {
        int num = 50;
        if (num % d1 == 0 && num % d2 != 0) {
            System.out.println(true);
        } else System.out.println(false);
    }

//    @Given("I find the number with most occurrences in <data>, output should be this number. Try using hashmap")
//    public void iFindTheNumberWithMostOccurrencesInDataOutputShouldBeThisNumberTryUsingHashmap(int [] array) {
//
//        int max = 0;
//        for (int i = 0; i < array.length; i++) {
//            int count = 0;
//            for (int j = 0; j < array.length; j++) {
//                if (array[i]==array[j])
//                    count++;
//            }
//            if (count >= max)
//                max = count;
//        }
//        System.out.println(max);
//    }

    @Given("I find the number with most occurrences in array, output should be this number. Try using hashmap")
    public void iFindTheNumberWithMostOccurrencesInArrayOutputShouldBeThisNumberTryUsingHashmap() {
        int[] array = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 6, 7};
        int max = 0;
        int valueofcount = 0;
//        for (int i = 0; i < array.length; i++) {
//            int count = 0;
//            for (int j = 0; j < array.length; j++) {
//                if (array[i]==array[j])
//                    count++;
//            }
//            if (count >= max)
//                max = count;
//                valueofcount=array[i];
//        }
//        System.out.println(max + " times, value " + valueofcount);


        int count = 0;
        Map<Integer, Integer> newhash = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
//                System.out.println(count);
//                newhash.put(count, array[i]);
                valueofcount = array[i - 1];

            } else {
                if (count > max) {
                    max = count;
//                    newhash.put(count, array[i]);
                }
            }
        }
        System.out.println(max + " times, value " + valueofcount);
        for (Map.Entry<Integer, Integer> entry : newhash.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

    }



//        HashMap hm = new HashMap();
//        for (int i = 0; i < array.length; i++) {
//            Double key = new Double(array[i]);
//            if ( hm.containsKey(key) ) {
//                value = hm.get(key);
//                hm.put(key, value + 1);
//            } else {
//                hm.put(key, 1);
//            }
//        }
//
    }



//    [1,2,2,3,3,3,4,5,6,7]Find the number with most occurrences, output should be this number. Try using hashmap



//==================================================================

// char[] chars = str.toCharArray();
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