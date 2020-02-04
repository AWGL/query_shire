package nhs.cardiff.genetics;

import java.io.*;
import java.sql.ResultSet;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Main {

    public static void main(String[] args) throws Exception {
        // Bit hacky but set this to false if not testing
        boolean testing = true;

        // Get command line arguments
        if (args.length != 1) {
            throw new IllegalArgumentException("Too many command line arguments passed. Only one worksheet at a time.");
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
        ResultSet result = shire.queryShire(args[0]);

        //TODO working here
        while (result.next()){
            System.out.println(result);
        }

        // Make worksheet object
        Worksheet worksheet = new Worksheet("19M00000"); //TODO WORK HERE

        // Convert results to json
        Json jsonConvert = new Json();
        jsonConvert.json(worksheet);

        // Write out to file
        WriteFile writer = new WriteFile();

    }
}
