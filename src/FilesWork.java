import javax.swing.*;
import java.io.*;

public class FilesWork
{
    private static int l = 0;
    private static int w = 0;
    private static int s = 0;
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            String filename = fileChooser.getSelectedFile().getPath();
            System.out.println(filename);

            try
            {
                BufferedReader in = new BufferedReader(new FileReader(filename));
                String str;
                while ((str = in.readLine()) != null)
                {
                    String myStr = "";
                    System.out.println(str);
                    if (str.length() != 0)
                    {
                        for (int i = 0; i < str.split(" ").length; i++)
                        {
                            if (str.split(" ")[i].length() != 0)
                            {
                                if (i != 0)
                                    myStr = myStr + " ";
                                myStr = myStr + str.split(" ")[i];
                            }
                        }
                        System.out.println(myStr);
                        s += myStr.length();
                        l += 1;
                        for (int i = 0; i < myStr.split("[ ,/_//-]+").length; i++)
                        {
                            if (myStr.split("[ ,/_//-]+")[i].length() == 1)
                            {
                                char ch = myStr.split("[ ,/_//-]+")[i].charAt(0);
                                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 1040 && ch <= 1103) || (ch >= 1110 && ch <= 1111))
                                {
                                    w += 1;
                                }
                            } else
                            {
                                w += 1;
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("Symbols = " + s);
        System.out.println("Words = " + w);
        System.out.println("Lines = " + l);
    }
}
