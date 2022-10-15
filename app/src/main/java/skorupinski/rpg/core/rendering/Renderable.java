package skorupinski.rpg.core.rendering;

import skorupinski.rpg.core.geometry.positions.Display;
import skorupinski.rpg.core.geometry.positions.Global;
import skorupinski.rpg.core.geometry.positions.Position;
import skorupinski.rpg.core.geometry.shapes.Rectangle;
import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.math.Vector2;

public abstract class Renderable<T extends Position> {
    protected T position;

    public Renderable(T position) {
        this.position = position;
    }

    protected abstract void draw(Painter painter, Vector2 position, Camera camera);

    public void display(Camera camera, Painter painter) {
        Vector2 displayPosition = null;

        if(position instanceof Global) {
            Global g = (Global) position;
            displayPosition = g.toDisplayPosition(camera).vector();

        } else {
            Display d = (Display) position;
            displayPosition = d.vector();
        }

        if(getRectangle().collidesWith(camera.getRectangle())) {
            draw(painter, displayPosition, camera);
        }
    }

    public abstract Rectangle getRectangle();

    public T getPosition() {
        return position;
    }
    
}
