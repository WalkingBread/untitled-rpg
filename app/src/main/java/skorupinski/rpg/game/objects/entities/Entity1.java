package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.game.World;
import skorupinski.rpg.game.objects.entities.utils.Statistics;

public class Entity1 extends Mob {

    private static final Statistics STATS = new Statistics();

    public Entity1(Vector2 position, Vector2 size, World world) {
        super(position, size, STATS, world);
    }

    @Override
    protected void targetBehaviour(Entity target) {
        approachTarget(target);
    }
    
}
