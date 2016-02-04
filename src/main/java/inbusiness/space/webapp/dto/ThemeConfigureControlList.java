package inbusiness.space.webapp.dto;

import java.util.List;

/**
 * Created by wilfried on 09/09/15.
 */
public class ThemeConfigureControlList {

    String name;
    List<ThemeConfigureControl> controls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ThemeConfigureControl> getControls() {
        return controls;
    }

    public void setControls(List<ThemeConfigureControl> controls) {
        this.controls = controls;
    }
}
