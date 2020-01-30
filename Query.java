package nhs.cardiff.genetics;

import java.sql.*;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

//com.fasterxml.jackson.core:jackson-core:2.6.0 and databind same version

public class Query {
    private String db;
    private String url;

    public Query(String databaseName, String databaseUrl){
        this.db = databaseName;
        this.url = (databaseUrl + databaseName);
}
    public ResultSet queryShire(String input) throws Exception{

        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        Connection conn = DriverManager.getConnection(this.url);
        /*
        PreparedStatement st = conn.prepareStatement("SELECT DISTINCTROW "
                + " DNA_WORKSHEET_DET.LABNO,"
                + " DNA_WORKSHEET_DET.POSITION,"
                + " DNA_WORKSHEET.WORKSHEET,"
                + " DNALAB_TEST.TEST,"
                + " DNALAB.UPDATEDDATE,"
                + " PATIENT.SEX,"
                + " DNALAB.REASON_FOR_REFERRAL,"
                + " PATIENT.FIRSTNAME,"
                + " DNALAB_TEST.COMMENTS"
                + " FROM ((((DNA_TEST INNER JOIN DNA_WORKSHEET ON DNA_TEST.TEST = DNA_WORKSHEET.TEST)"
                + " INNER JOIN DNA_WORKSHEET_DET ON DNA_WORKSHEET.WORKSHEET = DNA_WORKSHEET_DET.WORKSHEET)"
                + " INNER JOIN DNALAB_TEST ON (DNA_TEST.TEST = DNALAB_TEST.TEST)"
                + " AND (DNA_WORKSHEET_DET.LABNO = DNALAB_TEST.LABNO))"
                + " INNER JOIN DNALAB ON DNA_WORKSHEET_DET.LABNO = DNALAB.LABNO)"
                + " INNER JOIN PATIENT ON DNALAB.INTID = PATIENT.INTID"
                + " WHERE (((DNA_WORKSHEET.WORKSHEET)=?) AND ((DNA_WORKSHEET_DET.LABNO)<>'')"
                + " ORDER BY DNA_WORKSHEET_DET.POSITION ASC;");
        */
        PreparedStatement st = conn.prepareStatement("SELECT DISTINCTROW "
                + "TEST.LABNO, TEST.POSITION, TEST.WORKSHEET, TEST.TEST, TEST.UPDATEDDATE, TEST.SEX, "
                + "TEST.REASON_FOR_REFERRAL, TEST.FIRSTNAME, TEST.COMMENTS"
                + "FROM TEST"
                + "ORDER BY TEST.POSITION ASC;");
        // Pass worksheet identifier into query string and execute query
        st.setString(1, input);
        ResultSet rs = st.executeQuery();
        System.out.println(rs);
        System.out.println(rs.getClass());
        return rs;
    }
}
