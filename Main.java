package nhs.cardiff.genetics;

import java.io.*;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Main {

    public static void main(String[] args) throws Exception {
        // Command line argument parsing (bit hacky, but want to have as few dependencies as possible)
        boolean testing = false;
        boolean writeFile = false;
        File outputFile = new File("output.json");

        if (args.length < 1) {
            throw new Exception("A minimum of one command line argument is required. Please see documentation " +
                    "or readme file for details of command line arguments. ");
        } else if (args.length == 1) {
            // Default options- not testing and print to stream
            testing = false;
            writeFile = false;

        } else if (args.length == 2) {
            // Testing or not testing
            try {
                testing = Boolean.parseBoolean(args[1]);
            } catch (Exception e) {
                throw new Exception("Second commandline argument could not be interpreted as either true or false. " +
                        "Please see documentation or readme file for details of command line arguments. " + e);
            }
            writeFile = false;

        } else if (args.length == 3) {
            // Testing or not testing and write out to file
            try {
                testing = Boolean.parseBoolean(args[1]);
            } catch (Exception e) {
                throw new Exception("Second commandline argument could not be interpreted as either true or false. " +
                        "Please see documentation or readme file for details of command line arguments. " + e);
            }
            writeFile = true;
            try {
                outputFile = new File(args[2]);
            } catch (Exception e) {
                throw new Exception("Third commandline argument could not be interpreted as a file name. " +
                        "Please see documentation or readme file for details of command line arguments. " + e);
            }

        } else {
            throw new IllegalArgumentException("More than three command line arguments cannot be interpreted. " +
                    "Please see documentation or readme file for details of command line arguments.");
        }

        // Get worksheet id
        String worksheetId = null;
        try {
            worksheetId = args[0];
        } catch (Exception e) {
            throw new Exception("Worksheet ID could not be identified from command line argument. " + e);
        }

        // Get database and driver
        Database databaseObject = new Database();

        if (testing) {
            // Update database values to match test database location
            File f = new File("Testing.accdb");
            String databaseLoc = f.getAbsolutePath();
            databaseObject.setDb(databaseLoc);
        }
        String db = databaseObject.getDb();

        // Query the database
        Query shire = new Query(db, databaseObject.getUrl());
        Worksheet worksheet = shire.queryShire(worksheetId, testing);

        //Check for empty results set
        if (worksheet.getSamples().isEmpty()) {
            throw new Exception("No data was retrieved from Shire for Worksheet " + worksheetId);
        }

        // Convert results to json and write out to file
        Json jsonConvert = new Json();
        jsonConvert.json(worksheet);
        if (writeFile) {
            jsonConvert.writeJsonFile(outputFile);
        } else {
            jsonConvert.writeJsonStream(System.out);
        }
    }
}
