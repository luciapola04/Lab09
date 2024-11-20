package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String currentString;
    private final List<String> list;

    /**
     * SimpleController constructor.
     */
    public SimpleController() {
        this.currentString = null;
        this.list = new ArrayList<>();
    }

    @Override
    public void setNextString(final String nextString) {
        if (nextString.isEmpty()) {
            throw new NullPointerException(nextString + " cannot be null!"); //NOPMD: exercises requires it
        }
        this.currentString = nextString;
    }

    @Override
    public String getNextString() {
        return this.currentString;
    }

    @Override
    public List<String> getStringsHistory() {
        return Collections.unmodifiableList(this.list); // Prevents modification of the returned list
    }

    @Override
    public void printCurrentString() {
        this.list.add(this.currentString);
        System.out.println("CURRENT STRING: " + this.currentString); //NOPMD: exercises requires it
    }
}
