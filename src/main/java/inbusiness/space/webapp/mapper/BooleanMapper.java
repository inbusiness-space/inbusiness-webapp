package inbusiness.space.webapp.mapper;

import javax.inject.Named;

/**
 * Created by fer on 12/10/2015.
 */
@Named
public class BooleanMapper {
    public int asBoolean(boolean bool) {
        if (bool) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean asDate(int number) {
        return (number==1);
    }
}
