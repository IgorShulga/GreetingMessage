package igorshulga;

import igorshulga.Messages.Message;
import org.apache.log4j.Logger;

import java.time.LocalTime;

/**
 * Created by Igor Shulga on 23.09.16.
 * @author Igor Shulga
 * Greets the user program in the console depending on the current time
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Start program");
        
        GreetingCreation greetingCreation = new GreetingCreation();
        Message message = greetingCreation.getMessage(LocalTime.now().getHour());
        message.printMessage();
    }
}
