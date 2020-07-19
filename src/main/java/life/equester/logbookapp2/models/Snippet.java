package life.equester.logbookapp2.models;


import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Snippet extends AbstractEntity {

private String snippet;
private LocalDateTime timeStamp;

    public Snippet() {

    }

    public Snippet(String snippet, LocalDateTime timeStamp) {
        this.snippet = snippet;
        this.timeStamp = timeStamp;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}