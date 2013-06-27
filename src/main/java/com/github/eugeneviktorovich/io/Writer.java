package com.github.eugeneviktorovich.io;

import java.util.List;

/**
 * Abstract representation for writing to any storage.
 *
 * @author Eugene Viktorovich
 */
public interface Writer {

    /**
     * Write/save messages to any storage.
     *
     * @param messages
     */
    void write(List<String> messages);
}
