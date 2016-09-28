package igorshulga.Messages;

/**
 * Created by igor on 27.09.16.
 */
public class MorningGreeting extends Message {
    private static final String MORNING = "morning";
    
    @Override
    public String getAddressee() {
        return MORNING;
    }
}
