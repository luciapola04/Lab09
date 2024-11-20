package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced.
     * 
     * @param nextString 
     */
    void setNextString(String nextString);
    /**
     * A method for getting the next string to print.
     * @return the next string to print
     */
    String getNextString();
    /**
     * @return a List of the printed strings.
     */
    List<String> getStringsHistory();
    /**
     * A method that prints the current string.
     * If the current string is unset, an @exception `IllegalStateException` should be thrown.
     */
    void printCurrentString();
}
