/*
Create JFrame holding 5 buttons with names of five different fonts.
Include a sixth button to increase/decrease size of font.
Use demo label to display effects on font.
 */

//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class constructor
public class JFontSelector extends JFrame implements ActionListener {

    //Variable declaration
    final int SMALL = 12;
    final int LARGE = 24;
    int size = SMALL;
    boolean isSmaller = true;

    //layout components
    FlowLayout flow = new FlowLayout();

    JButton font1Btn = new JButton("Arial");
    JButton font2Btn = new JButton("Calibri");
    JButton font3Btn = new JButton("Times New Roman");
    JButton font4Btn = new JButton("Cambria");
    JButton font5Btn = new JButton("Comic Sans");
    JButton font6Btn = new JButton("Font Size Change");

    //Set Fonts
    Font aFont = new Font("Arial", Font.PLAIN, size);
    Font calFont = new Font("Calibri", Font.PLAIN, size);
    Font tFont = new Font("TimesRoman", Font.PLAIN, size);
    Font camFont = new Font("Cambria", Font.PLAIN, size);
    Font coFont = new Font("ComicSans", Font.PLAIN, size);
    Font myFont = aFont;  //Initialised here

    JLabel displayLabel = new JLabel("A bunch of text that's changing!");

    //public class constructor
    public JFontSelector(){
        //Defaults
        super("Font selection and alteration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Layout aspects
        setLayout(flow);
        add(font1Btn);
        add(font2Btn);
        add(font3Btn);
        add(font4Btn);
        add(font5Btn);
        add(font6Btn);

        //Add the label and the font variable to that label that can be changed later
        add(displayLabel);
        displayLabel.setFont(aFont);

        //Event listeners for actions on buttons
        font1Btn.addActionListener(this);
        font2Btn.addActionListener(this);
        font3Btn.addActionListener(this);
        font4Btn.addActionListener(this);
        font5Btn.addActionListener(this);
        font6Btn.addActionListener(this);
    }

    //Override function for events
    @Override
    public void actionPerformed(ActionEvent e){
        //Check source of action
        Object source = e.getSource();

        //Check which button was pressed, and what to do with font
        if (source == font1Btn)
            myFont = aFont;

        else if (source == font2Btn)
            myFont = calFont;

        else if (source == font3Btn)
            myFont = tFont;

        else if (source == font4Btn)
            myFont = camFont;

        else if (source == font5Btn)
            myFont = coFont;

        //If size button pressed initially, change size to Big, secondly, changed to small
        else if (source == font6Btn){
            if (isSmaller){
                myFont = myFont.deriveFont(Font.PLAIN, LARGE);
                isSmaller = false;
            }
            else {
                myFont = myFont.deriveFont(Font.PLAIN, SMALL);
                isSmaller = true;
            }
        }
        displayLabel.setFont(myFont);

    }

    //Running application for frame
    public static void main(String[] args) {
        JFontSelector frame = new JFontSelector();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }


}
