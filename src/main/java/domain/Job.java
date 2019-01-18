package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    @JacksonXmlProperty(isAttribute=true)
    @Id
    private String id;

    @JacksonXmlProperty
    @Column
    private Type type;

    @JacksonXmlProperty
    @Transient
    private String user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name")
    private User userRef;

    @JacksonXmlProperty
    @Column
    private String device;

    @JacksonXmlProperty
    @Column
    private int amount;

    public Type getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getDevice() {
        return device;
    }

    public String getUser() {
        return user;
    }

    public User getUserObj() {
        return userRef;
    }

    public String getId() {
        return id;
    }

    public void setUserRef(User user) {
        this.userRef = user;
    }
}
