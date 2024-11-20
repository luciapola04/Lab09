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
        if (this.currentString == null) {
            throw new IllegalStateException("The string to be printed cannot be null!");
        }
        this.list.add(this.currentString);
        System.out.println("CURRENT STRING: " + this.currentString); //NOPMD: exercises requires it
    }
}
