package skorupinski.rpg.game;

import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.map.ChunkMap;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.math.Vector2i;
import skorupinski.rpg.core.rendering.Camera;
import skorupinski.rpg.game.objects.entities.Player;
import skorupinski.rpg.game.objects.entities.utils.Statistics;

public class World {
    
    private ChunkMap map;

    private Camera camera;

    private Player player;

    public World() {
        map = new ChunkMap(new Vector2i(20, 10), 100);

        camera = new Camera();
        camera.focusOn(new Vector2(0, 0));

        Statistics stats = new Statistics();

        player = new Player(new Vector2(0, 0), new Vector2(50, 50), stats, map);
    }

    public void display(Painter painter) {
        map.display(painter, camera);
        player.display(camera, painter);
    }

    public void update() {
        player.update();
        camera.focusOn(player.getPosition().vector());
    }

    public Camera getCamera() {
        return camera;
    }
}
