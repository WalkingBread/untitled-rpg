package skorupinski.rpg.game.utils.graphics;

public enum GraphicsType {
    STILL("still"),
    WALKING("walking"),
    STANDING("standing"),
    FIGHTING("fighting");

    public String label;

    private GraphicsType(String label) {
        this.label = label;
    }

    public static GraphicsType getMatchingType(String s) {
        for(GraphicsType type : GraphicsType.values()) {
            if(type.label.equals(s)) {
                return type;
            }
        }
        return null;
    }
}