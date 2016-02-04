package inbusiness.space.webapp.mapper;

import javax.inject.Named;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by fer on 12/10/2015.
 */
@Named
public class DateMapper {
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    public String asDate(Timestamp date) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (date==null) {
            return null;
        }
        return sdf.format(date);
    }

    public Timestamp asString(String dtStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (dtStr==null) {
            return null;
        }
        try {
            return new Timestamp(sdf.parse(dtStr).getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}
