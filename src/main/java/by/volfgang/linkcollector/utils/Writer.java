package by.volfgang.linkcollector.utils;

/**
 * @author Eugene Viktorovich
 */
public interface Writer {

    void write(String msg);

    void append(String msg);

    void flush();

    void close();
}
