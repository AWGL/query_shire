package nhs.cardiff.genetics;

import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Json {

    private ObjectMapper mapper = new ObjectMapper();
    private Worksheet worksheet;

    public void json(Worksheet worksheet) {
        this.worksheet = worksheet;
    }

    public void writeJsonFile(File writeTo) throws IOException {
        mapper.writeValue(writeTo, worksheet);
    }

    public void writeJsonStream(PrintStream writeTo) throws IOException {
        mapper.writeValue(writeTo, worksheet);
    }
}
