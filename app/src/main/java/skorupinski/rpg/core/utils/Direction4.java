package skorupinski.rpg.core.utils;

import java.util.HashMap;

import skorupinski.rpg.core.math.Range;

public enum Direction4 {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static HashMap<Direction4, Range> angleRange = new HashMap<>() {{
        put(EAST, new Range(-45f, 45f));
        put(NORTH, new Range(45f, 135f));
        put(WEST, new Range(135f, -135f));
        put(SOUTH, new Range(-135f, -45f));
    }}; 

    public static Direction4 getDirection(float angle) {
        Direction4 direction = null;

        for (HashMap.Entry<Direction4, Range> entry : angleRange.entrySet()) {
            Direction4 dir = entry.getKey();
            Range range = entry.getValue();
            
            if(range.contains(angle)) {
                direction = dir;
            }
        }
        return direction;
    }

    public static Range getAngleRange(Direction4 direction) {
        return angleRange.get(direction);
    }

    public static float getDirectionMid(Direction4 direction) {
        return angleRange.get(direction).getMid();
    }
}
