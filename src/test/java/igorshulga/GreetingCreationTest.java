package igorshulga;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Created by igor on 28.09.16.
 * Test checks each hour of the 24 hours (step 1 minute) and the mistaken time
 */
public class GreetingCreationTest extends TestCase {

    private static final float MORNING = 6f;
    private static final float DAY= 9f;
    private static final float EVENING = 19f;
    private static final float NIGHT = 23f;
    private static final float MIDNIGHT_24 = 24f;
    private static final float MIDNIGHT_0 = 0f;
    
    //    1 minute = 1 / 60 = 0.01666667
    //    Message getMessage (float currentTime);
    public static final float ONE_MINUTE = 0.0167f;

    //    testing night message (from 23 to 24 hours)
    public void testNightMessageOne() throws Exception {
        Locale.getDefault();
        GreetingCreation greetingCreation = new GreetingCreation();
        String resultTest;
        float[] testTime = {NIGHT, NIGHT+ONE_MINUTE, MIDNIGHT_24-ONE_MINUTE, MIDNIGHT_24,
                MIDNIGHT_0, MIDNIGHT_0+ONE_MINUTE, MORNING-ONE_MINUTE};
        for(int i = 0; i < testTime.length; i++){
            resultTest = greetingCreation.getMessage(testTime[i]).getGreetingMessage();
            Assert.assertEquals("Доброй ночи, Мир!", resultTest);
        }
    }
    
//    testing morning message (from 6 to 9 hours)
    public void testMorningMessage() throws Exception {
        Locale.getDefault();
        GreetingCreation greetingCreation = new GreetingCreation();
        String resultTest;
        float[] testTime = {MORNING, MORNING+ONE_MINUTE, MORNING+30*ONE_MINUTE, DAY-ONE_MINUTE};
        for(int i = 0; i < testTime.length; i++){
            resultTest = greetingCreation.getMessage(testTime[i]).getGreetingMessage();
            Assert.assertEquals("Доброе утро, Мир!", resultTest);
        }
    }

//    testing day message (from 9 to 19 hours)
    public void testDayMessage() throws Exception {
        Locale.getDefault();
        GreetingCreation greetingCreation = new GreetingCreation();
        String resultTest;
        float[] testTime = {DAY, DAY+ONE_MINUTE, DAY+120*ONE_MINUTE, EVENING-ONE_MINUTE};
        for(int i = 0; i < testTime.length; i++){
            resultTest = greetingCreation.getMessage(testTime[i]).getGreetingMessage();
            Assert.assertEquals("Добрый день, Мир!", resultTest);
        }
    }

//    testing evening message (from 19 to 23 hours)
    public void testEveningMessage() throws Exception {
        Locale.getDefault();
        GreetingCreation greetingCreation = new GreetingCreation();
        String resultTest;
        float[] testTime = {EVENING, EVENING+ONE_MINUTE, NIGHT-18*ONE_MINUTE, NIGHT-ONE_MINUTE};
        for(int i = 0; i < testTime.length; i++){
            resultTest = greetingCreation.getMessage(testTime[i]).getGreetingMessage();
            Assert.assertEquals("Добрый вечер, Мир!", resultTest);
        }
    }

//    testing mistaken time and message
    @Test(expected = Exception.class)
    public void testCrashProgram() throws Exception {
        int invalidTime = 25;
        String resultTest = null;
        GreetingCreation greetingCreation = new GreetingCreation();
        greetingCreation.getMessage(invalidTime).getGreetingMessage();
        Assert.assertEquals(null, resultTest);
    }
}
