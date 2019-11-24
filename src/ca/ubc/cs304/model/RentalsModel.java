package ca.ubc.cs304.model;

import java.sql.Date;

public class RentalsModel {
    private String rid;
    private String vlicense;
    private String dlicense;
    private Date fromDate;
    private String fromTime;
    private Date toDate;
    private String toTime;
    private Integer odometer;
    private String cardName;
    private String cardNo;
    private String expDate;
    private String confNo;


    public RentalsModel( String rid, String vlicense, String dlicense, Date fromDate, String fromTime, Date toDate,
                         String toTime, Integer odometer, String cardName, String cardNo, String expDate, String confNo) {
        this.rid = rid;
        this.vlicense = vlicense;
        this.dlicense = dlicense;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
        this.odometer = odometer;
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.confNo = confNo;
    }

    public String getRid() {
        return rid;
    }

    public String getVlicense() { return  vlicense;}

    public String getDlicense() { return dlicense;}

    public Date getFromDate() {return fromDate;}

    public Date getToDate() {return toDate;}

    public String getFromTime() { return  fromTime;}

    public String getToTime() { return toTime;}

    public Integer getOdometer() {return odometer;}

    public String getCardName() { return  cardName;}

    public String getCardNo() { return cardNo;}

    public String getExpDate() { return  expDate;}

    public String getConfNo() { return confNo;}

}
