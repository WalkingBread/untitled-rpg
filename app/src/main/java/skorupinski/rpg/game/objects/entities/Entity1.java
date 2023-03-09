package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.game.World;
import skorupinski.rpg.game.objects.entities.utils.Attack;
import skorupinski.rpg.game.objects.entities.utils.Statistics;

public class Entity1 extends Mob {

    private static final Statistics STATS = new Statistics().speed(5);

    public Entity1(Vector2 position, Vector2 size, World world) {
        super(position, size, STATS, world);
        currentAttack = new Attack(90, 3, 50, 1000, this);
    }

    @Override
    protected void targetBehaviour(Entity target) {
        attackTarget(target);
    }
    
}
