package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "jobs")
public class Jobs {

    @JacksonXmlElementWrapper(useWrapping=false)
    private List<Job> job;

    public List<Job> getJob() {
        return job;
    }

}
