package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final String TITLE = "My Second Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * SimpleGUIWithFileChooser constructor.
     * 
     */
    public SimpleGUIWithFileChooser() {
        final Controller controller = new Controller();
        final JPanel panel = new JPanel();
        final JPanel broPanel = new JPanel();
        broPanel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        final JButton broswer = new JButton("Browse...");
        final JTextField textField = new JTextField(controller.getPath());
        textField.setEditable(false);
        final JTextArea area = new JTextArea();
        panel.add(save, BorderLayout.SOUTH);
        panel.add(area, BorderLayout.CENTER);
        panel.add(broPanel, BorderLayout.NORTH);
        panel.add(save, BorderLayout.SOUTH);
        broPanel.add(textField, BorderLayout.CENTER);
        broPanel.add(broswer, BorderLayout.LINE_END);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Handlers.
         * 
         */
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnFile(area.getText());
                } catch (IOException e1) {
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });

        broswer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(textField) == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(chooser.getSelectedFile());
                    textField.setText(controller.getPath());
                } else if (chooser.showSaveDialog(textField) == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(chooser, "Please, select a file!");
                }
            }
        });
    }

    private void display() {
        /*
         * Make the frame one third the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 3, sh / 3);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen.
         */
        frame.setVisible(true);
        /*
         * To resize the frame to the minimum size prior to displaying.
         */
        frame.pack();
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
     }

}
