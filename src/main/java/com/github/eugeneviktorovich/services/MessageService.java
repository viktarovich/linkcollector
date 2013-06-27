package com.github.eugeneviktorovich.services;

import com.skype.Chat;
import com.skype.ChatMessage;
import com.skype.Skype;
import com.skype.SkypeException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Return chat messages during a certain period of time.
 *
 * @author Eugene Viktorovich
 */
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String windowTitle;

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    /**
     * Returns today chat messages.
     *
     * @return today chat messages
     */
    public List<ChatMessage> getTodayChatMessages() {
        List<ChatMessage> chatMessages = new ArrayList<>();

        Chat chat = getChat();

        if (logger.isDebugEnabled()) {
            logger.debug("Found chat: " + chat);
        }

        if (chat != null) {
            if (logger.isDebugEnabled()) {
                logger.debug("Found chat: " + chat);
            }

            filterChatMessages(chatMessages, chat);
        } else {
            logger.warn("Chat not found!");
        }

        return chatMessages;
    }

    private Chat getChat() {
        Chat foundChat = null;

        try {
            for (Chat chat : Skype.getAllChats()) {
                if (StringUtils.startsWith(chat.getWindowTitle(), windowTitle)) {
                    foundChat = chat;
                    break;
                }
            }
        } catch (SkypeException ex) {
            logger.error("A problem with the connection or state at the Skype client: ", ex);
        }

        return foundChat;
    }

    private void filterChatMessages(List<ChatMessage> chatMessages, Chat chat) {
        try {
            for (ChatMessage message : chat.getAllChatMessages()) {
                if (getStartToday().compareTo(message.getTime()) < 0) {
                    chatMessages.add(message);
                }
            }
        } catch (SkypeException ex) {
            logger.error("A problem with the connection or state at the Skype client: ", ex);
        }
    }

    private Date getStartToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
