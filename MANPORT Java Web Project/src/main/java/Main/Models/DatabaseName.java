package Main.Models;


import javax.persistence.*;

@Entity
@Table
public class DatabaseName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long databaseNameID;
    private String databaseName;

    public DatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public DatabaseName() {
    }

    public Long getDatabaseID() {
        return databaseNameID;
    }

    public void setDatabaseID(Long databaseNameID) {
        this.databaseNameID = databaseNameID;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}

