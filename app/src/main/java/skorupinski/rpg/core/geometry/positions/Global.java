package skorupinski.rpg.core.geometry.positions;

import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.rendering.Camera;

public class Global extends Position {

    protected Vector2 position;
    
    public Global(Vector2 position) {
        this.position = position;
    }

    public Global(float x, float y) {
        position = new Vector2(x, y);
    }

    @Override
    public Vector2 vector() {
        return position;
    }

    public void set(Vector2 position) {
        this.position = position;
    }

    public Display toDisplayPosition(Camera camera) {
        return new Display(camera.getDisplayPosition(position));
    }
}
