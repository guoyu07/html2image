package gui.ava.html.link;

import java.awt.Rectangle;
import java.util.List;
import java.util.Map;

/**
 * @author Yoav Aharoni
 */
public class LinkInfo{

    private final Map<String, String> attributes;

    private final List<Rectangle>     bounds;

    public LinkInfo(Map<String, String> attributes, List<Rectangle> bounds){
        this.attributes = attributes;
        this.bounds = bounds;
    }

    public Map<String, String> getAttributes(){
        return attributes;
    }

    public List<Rectangle> getBounds(){
        return bounds;
    }
}
