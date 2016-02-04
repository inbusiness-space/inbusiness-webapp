package inbusiness.space.webapp.mapper;

import javax.inject.Named;

/**
 * Created by fer on 12/10/2015.
 */
@Named
public class IntMapper {
    public int asString(String value) {
        if (value==null) {
            return 0;
        }
        return Integer.valueOf(value);
    }

    public String asInt(int number) {
        return ""+number;
    }
}
