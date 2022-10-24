package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.utils.Direction4;
import skorupinski.rpg.game.World;
import skorupinski.rpg.game.objects.GameObject;
import skorupinski.rpg.game.objects.entities.utils.Statistics;
import skorupinski.rpg.game.utils.graphics.GraphicsType;

public abstract class Entity extends GameObject {

    protected Statistics stats;

    protected Vector2 move = new Vector2();

    protected float attackRange;

    private Vector2 walkingTarget = null;

    public Entity(Vector2 position, Vector2 size, Statistics stats, World world) {
        super(position, size, world);

        this.stats = stats;
        objectState = GraphicsType.STANDING;
    }

    protected Direction4 calculateDirection(Vector2 move) {
        float angle = (float) ((180 / Math.PI) * -Math.atan2(move.y, move.x));
        return Direction4.getDirection(angle);
    }

    protected void moveToWalkingTarget() {
        Vector2 distance = walkingTarget.substract(position.vector());
        if(distance.getLength() < stats.speed) {
            move = distance;
        } else if(distance.getLength() != 0) {
            distance = distance.normalize();
            move = distance.multiply(stats.speed);
        }
    }

    public void walkTo(Vector2 target) {
        walkingTarget = target;
    }

    protected void stop() {
        move = new Vector2();
        walkingTarget = null;
    }

    @Override
    public void update() {
        if(walkingTarget != null) {
            moveToWalkingTarget();
        }

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
