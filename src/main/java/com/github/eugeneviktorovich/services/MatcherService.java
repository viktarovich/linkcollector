package com.github.eugeneviktorovich.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Match the given input string against pattern.
 *
 * @author Eugene Viktorovich
 */
public class MatcherService {

    private static final String PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    /**
     * Match the given input string.
     *
     * @param content The string to be matched
     */
    public List<Matcher> match(String content) {
        Pattern pattern = Pattern.compile(PATTERN);

        List<Matcher> matchers = new ArrayList<>();
        matchers.add(pattern.matcher(content));

        return matchers;
    }
}
