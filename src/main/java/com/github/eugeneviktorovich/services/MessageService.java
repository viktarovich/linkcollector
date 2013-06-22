package com.github.eugeneviktorovich.services;

import com.skype.Chat;
import com.skype.ChatMessage;
import com.skype.Skype;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 * @author Eugene Viktorovich
 */
public class MessageService {

    private static final String WINDOW_TITLE = "Даффмэн: истории запоя";

    public List<ChatMessage> getTodayChatMessages() throws Exception {

        Chat daffmanChat = getDaffmanChat();

        return filterChatMessages(daffmanChat);
    }

    private Chat getDaffmanChat() throws Exception {
        Chat daffmanChat = null;
        for (Chat chat : Skype.getAllChats()) {
            if (StringUtils.startsWith(chat.getWindowTitle(), WINDOW_TITLE)) {
                System.out.println(chat.getWindowTitle());
                daffmanChat = chat;
                break;
            }
        }

        return daffmanChat;
    }

    private List<ChatMessage> filterChatMessages(Chat chat) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();
        for (ChatMessage message : chat.getAllChatMessages()) {
            if (message.getTime().compareTo(calendar.getTime()) > 0) {
                chatMessages.add(message);
            }
        }

        return chatMessages;
    }
}
