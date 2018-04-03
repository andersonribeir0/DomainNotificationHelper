package notifications;

import java.util.Date;

import static java.util.UUID.randomUUID;

public class DomainNotification {
    private String id;
    private String key;
    private String value;
    private Date date;

    public DomainNotification() {
        this.id = randomUUID().toString();
        this.date = new Date();
    }

    public DomainNotification(String key, String value){
        this.id = randomUUID().toString();
        this.date = new Date();
        this.key = key;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
} 