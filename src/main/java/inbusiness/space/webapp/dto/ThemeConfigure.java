package inbusiness.space.webapp.dto;

import java.util.List;

/**
 * Created by wilfried on 09/09/15.
 */
public class ThemeConfigure {
    List<ThemeConfigureControlList> configure;

    public List<ThemeConfigureControlList> getConfigure() {
        return configure;
    }

    public void setConfigure(List<ThemeConfigureControlList> configure) {
        this.configure = configure;
    }
}
