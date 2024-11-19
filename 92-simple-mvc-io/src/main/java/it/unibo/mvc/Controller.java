package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home") + File.separator + "output.txt";
    private File currentFile;

    /**
     * Controller constructor.
     */
    public Controller() {
        this.currentFile = new File(PATH);
    }

    /**
     * It sets the file passed as parameter as the current file.
     * @param inputFile
     */
    public void setFile(final File inputFile) {
        this.currentFile = inputFile;
    }

    /**
     * @return the current file.
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * @return the current file's path.
     */
    public String getPath() {
        return this.currentFile.getPath();
    }

    /**
     * It writes the string passed as parameter on the current file.
     * @param inputString
     */
    public void writeOnFile(final String inputString) throws IOException {
        try (PrintStream p = new PrintStream(this.getPath(), StandardCharsets.UTF_8)) {
            p.print(inputString);
        } catch (IOException e) {
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
