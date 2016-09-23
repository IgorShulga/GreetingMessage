package igorshulga;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.time.LocalTime;

/**
 * Created by Igor Shulga on 23.09.16.
 */
public class Greeting {

    public static final Logger log = Logger.getLogger(Greeting.class);

//    The point of time when changing message
    private static final LocalTime MORNING = LocalTime.parse("06:00:00.000");
    private static final LocalTime DAY= LocalTime.parse("09:00:00.000");
    private static final LocalTime EVENING = LocalTime.parse("19:00:00.000");
    private static final LocalTime NIGHT = LocalTime.parse("23:00:00.000");

    public static LocalTime currentTime;

    private Greeting() {
        currentTime = LocalTime.now();
    }

    private Greeting(String greeting) {
        currentTime = LocalTime.parse(greeting);
    }

//    Determine the currently time period and return the correct message
    public String getGreeting() throws ParseException {

        if ((currentTime.isAfter(MORNING) && currentTime.isBefore(DAY))) {
            log.info("Create => Good morning, World!");
            return "MORNING";
        } else
        if (currentTime.isAfter(DAY) && currentTime.isBefore(EVENING)) {
            log.info("Create => Good day, World!");
            return "DAY";
        } else
        if (currentTime.isAfter(EVENING) && currentTime.isBefore(NIGHT)) {
            log.info("Create => Good evening, World!");
            return "EVENING";
        } else
            log.info("Create => Good night, World!");
            return "NIGHT";
    }

    public static Builder newBuilder(){
        return new Greeting().new Builder();
    }

    public static Builder newBuilder(String greeting)throws ParseException{
        return new Greeting(greeting).new Builder();
    }

    public class Builder{

        public Builder() {
        }

        public Greeting build(){
            return Greeting.this;
        }
    }
}
