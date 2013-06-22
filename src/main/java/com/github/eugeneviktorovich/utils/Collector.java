package com.github.eugeneviktorovich.utils;

import com.github.eugeneviktorovich.services.CollectionService;
import com.github.eugeneviktorovich.services.MessageService;
import com.skype.ChatMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Viktorovich
 */
public class Collector {

    private CollectionService collectionService;
    private MessageService messageService;
    private Writer writer;

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }


    public void run() throws Exception {
        List<String> messages = new ArrayList<>();

        for (ChatMessage message : messageService.getTodayChatMessages()) {
            collectionService.collect(messages, message.getContent());
        }

        writer.write(messages);
    }
}
