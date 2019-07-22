package definitions;

import cucumber.api.java.en.Given;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Date_custom {
    @Given("^today is")
    public Date Datetoday() {
        LocalDate localDate = LocalDate.now();
//        System.out.println(datetoday);
        return convertToDateViaSqlDate(localDate);
    }
    //convert localdate to date
    private Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
    //date format type date from string

    @Given("^the date of (.*?)$")
    public String TheDateOf(String DateToday) {
        Date DateTodaystr = Datetoday();
        System.out.println(DateToday +" "+ DateTodaystr);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = sdf.format(DateTodaystr);
        System.out.println(dateString);
        return dateString;
    }

}
