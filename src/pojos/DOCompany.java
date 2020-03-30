package pojos;

import org.eclnt.ccee.db.dofw.annotations.doentity;
import org.eclnt.ccee.db.dofw.annotations.doproperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@doentity(table="company")
public class DOCompany {

    int id;
    String name;
    String bulstat;
    Date date_established;

    @doproperty(key=true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @doproperty
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @doproperty
    public String getBulstat() {
        return bulstat;
    }
    public void setBulstat(String bulstat) {
        this.bulstat = bulstat;
    }

    @doproperty
    public Date getDate_established() { return date_established; }
    public void setDate_established(Date date_established) { this.date_established = date_established; }



}
