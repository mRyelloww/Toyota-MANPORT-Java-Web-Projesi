package Main.Models;


import javax.persistence.*;

@Entity
@Table
public class BusinessArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessAreaID;
    private String businessAreaName;

    public BusinessArea() {
    }

    public BusinessArea(String businessAreaName) {
        this.businessAreaName = businessAreaName;
    }

    public Long getBusinessAreaID() {
        return businessAreaID;
    }

    public void setBusinessAreaID(Long businessAreaID) {
        this.businessAreaID = businessAreaID;
    }

    public String getBusinessAreaName() {
        return businessAreaName;
    }

    public void setBusinessAreaName(String businessAreaName) {
        this.businessAreaName = businessAreaName;
    }
}
