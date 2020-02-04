package nhs.cardiff.genetics;

import java.sql.*;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Query {
    private String db;
    private String url;
    Connection conn = null;
    ResultSet rs = null;
    String statement = null;
    Worksheet worksheet = null;

    public Query(String databaseName, String databaseUrl) {
        this.db = databaseName;
        this.url = (databaseUrl + databaseName);
}
    public Worksheet queryShire(String input, boolean testing) throws Exception{

        if (testing) {
            statement = "SELECT DISTINCTROW TESTING.LABNO, "
                    + "TESTING.POSITION, TESTING.WORKSHEET, TESTING.TEST, TESTING.UPDATEDDATE, TESTING.SEX, "
                    + "TESTING.REASON_FOR_REFERRAL, TESTING.FIRSTNAME, TESTING.COMMENTS "
                    + "FROM TESTING "
                    + "WHERE ((TESTING.WORKSHEET)=?)"
                    + "ORDER BY TESTING.POSITION ASC;";
        } else {
            statement = "SELECT DISTINCTROW DNA_WORKSHEET_DET.LABNO,"
                    + " DNA_WORKSHEET_DET.POSITION,"
                    + " DNA_WORKSHEET.WORKSHEET,"
                    + " DNALAB_TEST.TEST,"
                    + " DNALAB.UPDATEDDATE,"
                    + " PATIENT.SEX,"
                    + " DNALAB.REASON_FOR_REFERRAL,"
                    + " PATIENT.FIRSTNAME,"
                    + " DNALAB_TEST.COMMENTS "
                    + " FROM ((((DNA_TEST INNER JOIN DNA_WORKSHEET ON DNA_TEST.TEST = DNA_WORKSHEET.TEST)"
                    + " INNER JOIN DNA_WORKSHEET_DET ON DNA_WORKSHEET.WORKSHEET = DNA_WORKSHEET_DET.WORKSHEET)"
                    + " INNER JOIN DNALAB_TEST ON (DNA_TEST.TEST = DNALAB_TEST.TEST) "
                    + " AND (DNA_WORKSHEET_DET.LABNO = DNALAB_TEST.LABNO)) "
                    + " INNER JOIN DNALAB ON DNA_WORKSHEET_DET.LABNO = DNALAB.LABNO)"
                    + " INNER JOIN PATIENT ON DNALAB.INTID = PATIENT.INTID"
                    + " WHERE (((DNA_WORKSHEET.WORKSHEET)=?) AND ((DNA_WORKSHEET_DET.LABNO)<>'')"
                    + " ORDER BY DNA_WORKSHEET_DET.POSITION ASC;";
        }

        // Pass worksheet identifier into query string and execute query
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(this.url);
            PreparedStatement st = conn.prepareStatement(statement);
            st.setString(1, input);
            rs = st.executeQuery();
            // Write data to a persistent object
            // Make worksheet object
            worksheet = new Worksheet(input);
            worksheet.setUser(System.getProperty("user.name"));
            while (rs.next()) {
                // Make sample object
                Sample sample = new Sample();
                sample.setLabNo(rs.getString("LABNO"));
                sample.setPosition(rs.getString("POSITION"));
                sample.setWorksheet(rs.getString("WORKSHEET"));
                sample.setTest(rs.getString("TEST"));
                sample.setUpdatedDate(rs.getString("UPDATEDDATE"));
                sample.setSex(rs.getString("SEX"));
                sample.setReferralReason(rs.getString("REASON_FOR_REFERRAL"));
                sample.setFirstName(rs.getString("FIRSTNAME"));
                sample.setComments(rs.getString("COMMENTS"));
                worksheet.setSamples(sample);
            }
        } catch (Exception e) {
            //Handle exceptions in here better if desired
            throw new Exception(e);
        } finally {
            try { if(conn!=null) {conn.close();} } catch (Exception e) {}
        }
        return worksheet;
    }
}
