package skorupinski.rpg.game.objects.entities.utils;

import java.awt.Color;

import skorupinski.rpg.core.geometry.positions.Global;
import skorupinski.rpg.core.geometry.shapes.Rectangle;
import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.math.Vector2i;
import skorupinski.rpg.core.rendering.Camera;
import skorupinski.rpg.core.rendering.Renderable;
import skorupinski.rpg.game.objects.entities.Entity;

public class Healthbar extends Renderable<Global> {

    private static final Color LACKING_HP_COLOR = Color.RED;

    private static final Color HP_COLOR = Color.GREEN;

    public final Vector2i size;

    public final Entity entity;

    private static Vector2 calculatePosition(Entity entity, Vector2i size) {
        Vector2 entitySize = entity.getSize();
        Vector2 entityPosition = entity.getPosition().vector();

        int verticalBreak = size.y;
        Vector2 shift = new Vector2(size.x / 2, entitySize.y + size.y);
        return entityPosition.substract(shift);
    }

    public Healthbar(Entity entity, Vector2i size) {
        super(new Global(calculatePosition(entity, size)));
        this.size = size;
        this.entity = entity;
    }

    @Override
    protected void draw(Painter painter, Vector2 position, Camera camera) {
        Rectangle lackingHp = new Rectangle(position, size.toVector2());
        painter.color(LACKING_HP_COLOR);
        painter.fill(lackingHp);

        float hpLength = ((float) entity.getStats().hp / (float) entity.getStats().maxHp) * size.x;
        Rectangle hp = new Rectangle(position, new Vector2(hpLength, size.y));
        painter.color(HP_COLOR);
        painter.fill(hp);
    }

    public void update() {
        position.set(calculatePosition(entity, size));
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(position.vector(), size.toVector2());
    }
}
