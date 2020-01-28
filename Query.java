package nhs.cardiff.genetics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//com.fasterxml.jackson.core:jackson-core:2.6.4

public class Query {
    private String db;
    private String url;

    public Query(){
        db = "M:\\Pyrosequencing\\Pyrosequencing Service\\PCR & PYRO spreadsheets\\Log\\IT\\SHIRE COPY FOR PYRO.MDB";
        url = ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + db);
}
    public void queryShire(String input) throws Exception{
        System.out.println(input);
        /*
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection conn = DriverManager.getConnection(url);

        PreparedStatement st = conn.prepareStatement("SELECT DISTINCTROW DNA_Worksheet.*,"
                + " DNA_WORKSHEET_DET.POSITION,"
                + " DNA_WORKSHEET_DET.LABNO,"
                + " DNA_Worksheet.WORKSHEET,"
                + " DNA_Worksheet.UPDATEDBY,"
                + " DNA_WORKSHEET_DET.WORKSHEET,"
                + " PATIENT.SEX,"
                + " DNALAB.REASON_FOR_REFERRAL,"
                + " PATIENT.FIRSTNAME"
                + " FROM (((DNA_Worksheet LEFT JOIN DNA_TEST"
                + " ON [DNA_Worksheet].TEST = [DNA_TEST].TEST)"
                + " INNER JOIN DNA_WORKSHEET_DET"
                + " ON [DNA_Worksheet].WORKSHEET = [DNA_WORKSHEET_DET].WORKSHEET)"
                + " LEFT OUTER JOIN [DNALAB]"
                + " ON [DNA_WORKSHEET_DET].LABNO = [DNALAB].LABNO)"
                + " LEFT OUTER JOIN [PATIENT]"
                + " ON [DNALAB].INTID = [PATIENT].INTID"
                + " WHERE ((([DNA_Worksheet].WORKSHEET)=[DNA_WORKSHEET_DET].[WORKSHEET])"
                + " AND (([DNA_WORKSHEET_DET].WORKSHEET)=?))"
                + " ORDER BY DNA_WORKSHEET_DET.POSITION ASC;");

        st.setString(1, input);
         */
        String test = "Some values go here";

        //Convert values to json to return to main and then write out to file
    }
}
