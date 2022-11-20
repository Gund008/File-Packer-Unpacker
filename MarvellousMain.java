//MarvellousMain.java

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MarvellousMain 
{

    public static void main(String[] args)
    {
        try
        {
          JFrame frame=new JFrame();
          MarvellousLogin mobj=new MarvellousLogin();
          frame.setVisible(true);
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
}
