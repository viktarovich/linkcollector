package com.github.eugeneviktorovich.io;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Convenience class for writing messages to file.
 *
 * @author Eugene Viktorovich
 */
public class FileWriter implements Writer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Write/save messages to file.
     *
     * @param messages
     */
    @Override
    public void write(List<String> messages) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(fileName, "UTF-8");

            for (String msg : messages) {
                out.append(msg);
                out.println();
            }

            out.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            logger.error("Exception during output of messages to file: ", ex);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}
