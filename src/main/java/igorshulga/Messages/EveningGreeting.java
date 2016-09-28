package igorshulga.Messages;

/**
 * Created by igor on 27.09.16.
 */
public class EveningGreeting extends Message {
    private static final String EVENING = "evening";
    
    @Override
    public String getAddressee() {
        return EVENING;
    }
}