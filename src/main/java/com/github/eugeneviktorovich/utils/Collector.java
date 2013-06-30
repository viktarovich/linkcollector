package com.github.eugeneviktorovich.utils;

import com.github.eugeneviktorovich.io.Writer;
import com.github.eugeneviktorovich.services.MatcherService;
import com.github.eugeneviktorovich.services.MessageService;
import com.skype.ChatMessage;
import com.skype.SkypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Collect and output chat messages.
 *
 * @author Eugene Viktorovich
 */
public class Collector {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private MatcherService matcherService;
    private MessageService messageService;
    private Writer writer;

    public void setMatcherService(MatcherService matcherService) {
        this.matcherService = matcherService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    /**
     * Collects messages and outputs to a storage.
     *
     * @throws SkypeException If there is a problem with the connection or state at the Skype client.
     */
    public void run() throws SkypeException {
        logger.info("Collector starts work.");

        List<String> messages = new ArrayList<>();

        for (ChatMessage message : messageService.getTodayChatMessages()) {
            collect(messages, message.getContent());
        }

        writer.write(messages);

        logger.info("Collector completed.");
    }

    private void collect(List<String> messages, String content) {
        List<Matcher> matchers = matcherService.match(content);

        for (Matcher matcher : matchers) {
            while (matcher.find()) {
                messages.add(matcher.group());
            }
        }
    }
}
