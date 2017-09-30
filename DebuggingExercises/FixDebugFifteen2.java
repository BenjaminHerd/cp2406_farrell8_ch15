// Demonstrates layout positions
// using BorderLayout

//import statements
import javax.swing.*;
import java.awt.*;


//extension off of class
public class FixDebugFifteen2 extends JFrame
{
    //Layout components (nb = north button [up], etc.)
   JButton nb = new JButton("Up    ");
   JButton sb = new JButton("Down  ");
   JButton eb = new JButton("Right ");
   JButton wb = new JButton("Left  ");
   JButton cb = new JButton("Center");
   Container con = null;

   public FixDebugFifteen2()
   {
       //Layout aspects
       super("Debug exercise 2");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Set container for use
       con = this.getContentPane();
       //Layout specify
       con.setLayout(new BorderLayout());
       //Set each part of the container with corresponding buttons
       con.add(nb, BorderLayout.NORTH);
       con.add(sb, BorderLayout.SOUTH);
       con.add(eb, BorderLayout.EAST);
       con.add(wb, BorderLayout.WEST);
       con.add(cb, BorderLayout.CENTER);
   }
   public static void main(String[] args)
   {
      FixDebugFifteen2 f = new FixDebugFifteen2();
      f.setSize(300, 300);
      f.setVisible(true);
   }
}