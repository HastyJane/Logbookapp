package life.equester.logbookapp2.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Snippet extends AbstractEntity {

    private String textEntry;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;




    public Snippet() {

    }

    public Snippet(String textEntry, Date timeStamp) {
        this.textEntry = textEntry;
        this.timeStamp = timeStamp;
    }

    public String getTextEntry() {
        return textEntry;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setTextEntry(String textEntry) {
        this.textEntry = textEntry;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}