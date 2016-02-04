package inbusiness.space.webapp.dto;

import java.util.List;

/**
 * Created by wilfried on 09/09/15.
 */
public class ThemeConfigureControl {

    private String name;
    private String replace;
    private String control;
    private String selected;
    private String cssFormat;
    private List<String> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getCssFormat() {
        return cssFormat;
    }

    public void setCssFormat(String cssFormat) {
        this.cssFormat = cssFormat;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
