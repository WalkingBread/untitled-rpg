package skorupinski.rpg.core.utils;

import java.util.ArrayList;
import java.util.List;

public class DiverseList<T> extends ArrayList<T> {
    
    public <T> List<T> getAllOfClass(Class<T> c) {
        List<T> sublist = new ArrayList<>();
        for(Object object : this) {
            if(c.isInstance(object)) {
                sublist.add(c.cast(object));
            }
        }
        return sublist;
    }
}
