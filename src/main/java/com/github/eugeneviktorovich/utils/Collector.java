package com.github.eugeneviktorovich.utils;

import com.github.eugeneviktorovich.io.Writer;
import com.github.eugeneviktorovich.services.CollectionService;
import com.github.eugeneviktorovich.services.MessageService;
import com.skype.ChatMessage;
import com.skype.SkypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Collect and output chat messages.
 *
 * @author Eugene Viktorovich
 */
public class Collector {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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

    /**
     * @throws SkypeException If there is a problem with the connection or state at the Skype client.
     */
    public void run() throws SkypeException {
        List<String> messages = new ArrayList<String>();

        for (ChatMessage message : messageService.getTodayChatMessages()) {
            collectionService.collect(messages, message.getContent());
        }

        writer.write(messages);
    }
}
