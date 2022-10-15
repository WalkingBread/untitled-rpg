package skorupinski.rpg.core.rendering;

import skorupinski.rpg.core.game.Game;
import skorupinski.rpg.core.geometry.shapes.Rectangle;
import skorupinski.rpg.core.math.Vector2;

public class Camera {
    public Vector2 position;

    public Camera() {
        position = new Vector2(0, 0);
    }

    public void focusOn(Vector2 globalPosition) {
        this.position = globalPosition.substract(Game.window().getSize().toVector2().divide(2));
    }

    public Rectangle getRectangle() {
        return new Rectangle(position, Game.window().getSize().toVector2());
    }

    public Vector2 getDisplayPosition(Vector2 globalPosition) {
        Vector2 displayPosition = globalPosition.substract(this.position);
        displayPosition = displayPosition.divide(Game.window().getResizeFactor());

        return displayPosition;
    }
}

