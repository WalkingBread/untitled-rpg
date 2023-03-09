package skorupinski.rpg.game.objects.entities;

import java.util.ArrayList;
import java.util.List;

import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.game.World;
import skorupinski.rpg.game.objects.entities.utils.Statistics;

public abstract class Mob extends Entity {

    protected static final float DEFAULT_TRIGGER_RANGE = 500;

    protected Entity target = null;

    protected float triggerRange = DEFAULT_TRIGGER_RANGE;

    protected List<Class<? extends Entity>> hostileTowards; 

    public Mob(Vector2 position, Vector2 size, Statistics stats, World world) {
        super(position, size, stats, world);

        hostileTowards = new ArrayList<>();
        hostileTowards.add(Player.class);
    }

    private void detectTargets() {
        target = null;
        for(Entity en : world.getOtherEntities(this)) {
            if(en.getPosition().vector().distanceFrom(getPosition().vector()) < triggerRange) {
                if(hostileTowards.contains(en.getClass())) {
                    target = en;
                    break;
                }
            }
        }
    }

    protected abstract void targetBehaviour(Entity target);

    protected void attackTarget(Entity target) {
        Vector2 targetPosition = target.getPosition().vector();
        walkTo(targetPosition);
        if(getPosition().vector().distanceFrom(targetPosition) <= currentAttack.getRadius()) {
            stop();
            currentAttack.execute(direction);
        }
    }

    @Override
    public void update() {
        detectTargets();
        if(target != null) {
            targetBehaviour(target);
        }
        super.update();
    }
    
}
