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
                // creating object of the Brokerage Firm
                BrokerageFirm yadavBroking = new BrokerageFirm();

                while (scan.hasNext()) {
                    String line = scan.nextLine();

                    // Extracting the command to execute from the line
                    String command = line.split("[:,]")[0];

                    // ignoring empty lines
                    if(!command.equals("")){
                        // extracting parameters from the line using regular expressions
                        String[] params = DataExtract.paramsRegex(line);
                        // sample params: {"scrip","M&M","sector","auto","O","610","H","610","L","610","C","610"}
                        // sample params: {"user","Mimi","funds","1000","INFY","10","TCS","5","SBI","20"}

                        // Dealing with Add scrip command
                        if(command.equals("Add scrip")){
                            // adding data stock data
                            Stock stock = new Stock(params);
                            // randomly allocate stock to NSE or BSE
                            Random rand = new Random();
                            // randomly generate 0 or 1
                            int choice = rand.nextInt(2);
                            if(choice == 0){
                                nse.addStock(stock);
//                               nse.getDetails();
                            }
                            else{
                                bse.addStock(stock);
//                                bse.getDetails();
                            }
//                            System.out.println(stock);
                        }
                        // dealing with delete scrip command
                        else if(command.equals("Delete scrip")){
                            nse.stockDeList(params[1]);
                            bse.stockDeList(params[1]);
                        }
                        // dealing with add user command
                        else if(command.equals("Add user")){
                            Trader user = new Trader(params);
                            yadavBroking.addClient(user);
                        }
                        // deleting user
                        else if(command.equals("Delete User")){
                            yadavBroking.deleteClient(params[1]);
                        }
                        // dealing with show sector command
                        else if (command.equals("Show sector")){
                            nse.querySector(params[1]);
                            bse.querySector(params[1]);
                        }
                        // exiting the program
                        else if (command.equals("Exit")){
                            System.out.println("Thanks for using the system!");
                            exit(0);
                        }
                    }
                }
            }
            catch (FileNotFoundException e){
                System.out.println("File not found");
                exit(1);
            }
        }
    }
}