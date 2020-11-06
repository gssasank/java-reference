package main;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SecondPart {
    public static void csv() throws FileNotFoundException {
        // Hashmap to store data
        HashMap<String, ArrayList<Double>> data = new HashMap<>();
        double sumClosePrice = 0.0;
        int noOfDays = 0;

        // initialising hashmap with empty array lists
        data.put("prev", new ArrayList<>());
        data.put("open", new ArrayList<>());
        data.put("high", new ArrayList<>());
        data.put("low", new ArrayList<>());
        data.put("last", new ArrayList<>());
        data.put("close", new ArrayList<>());

        // Open input file
        JFileChooser inputFile = new JFileChooser("./src/data");
        inputFile.setDialogTitle("Select the CSV File");

        if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = inputFile.getSelectedFile();
            Scanner scan = new Scanner(file);
            // we need to ignore the Header of csv
            String line = scan.nextLine();
            while(scan.hasNext()){
                line = scan.nextLine();
                String[] values = line.split(",");
                // sample values: [INFY, 4-May-20, 715.5, 689.8, 701.2, 670.35, 675.15, 673.7]

                // storing data in the Hashmap
                data.get("prev").add(Double.parseDouble(values[2]));
                data.get("open").add(Double.parseDouble(values[3]));
                data.get("high").add(Double.parseDouble(values[4]));
                data.get("low").add(Double.parseDouble(values[5]));
                data.get("last").add(Double.parseDouble(values[6]));
                data.get("close").add(Double.parseDouble(values[7]));

                sumClosePrice += Double.parseDouble(values[7]);
                noOfDays++;
            }
            // calculating average
            double average = sumClosePrice/noOfDays;
            System.out.println("\nAverage price of Stock is: " + average);

            // calculating maxDrawDown
            double maxDrawDown = 0.0;
            // taking first point as peak
            double peak = data.get("close").get(0);
            // as we need to consider close price only
            ArrayList<Double> price = data.get("close");

            for(int i = 1; i < noOfDays; i++){
                // we have assumed first point to be peak
                // case1 - graph is going down from the first point
                // in this case we need to find the bottom
                if(price.get(i) < price.get((i-1))){
                    continue;
                }
                // case2 - graph is going up from the first point
                // in this case we will find the new peak
                else if(price.get(i) > price.get((i-1))){
                    double tmp = peak - price.get(i-1);
                    if( tmp>maxDrawDown ){
                        maxDrawDown = tmp;
                    }
                    peak = price.get(i);
                }
            }

            System.out.println("Max Draw-down: " + maxDrawDown);

            // calculating max return potential
            double maxReturnPotential = 0.0;
            double dayOneOpenPrice = data.get("open").get(0);
            for(int i = 0; i < noOfDays ; i++){
                maxReturnPotential += Math.abs(data.get("open").get(i) - data.get("close").get(i));
            }
            // calculating max percentage return potential
            double maxPercentageReturnPotential = 100 * (maxReturnPotential / dayOneOpenPrice);
            System.out.println("Max Return Potential: " + maxReturnPotential);
            System.out.println("Max Percentage Return Potential: " + maxPercentageReturnPotential + "%");
        }
    }
}