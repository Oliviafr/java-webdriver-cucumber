package definitions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class Time_custom {

    boolean TimeNow( String timefrompage ) {
//        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String time = new SimpleDateFormat("h:m").format(Calendar.getInstance().getTime());
        System.out.println(time);
        return timefrompage.contains(time);
    }
}