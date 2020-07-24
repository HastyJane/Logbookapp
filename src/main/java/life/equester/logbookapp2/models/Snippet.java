package life.equester.logbookapp2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Snippet extends AbstractEntity {
    @NotBlank
    @Size(max = 255)
    private String textEntry;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public String getFormattedDate() {
        String s = new SimpleDateFormat("hh:mm a MM/dd/yyyy ").format(timeStamp);
        return s;
    }

    @ManyToOne
    private User user;


    public void setUser(User user) {
        this.user = user;
    }


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