package igorshulga;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Igor Shulga on 23.09.16.
 * @author Igor Shulga
 * Greets the user program in the console depending on the current time
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Start programm");
        Locale.getDefault();

        ResourceBundle resource = ResourceBundle.getBundle("bundle");

        Greeting greeting = Greeting.newBuilder().build();

        String greetings = null;
        try {
            greetings = greeting.getGreeting();
        }catch (ParseException e){
            log.error("Parse exception", e);
        }

        if (greetings != null) {
            switch (greetings) {
                case "MORNING":
                    System.out.println(resource.getString("morning"));
                    log.info("Print greeting of the morning message");
                    break;
                case "DAY":
                    System.out.println(resource.getString("day"));
                    log.info("Print greeting of the day message");
                    break;
                case "EVENING":
                    System.out.println(resource.getString("evening"));
                    log.info("Print greeting of the evening message");
                    break;
                case "NIGHT":
                    System.out.println(resource.getString("night"));
                    log.info("Print greeting of the night message");
                    break;
            }
        } else log.warn("Greeting Message is null");
    }
}
