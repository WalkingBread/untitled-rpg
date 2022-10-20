package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.core.map.ChunkMap;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.utils.Direction4;
import skorupinski.rpg.game.objects.GameObject;
import skorupinski.rpg.game.objects.entities.utils.Statistics;
import skorupinski.rpg.game.utils.graphics.GraphicsType;

public abstract class Entity extends GameObject {

    protected Statistics stats;

    protected Vector2 move;

    public Entity(Vector2 position, Vector2 size, Statistics stats, ChunkMap map) {
        super(position, size, map);

        this.stats = stats;

        move = new Vector2();
        objectState = GraphicsType.STANDING;
    }

    protected Direction4 calculateDirection(Vector2 move) {
        float angle = (float) ((180 / Math.PI) * -Math.atan2(move.y, move.x));
        return Direction4.getDirection(angle);
    }

    @Override
    public void update() {
        if(!move.isZero()) {
            move(move);
            objectState = GraphicsType.WALKING;
            direction = calculateDirection(move);
        } else {
            objectState = GraphicsType.STANDING;
        }
    }
    
    public void setDirection(Direction4 direction) {
        this.direction = direction;
    }
}
