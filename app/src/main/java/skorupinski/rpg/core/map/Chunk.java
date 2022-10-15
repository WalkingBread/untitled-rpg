package skorupinski.rpg.core.map;

import java.awt.Color;

import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.geometry.positions.Global;
import skorupinski.rpg.core.geometry.shapes.Rectangle;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.rendering.Camera;
import skorupinski.rpg.core.rendering.Renderable;

public class Chunk extends Renderable<Global> {

    private ChunkMap map;

    private Rectangle territory;

    Chunk(Vector2 position, ChunkMap map) {
        super(new Global(position));
        
        this.map = map;

        int size = map.getChunkSize();
        territory = new Rectangle(position, new Vector2(size, size));
    }

    @Override
    public Rectangle getRectangle() {
        return territory;
    }

    private void defaultFill(Painter painter, Vector2 position) {
        painter.color(Color.BLACK);
        painter.draw(new Rectangle(position, territory.size));
    }

    @Override
    protected void draw(Painter painter, Vector2 position, Camera camera) {
        defaultFill(painter, position); 
    }

    public ChunkMap getMap() {
        return map;
    }
}
