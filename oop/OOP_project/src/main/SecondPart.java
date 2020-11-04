package main;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SecondPart {
    public static void csv() throws FileNotFoundException {
        // Open input file
        JFileChooser inputFile = new JFileChooser("./src/data");
        inputFile.setDialogTitle("Select the CSV File");

        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = inputFile.getSelectedFile();
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String line = scan.nextLine();
                System.out.println(Arrays.toString(line.split(",")));
            }
        }
    }
}