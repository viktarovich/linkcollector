package by.linkcollector.main;

import by.linkcollector.services.MessageService;
import com.skype.ChatMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Viktorovich
 */
public class MessageCollector {

    public static void main(String[] args) throws Exception {

        MessageService messageService = new MessageService();

        PrintWriter out = new PrintWriter(new FileWriter(System.getProperty("user.home") + "/Desktop/skype_log.txt"), true);

        for (ChatMessage message : messageService.getTodayChatMessages()) {
            //System.out.println(message.getContent());
            Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
            Matcher matcher = pattern.matcher(message.getContent());
            while (matcher.find()) {
                out.append(matcher.group());
                out.println();
            }
        }

        out.close();

        System.out.println("complete...");
    }
}

