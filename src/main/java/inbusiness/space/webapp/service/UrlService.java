package inbusiness.space.webapp.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fer on 01/08/2015.
 */
@Service
public class UrlService {
    private final List<String> extensionList = Arrays.asList("gif", "png", "jpg", "jpeg", "svg");

    public String getBaseDirUrl(String friendlyId) {
        return "/sites/" + friendlyId + "/";
    }

    public String getImagesDirUrl(String friendlyId) {
        return "/sites/" + friendlyId + "/files";
    }

    public String getImagesThumbsDirUrl(String friendlyId) {
        return "/sites/" + friendlyId + "/files/thumbs";
    }

    public String getImagesUrl(String friendlyId, String fileName) {
        if (fileName==null) {
            return null;
        } else {
            return getImagesDirUrl(friendlyId) + "/" + fileName;
        }
    }

    public String getImagesThumbsUrl(String friendlyId, String fileName) {
        if (fileName==null) {
            return null;
        } else {
            return getImagesThumbsDirUrl(friendlyId) + "/" + fileName;
        }
    }

    public List<String> getImagesExtension() {
        return extensionList;
    }

    public boolean isAnImage(String url) {
        final List<String> extensionList = getImagesExtension();
        final String toLowerCase = url.toLowerCase();
        for(String extension : extensionList) {
            if (toLowerCase.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    public String getThumbUrl(String url) {
        int lastSlashPos = url.lastIndexOf('/');
        if (lastSlashPos >= 0) {
            return url.substring(0, lastSlashPos) + "/thumbs" + url.substring(lastSlashPos);
        } else {
            return "/thumbs/" + url;
        }
    }

    public String getUrlWihhoutThumb(String url) {
        return url.replace("/thumbs/", "/");
    }

}
