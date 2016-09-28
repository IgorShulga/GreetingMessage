package igorshulga.Messages;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by igor on 27.09.16.
 */
public abstract class Message {
      
    private static final String BODY_MESSAGES = "messages";
    private static final String ADDRESSEE = "addressee";
    private static final String END_LINE = "endLine";


//    Greeting text depends on the time and user location
//    message consists of three parts: a greeting(BODY_MESSAGES), 
//    address (ADDRESSEE - World) and end of line ( END_LINE - !)
    public String getGreetingMessage(){

        Locale.getDefault();
        
        StringBuilder message = new StringBuilder();
        message.append(ResourceBundle.getBundle(BODY_MESSAGES).getString(getAddressee()))
                .append(", ")
                .append(ResourceBundle.getBundle(BODY_MESSAGES).getString(ADDRESSEE))
                .append(ResourceBundle.getBundle(BODY_MESSAGES).getString(END_LINE));
        return message.toString();
    }

    public abstract String getAddressee();
    
    public void printMessage() {
        System.out.println(getGreetingMessage());
    }
}
