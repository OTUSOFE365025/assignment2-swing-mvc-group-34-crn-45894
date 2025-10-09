// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import java.io.*;
import java.util.*;

public class Scanner {
    private ArrayList<String[]> productData = new ArrayList<>();
    private Random rand = new Random();

    public Scanner() {
        loadData("productData.txt");
    }

    private void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; }
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) productData.add(parts);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public String getRandomUPC() {
        if (productData.isEmpty()) return null;
        int index = rand.nextInt(productData.size());
        return productData.get(index)[0];  // Return UPC
    }
}
