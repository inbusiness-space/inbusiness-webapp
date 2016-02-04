package inbusiness.space.webapp.domain;

/**
 * Created by fer on 08/09/2015.
 */
public class Location {
    private long lat;
    private long lon;

    public Location() {
        super();
    }

    public Location(long lat, long lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }
}
