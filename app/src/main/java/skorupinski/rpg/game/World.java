package skorupinski.rpg.game;

import java.util.ArrayList;
import java.util.List;

import skorupinski.rpg.core.geometry.positions.Global;
import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.map.ChunkMap;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.math.Vector2i;
import skorupinski.rpg.core.rendering.Camera;
import skorupinski.rpg.core.rendering.Renderable;
import skorupinski.rpg.core.utils.DiverseList;
import skorupinski.rpg.game.objects.GameObject;
import skorupinski.rpg.game.objects.entities.Entity;
import skorupinski.rpg.game.objects.entities.Entity1;
import skorupinski.rpg.game.objects.entities.Player;

public class World {
    
    private ChunkMap map;

    private Camera camera;

    private Player player;

    private Entity1 entity1;

    private DiverseList<GameObject> objects = new DiverseList<>();

    private List<GameObject> deadList = new ArrayList<>();

    public World() {
        camera = new Camera();
        camera.focusOn(new Vector2(0, 0));
        map = new ChunkMap(new Vector2i(20, 10), 100);

        player = new Player(new Vector2(0, 0), new Vector2(50, 60), this);
        entity1 = new Entity1(new Vector2(500, 500), new Vector2(50, 50), this);

        objects.add(player);
        objects.add(entity1);
    }

    public void display(Painter painter) {
        map.display(painter, camera);
        for(Renderable<Global> object : camera.getRenderingOrder(getObjects())) {
            object.display(camera, painter);
        }
    }

    public void update() {
        for(GameObject object : getObjects()) {
            object.update();
        }
        for(GameObject object : deadList) {
            objects.remove(object);
        }
        deadList.clear();
        camera.focusOn(player.getPosition().vector());
    }

    public Camera getCamera() {
        return camera;
    }

    public List<Entity> getEntities() {
        return objects.getAllOfClass(Entity.class);
    }

    public List<Entity> getOtherEntities(Entity excluded) {
        List<Entity> entities = objects.getAllOfClass(Entity.class);
        entities.remove(excluded);
        return entities;
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void kill(GameObject object) {
        deadList.add(object);
    }

    public void importWorldState() {
        // import state
    }

}
