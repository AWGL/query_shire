package nhs.cardiff.genetics;

import java.sql.ResultSet;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Main {

        //private String db = "M:\\Pyrosequencing\\Pyrosequencing Service\\PCR & PYRO spreadsheets\\Log\\IT\\SHIRE COPY FOR PYRO.MDB";
        //private String url = ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + db);

    public static void main(String[] args) throws Exception {
        // Get command line arguments
        if (args.length != 1) {
            throw new IllegalArgumentException("Too many command line arguments passed. Only one worksheet at a time.");
        }
        /*
        Query shire = new Query("M:\\Pyrosequencing\\Pyrosequencing Service\\PCR & PYRO spreadsheets\\" +
                "Log\\IT\\SHIRE COPY FOR PYRO.MDB",
                "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=");
         */
        Query shire = new Query("C:\\Users\\saram\\IdeaProjects\\query_shire\\Testing.accdb", //TODO TMP
                "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=");
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
