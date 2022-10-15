package skorupinski.rpg.core.map;

import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.math.Vector2i;
import skorupinski.rpg.core.rendering.Camera;

public class ChunkMap {

    private int chunkSize;

    private Vector2i sizeInChunks;

    private Vector2 realSize;

    private Chunk[][] chunks;

    public ChunkMap(Vector2i sizeInChunks, int chunkSize) {

        this.sizeInChunks = sizeInChunks;
        this.chunkSize = chunkSize;

        realSize = sizeInChunks.toVector2().multiply(chunkSize);

        createMap();
    }

    public void createMap() {
        chunks = new Chunk[sizeInChunks.x][sizeInChunks.y];
        for(int i = 0; i < sizeInChunks.x; i++) {
            for(int j = 0; j < sizeInChunks.y; j++) {
                float x = i * chunkSize;
                float y = j * chunkSize;
                chunks[i][j] = new Chunk(new Vector2(x, y), this);
            }
        }
    }

    private void drawChunks(Painter painter, Camera camera) {
        for(int x = 0; x < sizeInChunks.x; x++) {
            for(int y = 0; y < sizeInChunks.y; y++) {
                Chunk chunk = chunks[x][y];
                chunk.display(camera, painter);
            }
        }
    }

    public void display(Painter painter, Camera camera) {
        drawChunks(painter, camera);
    }

    public int getChunkSize() {
        return chunkSize;
    }
    
    public Vector2 getRealSize() {
        return realSize;
    }

    public Vector2i getSizeInChunks() {
        return sizeInChunks;
    }
    
}
