package skorupinski.rpg.core.rendering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import skorupinski.rpg.core.game.Game;
import skorupinski.rpg.core.geometry.positions.Global;
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

    public List<? extends Renderable<Global>> getRenderingOrder(List<? extends Renderable<Global>> renderables) {
        Comparator<Renderable<Global>> comparator = new Comparator<Renderable<Global>>() {
            @Override
            public int compare(Renderable<Global> o1, Renderable<Global> o2) {
                return Float.compare(o1.position.vector().y, o2.position.vector().y);
            }
        };
        List<? extends Renderable<Global>> sorted = new ArrayList<>(renderables);
        Collections.sort(renderables, comparator);
        return sorted;
    }
}

