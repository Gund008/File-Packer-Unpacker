//Template.java

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.time.Clock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


 class ClockLabel extends JLabel implements  ActionListener
{
    String type;
    SimpleDateFormate sdf;

    public ClockLabel(String type) 
    {
        this.type=type;
        setForeground(Color.green);
    
        switch (type) 
        {
            case "date":
               sdf=new SimpleDateFormate(" MMMM dd yyyy");
               setFont(new Font("sans-serif",Font.PLAIN,12));
               setHorizontalAlignment(SwingConstants.LEFT);
               break;
            
            case "time":
               sdf=new SimpleDateFormate("hh:mm:ss a");
               setFont(new Font("sans-serif",Font.PLAIN,40));
               setHorizontalAlignment(SwingConstants.CENTER);
               break;

             case "day":
               sdf=new SimpleDateFormate("EEEE");
               setFont(new Font("sans-serif",Font.PLAIN,16));
               setHorizontalAlignment(SwingConstants.RIGHT);
               break;
        
             default:
                sdf=new SimpleDateFormate();
                break;
        }
            Timer t=new Timer(1000,this);
            t.start();
    }

           public void actionPerformed(ActionEvent ae)
           {
            Date d=new Date();
            setText(sdf.formate(d));
           }  
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class Template extends JFrame implements Serializable,ActionListener{
  
    private static final Insets BOTH = null;
    JPanel _header;
    JPanel _content;
    JPanel _top;

    ClockLabel datLabel;
    ClockLabel timLabel;
    ClockLabel dayLabel;

    JButton minimize,exit;

    public Template()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        GridBagLayout grid=new GridBagLayout();
        setLayout(null);

        _top=new JPanel();
        _top.setBackground(Color.LIGHT_GRAY);
        _top.setLayout(null);

        getContentPane().add(_top,new GridBagConstraints(0,0,1,1,1,5,GridBagConstraints.BASELINE,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

        _header=new JPanel();
        _header.setBackground(Color.white);
        _header.setLayout(null);

        getContentPane().add(_header,new GridBagConstraints(0,0,1,1,1,20,GridBagConstraints.BASELINE,GridBagConstraints,BOTH,new Insets(0,0,0,0),0,0));
      
       
        _content=new JPanel();
        _content.setLayout(null);
        _content.setBackground(new Color(0,50,120));
        JScrollPane jsp=new JScrollPane(_content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        getContentPane().add(jsp,new GridBagConstraints(0,2,1,1,1,75,GridBagConstraints.BASELINE,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

        setTitle("\\File Packer-Unpacker\\");

        Clock();
        CloseAndMin();
          
    }

   
    void CloseAndMin() 
     {
        minimize=new JButton("-");
        minimize.setBackground(Color.LIGHT_GRAY);
        minimize.setBounds(MAXIMIZED_HORIZ,0,45,20);

        exit=new JButton("X");
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setBackground(Color.LIGHT_GRAY);
        exit.setHorizontalTextPosition(0);
        exit.setBounds(MAXIMIZED_HORIZ+45,0,45,20);
        
        _top.add(minimize);
        _top.add(exit);

        exit.addActionListener((java.awt.event.ActionListener) this);
        minimize.addActionListener((java.awt.event.ActionListener) this);

     }

       public void actionPerformed( ActionEvent ae) 
       {
         if(ae.getSource()==exit);
         {
          this.setVisible(false);
          System.exit(0);
         }

       if(ae.getSource()==minimize)
       {
        setState(JFrame.ICONIFIED);
       }
    }

    void Clock()
    {
        ClockLabel dateLable = new ClockLabel("date");
        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dayLable = new ClockLabel("day");

        dateLable.setForeground(Color.blue);
        timeLable.setForeground(Color.blue);
        dayLable.setForeground(Color.blue);

        dayLable.setFont(new Font("Century",Font.BOLD,15));
        dayLable.setBounds(700,10,200,100);

        dateLable.setFont(new Font("Century",Font.BOLD,15));
        dayLable.setBounds(800,-40,200,100);

        timeLable.setFont(new Font("Century",Font.BOLD,15));
        timeLable.setBounds(760,-15,200,100);

        _header.add(dateLable);
        _header.add(timeLable);
        _header.add(dayLable);

    }

    void ClockHome()
    {
        
        ClockLabel dateLable = new ClockLabel("date");
        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dayLable = new ClockLabel("day");

        dateLable.setForeground(Color.blue);
        timeLable.setForeground(Color.blue);
        dayLable.setForeground(Color.blue);

        dayLable.setFont(new Font("Century",Font.BOLD,15));
        dayLable.setBounds(200,20,200,100);

        dateLable.setFont(new Font("Century",Font.BOLD,15));
        dayLable.setBounds(300,-40,200,100);

        timeLable.setFont(new Font("Century",Font.BOLD,15));
        timeLable.setBounds(260,-10,200,100);

        _header.add(dateLable);
        _header.add(timeLable);
        _header.add(dayLable);

    }

}
