package skorupinski.rpg.core.math;

public class Vector2i {
    
    public final int x;

    public final int y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i() {
        x = 0;
        y = 0;
    }

    public boolean isZero() {
        return x == 0 && y == 0;
    }
    
    public Vector2 toVector2() {
        return new Vector2(x, y);
    }
}
