package nhs.cardiff.genetics;

public class Database {
    private String db;
    private String url;

    public Database(){
        // Default values
        db = "M:\\Pyrosequencing\\Pyrosequencing Service\\PCR & PYRO spreadsheets\\Log\\IT\\SHIRE COPY FOR PYRO.MDB";
        url = ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=");
    }

    public void setDb(String database){
        this.db = database;
    }

    public String getDb(){
        return this.db;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }
}

