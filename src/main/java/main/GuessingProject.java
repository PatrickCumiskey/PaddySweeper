

/*
 * GameGUIFrame is a class which templates an outline GUI for the 
 * guessing game. It inclueds the frame construction and an example main method 
 * that creates the frame.
 *
 * Consider alternative layouts to FlowLayout, and enhance as necessary e.g. 
 * add a button to start a new game.
 *
 * @author Aoife O'Driscoll 18238297
 * @version 19 March 2019
 */
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 * Generate the Game GUI Frame and populate with the GUI components
 */
public class GuessingProject extends JFrame {

    /**
     * Constructor will build the GUI frame
     */
    private JTextField textField1;
    int numberGuesses = 1;
    int maxGuesses = 10;
    String error = "Guess must be a number between 100 and 999";
    Random randomNumber = new Random();
    int answer = randomNumber.nextInt(900) + 100;
    String guessString = null;
    //private JButton plainJButton;

    public GuessingProject() {
        super("Aoife's Guessing Game ");
        setLayout(new FlowLayout()); // should reconsider this!
        
        //JButton plainButton = new JButton("New Game");
        //add (plainButton);
        //ButtonHandler handler = new ButtonHandler();
        //plainJButton.addActionListener(handler);

        // Create the components
        JLabel titleLabel = new JLabel("This is a guessing game");

        JTextArea descriptionTA = new JTextArea(4, 16);
        descriptionTA.setEditable(false);
        //descriptionTA.append("1. Explanation \n2. A\n3. guessing \n4. game");
        descriptionTA.append("Guess a number between 100 and 999");

        JLabel guessLabel = new JLabel("Enter guess");
        JLabel statusLabel = new JLabel("Guess number"+ numberGuesses);

        JTextField guessTF = new JTextField(6);
        guessTF.addActionListener(new GuessTextFieldHandler());

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonHandler());

        // Add the components to frame
        add(titleLabel);
        add(descriptionTA);
        add(guessLabel);
        add(guessTF);
        add(statusLabel);
        add(exitButton);
    }

    /**
     * ActionListener called when user enters a guess in the guess text field
     */
    // Implemented using a private inner class for event handling 
    private class GuessTextFieldHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            // Replace below with all your code to handle the guesses

            String string = String.format("Guess entered was : %s",
                    event.getActionCommand());
            JOptionPane.showMessageDialog(null, string);

            //Random randomNumber = new Random();
            //int answer = randomNumber.nextInt(900) + 100;
            //String gameInstructions = String.format("Guess number between 100 and 999");
            //JOptionPane.showMessageDialog(null, gameInstructions);
            //int numberGuesses = 1;
            //int maxGuesses = 10;
            //String error;
            //error = "Guess must be a number between 100 and 999";
            do {

                try {
                    String guessString = null;
                    guessString = JOptionPane.showInputDialog("Guess number " + numberGuesses);
                    int guess = Integer.parseInt(guessString);

                    if (guess < 100 || guess > 999) {
                        JOptionPane.showMessageDialog(null, "Guess is out of range . Try again");
                    }

                    if (guess >= 100 && guess < answer) {
                        JOptionPane.showMessageDialog(null, "Guess is too low");
                    }

                    if (guess <= 999 && guess > answer) {
                        JOptionPane.showMessageDialog(null, "Guess is too high");
                    }

                    if (guess == answer) {
                        JOptionPane.showMessageDialog(null, "You won!");
                        break;
                    }

                } catch (NumberFormatException nfe) {

                    JOptionPane.showMessageDialog(null, error);

                }

                numberGuesses++;

                if (numberGuesses > maxGuesses) {
                    JOptionPane.showMessageDialog(null, "You lose! The right answer was " + answer);
                }
            } while (numberGuesses <= maxGuesses);

        } // end method actionPerformed

    } // end private inner class GuessTextFieldHandler

    /**
     * ActionListener for exit button
     */
    private class ExitButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        } // end method actionPerformed

    } // end private inner class GuessTextFieldHandler

    /**
     * ActionListener for new game button?
     */
    
    //private class NewGameButtonHandler implements ActionListener {

        //public void actionPerformed(ActionEvent event) {
            //System.exit(0);
       // }
        
   // }  
    /**
     * Create the game frame and display it.
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        GuessingProject guessFrame = new GuessingProject();
        guessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessFrame.setSize(300, 375); // set frame size
        guessFrame.setVisible(true); // display frame

    }
}


