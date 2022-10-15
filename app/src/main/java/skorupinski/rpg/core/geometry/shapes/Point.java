package skorupinski.rpg.core.geometry.shapes;

import skorupinski.rpg.core.math.Vector2;

public class Point extends Shape {

    public Point(Vector2 position) {
        super(position);
    }

    @Override
    public Vector2 getMid() {
        return position;
    }

    @Override
    public Vector2[] getVertices() {
        return new Vector2[]{position};
    }

    @Override
    public Vector2[] getAxes() {
        return new Vector2[]{};
    }
}
