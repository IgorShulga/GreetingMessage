package igorshulga.Messages;

/**
 * Created by igor on 27.09.16.
 */
public class DayGreeting extends Message {
    private static final String DAY = "day";
    
    @Override
    public String getAddressee() {
        return DAY;
    }
}
