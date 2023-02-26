import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.DimensionUIResource;

public class NextPage extends Template implements ActionListener 
{
    JLabel label;
    JButton pack,unpack;

    public NextPage(String value1) 
    {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        label=new JLabel("Welcome:"+value1);
        Dimension size=label.getPreferredSize();
        label.setBounds(40, 50, size.width + 60, size.height);
        label.setFont(new Font("Century",Font.BOLD,17));
        label.setForeground(Color.blue);

        pack=new JButton("Pack Files");
        Dimension bsize=pack.getPreferredSize();
        pack.setBounds(100, 100,bsize.width,bsize.height);
        pack.addActionListener(this);

        unpack=new JButton("Unpack Files");
        Dimension b2size=unpack.getPreferredSize();
        unpack.setBounds(300, 100, b2size.width, b2size.height);
        unpack.addActionListener(this);

        _header.add(label); 
        _content.add(pack);
        _content.add(unpack);

        ClockHome();
        this.setSize(600,600);
        this.setResizable(false);
        this.setVisible(true);
        
    }   //End Of constructor

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            this.setVisible(false);
            System.exit(0);
        }
        if(ae.getSource() == minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if(ae.getSource() == pack)  
        {
            this.setVisible(false);
            try
            {
                MarvellousPackFront obj=new MarvellousPackFront();
            }
            catch(Exception e)
            {

            }
        }
        if(ae.getSource()==unpack)
        {
            this.setVisible(false);
            MarvellousUnpackFront obj=new MarvellousUnpackFront();
        }     
    }

}
