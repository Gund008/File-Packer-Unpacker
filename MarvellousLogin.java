//MarvellousLogin.java

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import javax.swing.text.AbstractDocument.Content;

import org.w3c.dom.Text;

class MarvellousLogin extends Template implements ActionListener,Runnable
{
    JButton SUBMIT;
    JLabel label1,label2,label3,TopLabel;
    final JTextField text1,text2;

    private static int attemp=3;
     
    public MarvellousLogin()
    {
    TopLabel = new JLabel();
    TopLabel.setHorizontalAlignment(SwingConstants.CENTER);
    TopLabel.setText("Packer Unpacker:Login");
    TopLabel.setForeground(Color.red);

    Dimension topsize=TopLabel.getPreferredSize();
    TopLabel.setBounds(50,40,topsize.width+60,topsize.height+20);
    TopLabel.setFont(new Font("Century",Font.BOLD,15));
    _header.add(TopLabel);
    
    label1=new JLabel();
    label1.setToolTipText("Username");
    label1.setForeground(Color.white);

     Dimension size=label1.getPreferredSize();
   
    label1.setBounds(50,135,size.width,size.height);
    label1.setHorizontalAlignment(SwingConstants.CENTER);

     text1=new JTextField(15);
     Dimension tsize=text1.getPreferredSize();

    text1.setBounds(200,135,tsize.width,tsize.height);
    text1.setToolTipText("ENTER USERNAME");

    label2 = new JLabel();
    label2.setToolTipText("Password:");
    label2.setBounds(50,175,size.width,size.height);
    label2.setForeground(Color.white);
    label2.setHorizontalAlignment(SwingConstants.CENTER);
    
    text2 = new JPasswordField(15);
    text2.setBounds(200,175,size.width,tsize.height);
    text2.setToolTipText("ENTER PASSWORD");

    text2.addFocusListener(new FocusListener()
    {
        public void focusGained(FocusEvent e) 
        {


        }
        public void focusLost(FocusEvent e) 
        {
          label3.setText("");
        }
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            // TODO Auto-generated method stub
            
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            // TODO Auto-generated method stub
            
        }          
   });

   SUBMIT = new JButton("SUBMIT");
   SUBMIT.setHorizontalAlignment(SwingConstants.CENTER);

   Dimension ssize=SUBMIT.getPreferredSize();

   SUBMIT.setBounds(50,220,ssize.width+20,ssize.height);
   
   label3=new JLabel();
   label3.setText("");

   Dimension  l3size=label3.getPreferredSize();

   label3.setForeground(Color.RED);
   label3.setBounds(50,220,l3size.width,l3size.height);

   Thread t=new Thread(this);
   t.start();

   _content.add(label1);
   _content.add(text2);

   _content.add(label2);
   _content.add(text2);

   _content.add(label3);
   _content.add(SUBMIT);

   pack();
   validate();

   ClockHome();
   setVisible(true);
   this.setSize(500,500);
   this.setResizable(true);
   setLocationRelativeTo(null);
   SUBMIT.addActionListener(this);
}

 public  boolean validate(String Username,String password)
  {
    if((Username.length()<8) || (password.length() < 8))
    {
        return false;
    }

    else
        return true;
  }

   public void actionPerformed(ActionEvent ae)
  {
     
    String value1=text1.getText(); //username
    String value2=text2.getText();

    if(ae.getSource() == exit)
    {
        this.setVisible(false);
        System.exit(0);
    }

    if(ae.getSource() == minimize)
    {
        this.setState(Frame.ICONIFIED);
    }

    if(ae.getSource() == SUBMIT)
    {
        if(validate(value1,value2)== false)
        {
            text1.setText("");
            text2.setText("");
            JOptionPane.showMessageDialog(this, "Short Username","Marvellous Packer Unpacker",JOptionPane.ERROR_MESSAGE);   
        }

        if(value1.equals("PackingUnpacking") && value2.equals("MarvellousAdmin"))
        {
            NextPage page=new NextPage(value1);   //username send nextpage
            this.setVisible(false);
            page.pack();
            page.setVisible(true);
            page.setSize(500,500);
        }

        else
        {
            attemp--;

            if(attemp == 0)
            {
                JOptionPane.showMessageDialog(this, "Number of attemps finished","Marevllous packer unpacker",JOptionPane.ERROR_MESSAGE);
                this.dispose();
                System.exit(0);
            }
            JOptionPane.showMessageDialog(this, "Incorrect Login or password","Error!!!",JOptionPane.ERROR_MESSAGE);
        }
    }
  }

   
    public void run()
        {
            for(;;)
            {
                if(text2.isFocusOwner())
                {
                    if(Toolkit.getDefaultToolkit(). getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
                    {
                       text2.setToolTipText("Warning:CAPS LOCK is on"); 
                    }
                    else
                    {
                        text2.setToolTipText("");
                    }

                    if((text2.getText()).length()<8)
                    {
                       label3.setText("Weak Password");
                    }
                    else
                    {
                        label3.setText("");
                    }
                    
                    
                }
            }
        }

    }


    
                                
            
           
        




