package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.core.map.ChunkMap;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.game.objects.entities.utils.Statistics;

public class Mob extends Entity {

    protected Entity target = null;

    public Mob(Vector2 position, Vector2 size, Statistics stats, ChunkMap map) {
        super(position, size, stats, map);

    }


    
}
