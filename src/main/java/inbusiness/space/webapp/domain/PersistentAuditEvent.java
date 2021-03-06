package inbusiness.space.webapp.domain;

//import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Persist AuditEvent managed by the Spring Boot actuator
 * @see org.springframework.boot.actuate.audit.AuditEvent
 */
//@Entity
//@Table(name = "audit")
//@Document(indexName="audit")
public class PersistentAuditEvent {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
//    //@Column(name = "event_id")
    private String id;

    @NotNull
    //@Column(nullable = false)
    private String principal;

    //@Column(name = "event_date")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime auditEventDate;
    //@Column(name = "event_type")
    private String auditEventType;

    //@ElementCollection
    //@MapKeyColumn(name="name")
    //@Column(name="value")
    //@CollectionTable(name="JHI_PERSISTENT_AUDIT_EVT_DATA", joinColumns=@JoinColumn(name="event_id"))
    private Map<String, String> data = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public LocalDateTime getAuditEventDate() {
        return auditEventDate;
    }

    public void setAuditEventDate(LocalDateTime auditEventDate) {
        this.auditEventDate = auditEventDate;
    }

    public String getAuditEventType() {
        return auditEventType;
    }

    public void setAuditEventType(String auditEventType) {
        this.auditEventType = auditEventType;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
