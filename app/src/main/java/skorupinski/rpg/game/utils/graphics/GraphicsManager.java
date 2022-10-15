package skorupinski.rpg.game.utils.graphics;

import java.nio.file.Path;
import java.util.HashMap;

import skorupinski.rpg.core.graphics.sprites.Sprite;
import skorupinski.rpg.core.graphics.sprites.Spritesheet;
import skorupinski.rpg.core.math.Vector2i;

public abstract class GraphicsManager {
    
    private HashMap<GraphicsType, Object> groups;

    public GraphicsManager() {
        groups = new HashMap<>();
        establishGraphics();
    }

    protected void add(GraphicsType type, Object graphics) {
        groups.put(type, graphics);
    }

    protected Sprite stillGraphics(String path) {
        return new Sprite(Path.of(path));
    }

    protected AnimationGroup animationGroup(String path, int frameInterspace, Vector2i spriteSize) {
        Spritesheet sheet = new Spritesheet(Path.of(path), spriteSize.x, spriteSize.y);
        return new AnimationGroup(sheet, frameInterspace);
    }

    protected AnimationGroup animationGroup(String path, int frameInterspace, int spriteSize) {
        Spritesheet sheet = new Spritesheet(Path.of(path), spriteSize, spriteSize);
        return new AnimationGroup(sheet, frameInterspace);
    }

    public Object getGraphics(GraphicsType type) {
        return groups.get(type);
    }

    protected abstract void establishGraphics();
}
