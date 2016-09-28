package igorshulga.Messages;

/**
 * Created by igor on 27.09.16.
 */
public class NightGreeting extends Message {
    private static final String NIGHT = "night";
    
    @Override
    public String getAddressee() {
        return NIGHT;
    }
}
