package skorupinski.rpg.core.geometry.positions;

import skorupinski.rpg.core.math.Vector2;

public class Display extends Position {
    
    protected Vector2 screenPosition;

    public Display(Vector2 screenPosition) {
        this.screenPosition = screenPosition;
    }

    @Override
    public Vector2 vector() {
        return screenPosition;
    }

    public void set(Vector2 position) {
        this.screenPosition = position;
    }
}
