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
        JOptionPane.showMessageDialog(null,"Please choose Input text file in next dialog box");
        JFileChooser inputFile = new JFileChooser("./src/data");
        inputFile.setDialogTitle("Select TXT input file");

        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = inputFile.getSelectedFile();

            try {
                Scanner scan = new Scanner(file);
                // creating objects of Stock Exchange
                StockExchange nse = new StockExchange("NSE");
                StockExchange bse = new StockExchange("BSE");
                // creating object of the Brokerage Firm
                BrokerageFirm yadavBroking = new BrokerageFirm();
                // creating order book
                OrderBook orders = new OrderBook();

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
                            // randomly allocate stock to NSE or BSE
                            Random rand = new Random();
                            // randomly generate 0 or 1
                            int choice = rand.nextInt(2);
                            if(choice == 0){
                                nse.addStock(params);
                            }
                            else{
                                bse.addStock(params);
                            }
//                            nse.queryPrice(params[1]);
//                            bse.queryPrice(params[1]);
                        }
                        // dealing with delete scrip command
                        else if(command.equals("Delete scrip")){
                            // remove stock from stock exchanges
                            // params[1] is the name of the stock
                            System.out.println("Deleted Scrip: " + params[1]);
                            nse.stockDeList(params[1]);
                            bse.stockDeList(params[1]);
                            // remove stock from broking firm costumer's profile
                            yadavBroking.deleteUserStock(params[1]);
                        }
                        // dealing with add user command
                        else if(command.equals("Add user")){
                            yadavBroking.addClient(new Trader(params));
                        }
                        // deleting user
                        else if(command.equals("Delete User")){
                            // params[1] is the name of the user
                            System.out.println("Deleted User: " + params[1]);
                            yadavBroking.deleteClient(params[1]);
                        }
                        // dealing with show sector command
                        else if (command.equals("Show sector")){
                            System.out.println("\n----- " + params[1] + " STOCKS -----");
                            // params[1] is the name of the sector
                            nse.querySector(params[1]);
                            bse.querySector(params[1]);
                        }
                        // placing orders
                        else if (command.equals("Place order")){
                            // check if user exists
                            // params[1] is tha name of the user
                            Trader t = yadavBroking.getUser(params[1]);

                            // check if stock exists
                            // param[5] is the name of stock
                            // check stock in NSE
                            StockData s = nse.getStock(params[5]);
                            // if stock not present in nse search BSE
                            if (s == null)
                                s = bse.getStock(params[5]);
                            // if user and stock exists then place order
                            if(t != null && s != null){
                                try{
                                    orders.addOrder(new Order(params,t,s));
                                }
                                catch(InValidInputException e){
//                                    System.out.println(e.getMessage());
                                }
                            }
                            if (t == null){
                                System.out.println("User: " + params[1] + " does not exist.");
                            }
                            if (s == null){
                                System.out.println("Scrip: " + params[5] + " does not exist.");
                            }
                        }
                        // showing order book
                        else if (command.equals("Show Orderbook")){
                            System.out.println("\n----- ORDER BOOK -----");
                            orders.showOrderBook();
                        }
                        // Executing orders
                        else if (command.equals("Execute")){
                            orders.executeOrders();
                            // check for pending short sell orders
                            orders.checkShortSell();
                        }
                        // showing scrips
                        else if (command.equals("Show Scrips")){
                            System.out.println("\nScrips: ");
                            nse.showScrips();
                            bse.showScrips();
                        }
                        // showing users
                        else if (command.equals("Show Users")){
                            System.out.println("\nUsers:");
                            yadavBroking.showUsers();
                        }
                        // exiting the program
                        else if (command.equals("Exit")){
                            JOptionPane.showMessageDialog(null,"Results displayed on console.\nChoose csv file in next Dialog Box");
                            System.out.println("\nThanks for using the system!");
                            SecondPart.csv();
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