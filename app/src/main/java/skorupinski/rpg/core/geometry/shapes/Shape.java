package skorupinski.rpg.core.geometry.shapes;

import skorupinski.rpg.core.geometry.sat.AxisProjector;
import skorupinski.rpg.core.math.Vector2;

public abstract class Shape {

    public Vector2 position;

    protected Shape(Vector2 position) {
        this.position = position;
    }

    protected Shape(float x, float y) {
        position = new Vector2(x, y);
    }

    public boolean collidesWith(Shape shape) {
        return AxisProjector.collide(this, shape);
    }

    public boolean collidesWith(Vector2 point) {
        return AxisProjector.collide(this, new Point(point));
    }

    public abstract Vector2 getMid();

    public abstract Vector2[] getVertices();

    public Vector2[] getAxes() {
        Vector2[] vertices = getVertices();
        Vector2[] axes = new Vector2[vertices.length];

        for(int i = 0; i < axes.length; i++) {
            Vector2 v = new Vector2(
                vertices[i].x - vertices[i + 1 == vertices.length ? 0 : i + 1].x,
                vertices[i].y - vertices[i + 1 == vertices.length ? 0 : i + 1].y
            );
    
            axes[i] = v.normalize();
        }
        return axes;
    }
}
