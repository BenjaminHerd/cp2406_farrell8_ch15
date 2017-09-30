/*
Create a JFrame and set Layout to BorderLayout.  In each region, Place a JButton that displays the name of a
classic movie that has the region name in title.  When clicked, display movie's release date and star.
 */

//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class constructor
public class JMovieFrame extends JFrame implements ActionListener {

    //Layout components
    JButton btmButton = new JButton("South Pacific");
    JButton topButton = new JButton("North by Northwest");
    JButton leftButton = new JButton("East of Eden");
    JButton rightButton = new JButton("West Side Story");
    JButton cenButton = new JButton("Journey to the Center of the Earth");

    //Corresponding labels
    JLabel topLabel = new JLabel("  ||  1959, Cary Grant");
    JLabel btmLabel = new JLabel("  ||  1958, Mary Martin");
    JLabel rightLabel = new JLabel("  ||  1955, James Dean");
    JLabel leftLabel = new JLabel("  ||  1961, Natalie Wood");
    JLabel cenLabel = new JLabel("                                              || 1959, Pat Boone");

    //public class constructor to add components to frame
    public JMovieFrame(){
        //Defaults
        super("JMovieFrame Exercise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        //Add to frame, "North" acts as a constraint, somewhat similar to BorderLayout.NORTH
        add(topButton, "North");
        add(btmButton, "South");
        add(leftButton, "West");
        add(rightButton, "East");
        add(cenButton, "Center");

        //Add item listeners for each button
        topButton.addActionListener(this);
        btmButton.addActionListener(this);
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        cenButton.addActionListener(this);

//        setSize(600, 400);
        setVisible(true);
    }


    //Override functions to catch actions made by user
    @Override
    public void actionPerformed (ActionEvent e){
        //Determine which button is pressed (i.e. source of event)
        Object source = e.getSource();

        //If statements for different buttons
        if (source == topButton) {
            remove(topButton);
            add(topLabel, BorderLayout.NORTH);
        }
        else if (source == btmButton){
            remove(btmButton);
            add(btmLabel, BorderLayout.SOUTH);
        }

        else if (source == leftButton){
            remove(leftButton);
            add(leftLabel, BorderLayout.WEST);
        }

        else if (source == rightButton){
            remove(rightButton);
            add(rightLabel, BorderLayout.EAST);
        }

        else {
            remove(cenButton);
            add(cenLabel, BorderLayout.CENTER);
        }
        //Need to update the view as is using validation
        invalidate();
        validate();
    }

    //Running application, making frame
    public static void main(String[] args) {
        JMovieFrame frame = new JMovieFrame();
        final int WIDTH = 600;
        final int HEIGHT = 400;
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }

}
