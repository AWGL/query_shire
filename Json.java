package nhs.cardiff.genetics;

import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Json {
    public static void json(Worksheet worksheet) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(System.out, worksheet);

    }
}
