import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import java.util.Scanner;

public class fileIO {
    public static void main(String[] args) throws Exception{
        JFileChooser inputFile = new JFileChooser("../Lab5");

        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = inputFile.getSelectedFile();
            removeComments(file);
        }
    }

    static void removeComments(File file) throws Exception { // used to remove single line comments from a java file
        Scanner scan = new Scanner(file);

        String output_name = file.getName();
        int dot = output_name.lastIndexOf(".");
        output_name = output_name.substring(0, dot)+"_modified"+output_name.substring(dot,output_name.length());
        // i could have simply used "modified_filename.extention" but i wanted to try something new 

        PrintWriter output = new PrintWriter(output_name);
        while(scan.hasNext()) {
            String line = scan.nextLine();
            if(! line.startsWith("//")){
                output.println(line);
            }
        }
        output.close();
        scan.close();
    }
}
