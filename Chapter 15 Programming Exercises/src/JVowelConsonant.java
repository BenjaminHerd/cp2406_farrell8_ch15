/*
Used solution heavily for this one.
Distinguishes consonants from vowels as the user clicks buttons.

26 buttons for each letter, JFrame holding three panels in 2x2 grid
 */
//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class constructor, extending JFrame and implementing ActionListener for buttons
public class JVowelConsonant extends JFrame implements ActionListener{


    //Variable declaration
    Container con = null;
    final int LETTERS_AT_A_TIME = 8;
    final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H",
    "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] vowles = {"A", "E", "I", "O", "U"};

    //Layout Components
    JButton[] b = new JButton[LETTERS_AT_A_TIME];
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JLabel infoLabel = new JLabel("Nothing here yet");

    //More Variable declarations
    boolean alreadyUsed;
    int x;
    int random;
    int[] randoms = {-1, -1, -1, -1, -1, -1, -1, -1};


    //public class constructor
    public JVowelConsonant(){
        //Defaults
        super("Vowels and Consonants");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //For loop (Start at 0, while X is less than 26, +1 and do loop body once, then check value for x)
        for (x = 0; x < LETTERS_AT_A_TIME; ++x){
            //Using a math module to randomly select random letters from an array
            random = (int)(Math.random() * LETTERS.length);
            randoms[x] = random;
        }

        //Layout aspects added
        setLayout(new GridLayout(2, 2));
        p1.setLayout(new GridLayout(2, 2));
        p2.setLayout(new GridLayout(2, 2));

        //For loop
        for (x = 0; x < LETTERS_AT_A_TIME; ++x){
            //Creates a button for each letter in the alphabet
            b[x] = new JButton(LETTERS[randoms[x]]);
        }
        //For loop, while x is less than 4, add a button to the panel
        for (x = 0; x < 4; ++x){
            p1.add(b[x]);
        }
        //For loop, for the remainder of x, add number of buttons to panel 2
        for (; x < LETTERS_AT_A_TIME; ++x){
            p2.add(b[x]);

        }
        p3.add(infoLabel);
        add(p1);
        add(p2);
        add(p3);
        //For loop, for each button for each letter, add an ActionListener to catch events occurring
        for (x = 0; x < LETTERS_AT_A_TIME; ++x){
            b[x].addActionListener(this);
        }
    }

    //Override function for catching button events
    @Override
    public void actionPerformed(ActionEvent e){
        //Get source of event
        Object source = e.getSource();

        //For each of the letters in the array, if a vowel is selected,
        // vowel selected info pops up and vice versa
        for (x = 0; x < LETTERS_AT_A_TIME; ++x)
            if (source == b[x]){
                if (b[x].getText().equals("A") || b[x].getText().equals("E") || b[x].getText().equals("I")
                        || b[x].getText().equals("O") || b[x].getText().equals("U"))
                    infoLabel.setText(b[x].getText() + " is a vowel");
                else
                    infoLabel.setText(b[x].getText() + " is a consonant");
                random = (int)(Math.random() * LETTERS.length);
                b[x].setText(LETTERS[random]);
                x = LETTERS_AT_A_TIME;
            }

    }

    //Running application
    public static void main(String[] args) {
        JVowelConsonant frame = new JVowelConsonant();
        frame.setSize(600, 500);
        frame.setVisible(true);
    }

}
