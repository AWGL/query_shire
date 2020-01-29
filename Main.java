package nhs.cardiff.genetics;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 *
 */

public class Main {

    public static void main(String[] args) throws Exception {
        // Get command line arguments
        if (args.length != 1) {
            throw new IllegalArgumentException("Too many command line arguments passed. Only one worksheet at a time.");
        }
        Query shire = new Query();
        shire.queryShire(args[0]);

        // Convert results to json
        

        // Write out to file
        WriteFile writer = new WriteFile();

    }
}
