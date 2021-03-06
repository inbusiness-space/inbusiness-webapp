package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "Roles")
//@Document(indexName="respond")
public class Roles {
    //@Id
    //@Column(name = "RoleId", nullable = false, insertable = true, updatable = true, length = 50)
    private String id;
    private String name;
    private String canView;
    private String canEdit;
    private String canPublish;
    private String canRemove;
    private String canCreate;

    public String getId() {
        return id;
    }

    public void setId(String roleId) {
        this.id = roleId;
    }

    //@Basic
    //@Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@Basic
    //@Column(name = "CanView", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCanView() {
        return canView;
    }

    public void setCanView(String canView) {
        this.canView = canView;
    }

    //@Basic
    //@Column(name = "CanEdit", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(String canEdit) {
        this.canEdit = canEdit;
    }

    //@Basic
    //@Column(name = "CanPublish", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCanPublish() {
        return canPublish;
    }

    public void setCanPublish(String canPublish) {
        this.canPublish = canPublish;
    }

    //@Basic
    //@Column(name = "CanRemove", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCanRemove() {
        return canRemove;
    }

    public void setCanRemove(String canRemove) {
        this.canRemove = canRemove;
    }

    //@Basic
    //@Column(name = "CanCreate", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(String canCreate) {
        this.canCreate = canCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (id != null ? !id.equals(roles.id) : roles.id != null) return false;
        if (name != null ? !name.equals(roles.name) : roles.name != null) return false;
        if (canView != null ? !canView.equals(roles.canView) : roles.canView != null) return false;
        if (canEdit != null ? !canEdit.equals(roles.canEdit) : roles.canEdit != null) return false;
        if (canPublish != null ? !canPublish.equals(roles.canPublish) : roles.canPublish != null) return false;
        if (canRemove != null ? !canRemove.equals(roles.canRemove) : roles.canRemove != null) return false;
        if (canCreate != null ? !canCreate.equals(roles.canCreate) : roles.canCreate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (canView != null ? canView.hashCode() : 0);
        result = 31 * result + (canEdit != null ? canEdit.hashCode() : 0);
        result = 31 * result + (canPublish != null ? canPublish.hashCode() : 0);
        result = 31 * result + (canRemove != null ? canRemove.hashCode() : 0);
        result = 31 * result + (canCreate != null ? canCreate.hashCode() : 0);
        return result;
    }
}
