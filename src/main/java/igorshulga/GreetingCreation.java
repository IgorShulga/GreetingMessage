package igorshulga;

import igorshulga.Messages.*;
import org.apache.log4j.Logger;

import java.time.LocalTime;

/**
 * Created by igor on 27.09.16.
 */
public class GreetingCreation implements MessagesCreation {
    
    private static final Logger LOGGER = Logger.getLogger(GreetingCreation.class);

    private static final float MORNING = 6f;
    private static final float DAY= 9f;
    private static final float EVENING = 19f;
    private static final float NIGHT = 23f;
    private static final float MIDNIGHT_24 = 24f;
    private static final float MIDNIGHT_0 = 0f;    

    @Override
    public Message getMessage(float timeClock) {
        
        if ((timeClock >= MORNING) && (timeClock < DAY)) {
            LOGGER.info("Create message => Good morning, World!");
            return new MorningGreeting();
        } else 
        if ((timeClock >= DAY) && (timeClock < EVENING)) {
            LOGGER.info("Create message => Good day, World!");
            return new DayGreeting();
        } else 
        if ((timeClock >= EVENING) && (timeClock < NIGHT)) {
            LOGGER.info("Create message=> Good evening, World!");
            return new EveningGreeting();
        } else
        if((timeClock >= NIGHT || timeClock <= MIDNIGHT_24) 
                && ((timeClock >= MIDNIGHT_0) || (timeClock < MORNING))) {
            LOGGER.info("Create message => Good night, World!");
            return new NightGreeting();
        } else {
            LOGGER.info("Mistake: invalid time " + LocalTime.now() + ", application crashes!");
            return null;
        }
    }
}
