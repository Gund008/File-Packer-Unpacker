//Marvellous Unpack.java

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MarvellousUnPack 
{
    FileOutputStream outstream=null;
    FileInputStream instream=null;

    public MarvellousUnPack(String src)throws Exception
    {
        unpack(src);
    }
    public void unpack(String filePath)throws Exception
    {
       try
       {
         FileInputStream inputStream=new FileInputStream(filePath);

         byte header[]=new byte[100];
         int length=0;

         byte Magic[]=new byte[12];
         inputStream.read(Magic,0,Magic.length);

         instream.read(Magic,0,Magic.length);

         String Magicstr=new String(Magic);

         if(!Magicstr.equals("Marvellous11"))
         {
            throw new InvalidFileException("Invalid packed file formate");
         }
         while((length=instream.read(header,0,100))>0)
         {
            String str=new String();
            
            String ext=str.substring(str.lastIndexOf("/"));
            ext=ext.substring(1);
            
            String[]words=ext.split("//s");
            
            String filename=words[0];
            
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
