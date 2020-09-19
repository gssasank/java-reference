import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//  java .\wordRemove_v2.java test-wordRemove2.txt Java
public class wordRemove_v2 {
    public static void main(String[] args){
        try{
            String file_name = args[0];
            String string = args[1];
            String result="";
            try{
                File file = new File(file_name);
                Scanner scan = new Scanner(file);
                while (scan.hasNext()){
                    String line = scan.nextLine();
                    line = line.replaceAll(string,"****");
                    result+=line+"\n";
                }

                PrintWriter output = new PrintWriter(file_name);
                output.println(result);

                scan.close();
                output.close();
            }
            catch(FileNotFoundException ex){
                System.out.println("File: "+file_name+", does not exist");
            }
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Please provide command line arguments -\nFirst argument is FILENAME and second argument the STRING");
        }
    }
}
