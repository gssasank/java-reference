package test;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestExtractCommand {
    public static void main(String[] args){
        JFileChooser inputFile = new JFileChooser("./src/data");
        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = inputFile.getSelectedFile();
            try {
                Scanner scan = new Scanner(file);
                while (scan.hasNext()) {
                    String line = scan.nextLine();

//                    String command = "";
                    String command = line.split(":|,")[0];
//                    try {
//                        command = line.substring(0,line.indexOf("[:,]"));
//                    }
//                    catch (StringIndexOutOfBoundsException e){
//                        command = line;
//                    }
                    if(! command.equals(""))
                        System.out.println(command);
                }
            }
            catch (FileNotFoundException e){
                System.out.println("File not found");
            }
        }

//        String str1 = "Execute";
//        String str2 = "Add user: Mimi, funds:1000 holding: {INFY:10, TCS:5, SBI:20}";

    }
}
