package inbusiness.space.webapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilfried on 20/12/2015.
 */
public class MailInfo {

    private String from;
    private String to;

    private String subject;
    private String body;

    private List<NamedContent> attachments = new ArrayList<>();


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<NamedContent> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<NamedContent> attachments) {
        this.attachments = attachments;
    }
}
