package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Job")
public class Job {

    @JacksonXmlProperty
    private String type;

    @JacksonXmlProperty
    private String user;

    @JacksonXmlProperty
    private String device;

    @JacksonXmlProperty
    private int amount;

    public Job() {}

    public Job(String type, String user, String device, int amount) {
        this.type = type;
        this.amount = amount;
        this.device = device;
        this.user = user;
    }

    public String getType() {
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
}
