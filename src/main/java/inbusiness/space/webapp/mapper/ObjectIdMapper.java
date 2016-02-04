package inbusiness.space.webapp.mapper;

import org.bson.types.ObjectId;

/**
 * Created by fer on 13/11/2015.
 */
public class ObjectIdMapper {
    public String asObjectId(ObjectId objectId) {
        return objectId.toString();
    }

    public ObjectId asString(String objectIdStr) {
        return new ObjectId(objectIdStr);
    }
}
