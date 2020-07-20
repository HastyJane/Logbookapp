package life.equester.logbookapp2.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Snippet extends AbstractEntity {

    private String textEntry;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;


    public Snippet() {

    }

    public Snippet(String textEntry, Date timestamp) {
        this.textEntry = textEntry;
        this.timestamp = timestamp;
    }

    public String getTextEntry() {
        return textEntry;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setTextEntry(String textEntry) {
        this.textEntry = textEntry;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}