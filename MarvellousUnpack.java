import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;


public class MarvellousUnpack 
{
    FileOutputStream outputStream=null;

    public MarvellousUnpack(String src) throws Exception 
    {
        super(); 
        unpack(src);  //method intilization
    }

    public void unpack(String filePath)throws Exception
    {
        try
        {
            //Scanner sobj=new Scanner(System.in);
            //String PackFile=sobj.nextLine();

            //File fpackobj=new File(PackFile);

            FileInputStream instream=new FileInputStream(filePath);

            byte header[]=new byte[100];
            int length=0;

            byte  Magic[]=new byte[12];
            instream.read(Magic,0,Magic.length);

            String Magicstr=new String(Magic);

            if(!Magicstr.equals("Marvellous11"))
            {
                throw new InvalidFileException("Invalid packed file formate");
            }
            while((length=instream.read(header,0,100)) > 0)
            {
                String str=new String(header);

                String ext=str.substring(str.lastIndexOf(str.lastIndexOf("/")));
                ext=ext.substring(1);

                String words[]=ext.split("\\s");
    
                File obj=new File(words[0]);
                obj.createNewFile();
                System.out.println("new file dropped with name: "+words[0]);

                int size=Integer.parseInt(words[1]);

                byte arr[]=new byte[size];

                instream.read(arr,0,size);

                FileOutputStream fout=new FileOutputStream(filename);
                fout.write(arr,0,size);
            }
        }
        catch(InvalidFileException obj)
        {
            throw new InvalidFileException("Invalid packed file formate");
        }
        catch(Exception e)
        {

        }
    }
    

}
