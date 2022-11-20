//MarvellousUnpackFront.java

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


class InvalidFileException extends Exception
{
  public InvalidFileException(String str)
  {
    super(str);
  }
}

public class MarvellousUnPackFront extends Template implements ActionListener 
{
      JButton SUBMIT,PREVIOUS;
      JLabel label,labl2,title;
      final JTextField text1;

      public MarvellousUnPackFront()
      {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        title=new JLabel("Unpacking Portal");
        java.awt.Dimension size=title.getPreferredSize();
        title.setBounds(40,50,size.width + 60,size.height);
        title.setFont(new Font("Centuary",Font.BOLD,17));
        title.setForeground(Color.blue);

        JLabel label1 = new JLabel();
        label1.setText("File Name");
        label.setForeground(Color.white);
        label.setBounds(350,50,size.width,size.height);

        text1=new JTextField(15);
        java.awt.Dimension tsize=text1.getPreferredSize();
        text1.setBounds(500,50,tsize.width,tsize.height);
        text1.setToolTipText("Enter name of Directory");
        
        SUBMIT=new JButton("Extract Here");
        java.awt.Dimension bsize=SUBMIT.getPreferredSize();
        SUBMIT.setBounds(350,200,bsize.width,bsize.height);
        SUBMIT.addActionListener((ActionListener) this);

        _header.add(title);
        _content.add(label1);
        _content.add(text1);
        _content.add(SUBMIT);
        _content.add(PREVIOUS);

        this.setSize(1000,400);
        this.setResizable(false);
        this.setVisible(true);
        text1.requestFocusInWindow();
    }
    public void  actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            this.setVisible(false);
            System.exit(0);
        }
        if(ae.getSource()==minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if(ae.getSource()==SUBMIT)
        {
            try
            {
                MarvellousUnPack obj=new MarvellousUnPack(text1.getText());
                this.dispose();
                NextPage t=new NextPage("admin");
            }
            catch(Exception e)
            {

            }
        }
        if(ae.getSource()==PREVIOUS)
        {
            this.setVisible(false);
            this.dispose();
            NextPage t=new NextPage("admin");
        }
    }
}
        



