package by.volfgang.linkcollector.app;

import by.volfgang.linkcollector.services.MessageService;
import com.skype.ChatMessage;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Viktorovich
 */
public class Collector {

    //private static volatile PrintWriter log = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {

        //log.println("start app");

        MessageService messageService = new MessageService();

        PrintWriter out = new PrintWriter(new FileWriter(System.getProperty("user.home") + "/Desktop/skype_log.txt"), true);

        for (ChatMessage message : messageService.getTodayChatMessages()) {
            Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
            Matcher matcher = pattern.matcher(message.getContent());
            while (matcher.find()) {
                out.append(matcher.group());
                out.println();
            }
        }

        out.close();

        //log.println("complete ...");
    }
}
