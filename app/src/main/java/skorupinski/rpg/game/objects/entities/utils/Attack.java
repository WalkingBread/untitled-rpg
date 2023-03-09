package skorupinski.rpg.game.objects.entities.utils;

import skorupinski.rpg.core.math.Range;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.utils.Direction4;
import skorupinski.rpg.core.utils.Time;
import skorupinski.rpg.game.objects.entities.Entity;

public class Attack {

    private float attackAngle;

    private int damage;

    private float radius;

    private float cooldown;

    private Entity executor;

    private long lastCast;
    
    public Attack(float attackAngle, int damage, float radius, float cooldown, Entity executor) {
        this.attackAngle = attackAngle;
        this.damage = damage;
        this.radius = radius;
        this.cooldown = cooldown;
        this.executor = executor;

        lastCast = 0;
    }

    public void execute(Direction4 direction) {
        long time = Time.getMillis();
        if(Time.getMillis() - lastCast >= cooldown) {
            Range attackRange = getAttackRange(direction, attackAngle);

            for(Entity e : executor.getWorld().getOtherEntities(executor)) {
                if(inRange(e, attackRange)) {
                    e.takeDamage(damage);
                }
            }

            lastCast = time;
        }
    }

    private boolean inRange(Entity entity, Range range) {
        Vector2 distance = entity.getPosition().vector().substract(executor.getPosition().vector());
    
        float angle = (float) ((180 / Math.PI) * -Math.atan2(distance.y, distance.x));

        if(range.contains(angle) && executor.distanceFrom(entity) <= radius) {
            return true;
        }
        return false;
    }

    private Range getAttackRange() {
        return getAttackRange(executor.getDirection(), attackAngle);
    }

    private static Range getAttackRange(Direction4 direction, float attackAngle) {
        Range dirAngleRange = Direction4.getAngleRange(direction);

        float lower = dirAngleRange.getLower();
        float upper = dirAngleRange.getUpper();

        float mid = dirAngleRange.getMid();

        if(lower > upper) {
            float rangeSize = 360 - (lower - upper);
            mid = lower + rangeSize / 2;
        } 

        float lowerThreshold = mid - attackAngle / 2;
        float upperThreshold = mid + attackAngle / 2;

        if(lowerThreshold > 180) {
            lowerThreshold = attackAngle - lowerThreshold;
        }
        if(upperThreshold > 180) {
            upperThreshold = attackAngle - upperThreshold;
        }

        Range attackRange = new Range(lowerThreshold, upperThreshold);

        return attackRange;
    }   

    public float getRadius() {
        return radius;
    }
}
