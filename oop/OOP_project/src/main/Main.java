package main;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main{
    public static void main(String[] args){
        // Open input file
        JFileChooser inputFile = new JFileChooser("./src/data");

        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = inputFile.getSelectedFile();

            try {
                Scanner scan = new Scanner(file);
                // creating objects of Stock Exchange
                StockExchange nse = new StockExchange("NSE");
                StockExchange bse = new StockExchange("BSE");
                while (scan.hasNext()) {
                    String line = scan.nextLine();

                    // Extracting the command to execute from the line
                    String command = line.split(":|,")[0];

                    // ignoring empty lines
                    if(!command.equals("")){
                        // Dealing with Add commands
                        if(command.equals("Add scrip") || command.equals("Add user")){
                            String[] params = DataExtract.addRegex(line);
                            // adding data stock data
                            if (command.split(" ")[1].equals("scrip"))
                            {
                                Stock stock = new Stock(params);
                                // randomly allocate stock to NSE or BSE
                                Random rand = new Random();
                                // randomly generate 0 or 1
                                int choice = rand.nextInt(2);
                                if(choice == 0){
                                    nse.setStock(stock);
//                                    nse.getDetails();
                                }
                                else{
                                    bse.setStock(stock);
//                                    bse.getDetails();
                                }
//                                System.out.println(stock);
                            }
                        }
                    }
                }
//                nse.querySector("IT");
//                bse.querySector("IT");
            }
            catch (FileNotFoundException e){
                System.out.println("File not found");
                exit(1);
            }
        }
    }
}