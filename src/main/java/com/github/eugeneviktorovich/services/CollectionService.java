package com.github.eugeneviktorovich.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Viktorovich
 */
public class CollectionService {

    public void collect(List<String> messages, String content) {
        Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            messages.add(matcher.group());
        }
    }
}
