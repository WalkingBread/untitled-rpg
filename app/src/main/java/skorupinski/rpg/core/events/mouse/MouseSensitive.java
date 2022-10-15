package skorupinski.rpg.core.events.mouse;

import skorupinski.rpg.core.geometry.shapes.Shape;

public class MouseSensitive {

    boolean alreadyHovered;

    Shape shape;

    MouseSensitive(Shape shape) {
        this.shape = shape;

        alreadyHovered = false;

    }

    boolean isHovered(Mouse mouse) {
        return shape.collidesWith(mouse.getPosition());
    }

    
}