package igorshulga;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

/**
 * Created by igor on 23.09.16.
 */
public class GreetingTest extends TestCase {

    private Greeting greeting;

    @Test
    public  void testGetEvent() throws ParseException {
        greeting = Greeting.newBuilder().build();
        switch (greeting.getGreeting()){
            case "MORNING": break;
            case "DAY": break;
            case "EVENING":break;
            case "NIGHT": break;
            default:
                Assert.fail();
        }
    }

    @Test
    public void testNight_1()throws ParseException{
        greeting = Greeting.newBuilder("23:00:00").build();
        Assert.assertEquals(greeting.getGreeting(), "NIGHT");
    }

    @Test
    public void testNight_2()throws ParseException{
        greeting = Greeting.newBuilder("23:00:01").build();
        Assert.assertEquals(greeting.getGreeting(), "NIGHT");
    }

    @Test
     public void testNight_3()throws ParseException{
        greeting = Greeting.newBuilder("05:59:59").build();
        Assert.assertEquals(greeting.getGreeting(), "NIGHT");
    }

    @Test
     public void testNight_4()throws ParseException{
        greeting = Greeting.newBuilder("04:30:00").build();
        Assert.assertEquals(greeting.getGreeting(), "NIGHT");
    }

    @Test
     public void testNight_5()throws ParseException{
        greeting = Greeting.newBuilder("02:00:02").build();
        Assert.assertEquals(greeting.getGreeting(), "NIGHT");
    }

    @Test
     public void testEvening_1()throws ParseException{
        greeting = Greeting.newBuilder("19:00:09").build();
        Assert.assertEquals(greeting.getGreeting(), "EVENING");
    }

    @Test
    public void testEvening_2()throws ParseException{
        greeting = Greeting.newBuilder("21:59:59").build();
        Assert.assertEquals(greeting.getGreeting(), "EVENING");
    }

    @Test
    public void testEvening_3()throws ParseException{
        greeting = Greeting.newBuilder("20:00:00").build();
        Assert.assertEquals(greeting.getGreeting(), "EVENING");
    }

    @Test
    public void testEvening_4()throws ParseException{
        greeting = Greeting.newBuilder("22:59:59").build();
        Assert.assertEquals(greeting.getGreeting(), "EVENING");
    }
    @Test
    public void testEvening_5()throws ParseException{
        greeting = Greeting.newBuilder("19:00:01").build();
        Assert.assertEquals(greeting.getGreeting(), "EVENING");
    }

    @Test
    public void testDay_1()throws ParseException{
        greeting = Greeting.newBuilder("18:59:59").build();
        Assert.assertEquals(greeting.getGreeting(), "DAY");
    }

    @Test
    public void testDay_2()throws ParseException{
        greeting = Greeting.newBuilder("09:59:59").build();
        Assert.assertEquals(greeting.getGreeting(), "DAY");
    }

    @Test
    public void testDay_3()throws ParseException{
        greeting = Greeting.newBuilder("09:00:10").build();
        Assert.assertEquals(greeting.getGreeting(), "DAY");
    }

    @Test
    public void testDay_4()throws ParseException{
        greeting = Greeting.newBuilder("09:00:01").build();
        Assert.assertEquals(greeting.getGreeting(), "DAY");
    }
    @Test
    public void testDay_5()throws ParseException{
        greeting = Greeting.newBuilder("12:00:01").build();
        Assert.assertEquals(greeting.getGreeting(), "DAY");
    }

    @Test
    public void testMorning_1()throws ParseException{
        greeting = Greeting.newBuilder("06:01:00").build();
        Assert.assertEquals(greeting.getGreeting(), "MORNING");
    }

    @Test
    public void testMorning_2()throws ParseException{
        greeting = Greeting.newBuilder("06:00:01").build();
        Assert.assertEquals(greeting.getGreeting(), "MORNING");
    }

    @Test
    public void testMorning_3()throws ParseException{
        greeting = Greeting.newBuilder("08:59:59").build();
        Assert.assertEquals(greeting.getGreeting(), "MORNING");
    }

    @Test
    public void testMorning_4()throws ParseException{
        greeting = Greeting.newBuilder("07:00:00").build();
        Assert.assertEquals(greeting.getGreeting(), "MORNING");
    }
    @Test
    public void testMorning_5()throws ParseException{
        greeting = Greeting.newBuilder("08:59:58").build();
        Assert.assertEquals(greeting.getGreeting(), "MORNING");
    }
}