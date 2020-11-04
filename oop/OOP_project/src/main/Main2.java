package main;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        // Open input file
        JFileChooser inputFile = new JFileChooser("./src/data");

        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = inputFile.getSelectedFile();
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String line = scan.nextLine();
                System.out.println(line);
            }
        }
    }
}