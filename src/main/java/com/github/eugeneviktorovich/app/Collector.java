package com.github.eugeneviktorovich.app;

import com.github.eugeneviktorovich.services.CollectionService;
import com.github.eugeneviktorovich.services.MessageService;
import com.github.eugeneviktorovich.utils.MessageWriter;
import com.github.eugeneviktorovich.utils.Writer;
import com.skype.ChatMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Viktorovich
 */
public class Collector {

    //private static volatile PrintWriter log = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {

        MessageService messageService = new MessageService();
        CollectionService collectionService = new CollectionService();
        Writer writer = new MessageWriter();

        List<String> messages = new ArrayList<>();

        for (ChatMessage message : messageService.getTodayChatMessages()) {
            collectionService.collect(messages, message.getContent());
        }

        writer.write(messages);
    }
}
