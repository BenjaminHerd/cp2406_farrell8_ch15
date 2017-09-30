// Lets user type keys
// Displays each key typed

//import statements
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//Main class constructor, listening for keyboard entry
public class FixDebugFifteen3 extends JFrame implements KeyListener
{
    //variable declaration
   char key;
   //Layout components
   Container con = null;
   GridLayout grid = new GridLayout(2, 1);
   JLabel label = new JLabel("Key Typed:");
   JTextArea textArea = new JTextArea(4, 25);


   public FixDebugFifteen3()
   {
      setTitle("Debug Key Frame");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Need to get the container pane first
       con = this.getContentPane();

       //Add to container
      con.setLayout(grid);
      con.add(textArea);
      con.add(label);
      addKeyListener(this);
      textArea.addKeyListener(this);
   }

   //Need override functions to catch events of keyTyped, keyPressed and keyReleased
   @Override
   public void keyTyped(KeyEvent e)
   {
      char c = e.getKeyChar();
      label.setText ("Key Typed: " + c);
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
   }

   @Override
   public void keyPressed(KeyEvent e){

   }

   //Running application
   public static void main(String[] args)
   {
      FixDebugFifteen3 kFrame = new FixDebugFifteen3();
      kFrame.setSize(300, 200);
      kFrame.setVisible(true);
   }
}


