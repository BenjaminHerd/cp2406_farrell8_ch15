/*
JFrame using BorderLayout
Place JButton in center.
Each time clicked, change colour in in one of the other regions
(first = WEST to GREEN, second = EAST to BLUE, etc.)
 */

//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main Class constructor
public class JColorFrame extends JFrame implements ActionListener {

    //Variable Declarations
    int clickCounter = 0;

    //Layout Components
    Container con = null;

    JButton button = new JButton("Click here");

    JPanel ntRegion = new JPanel();
    JPanel stRegion = new JPanel();
    JPanel etRegion = new JPanel();
    JPanel wtRegion = new JPanel();

    //Public class constructor
    public JColorFrame(){
        //defaults
        super("Colour Framing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Aspects
        con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(button, BorderLayout.CENTER);

        con.add(ntRegion, BorderLayout.NORTH);
        con.add(stRegion, BorderLayout.SOUTH);
        con.add(etRegion, BorderLayout.EAST);
        con.add(wtRegion, BorderLayout.WEST);

        //Event listeners
        button.addActionListener(this);

    }

    //Override functions for events
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        //if statements for number of clicks to change which region
        if (source == button){
            ++clickCounter;

            if (clickCounter == 1)
                ntRegion.setBackground(Color.GREEN);

            else if (clickCounter == 2)
                etRegion.setBackground(Color.BLUE);

            else if (clickCounter == 3)
                stRegion.setBackground(Color.ORANGE);

            else if (clickCounter == 4)
                wtRegion.setBackground(Color.YELLOW);
        }
    }

    //Running application
    public static void main(String[] args) {
        JColorFrame frame = new JColorFrame();
        frame.setSize(650, 650);
        frame.setVisible(true);
    }

}
