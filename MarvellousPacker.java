import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//MarvellousPacker

public class MarvellousPacker
{
    FileOutputStream outstream=null;

    String ValidExt[]={".txt",".c",".java",".cpp"};
    
    public MarvellousPacker(String src, String Dest) throws IOException
    {
        super();  //
        String Magic="Marvellous11";

        byte arr[]=Magic.getBytes();   //string convert byte array

        File outfile=new File(Dest);

        File inFile=null;
        outstream=new FileOutputStream(Dest);   //Instance Varibale Intialised in Construcotor
        
        outstream.write(arr,0,arr.length);

        File folder=new File(src);

        System.setProperty("user.dir", src);

        listAllFiles(src);   //Method declaration

    }//End of Constructor

    //method defination
    public void listAllFiles(String path)
    {
        try
        (Stream < Path > paths=Files.walk(Paths.get(path)))
        {
            paths.forEach(filePath->
            {
                if(Files.isRegularFile(filePath))
                {
                    try
                    {
                        String name=filePath.getFileName().toString();
                        String ext=name.substring(name.lastIndexOf("."));

                        List<String>list=Arrays.asList(ValidExt);

                        if(list.contains(ext))
                        {
                            File file=new File(filePath.getFileName().toString());

                            Pack(file.getAbsolutePath());
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
            });
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public void Pack(String filePath)
    {
        FileInputStream instream=null;

        try
        {
            byte[] buffer=new byte[1024];

            int length;

            byte temp[]=new byte[100];

            File fobj=new File (filePath);

            String Header=filePath+" "+fobj.length();

            for(int i=Header.length();i<100;i++)
            {
                Header+=" ";    //Header=Header +i;
            }
            temp=Header.getBytes();

            instream=new FileInputStream(filePath);   //initialised instance variable

            outstream.write(temp,0,temp.length);

            while((length=instream.read(buffer)) > 0)
            {
                outstream.write(buffer,0,length);
            }
            instream.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
