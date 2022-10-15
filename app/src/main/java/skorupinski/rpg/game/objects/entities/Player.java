package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.core.events.keyboard.Key;
import skorupinski.rpg.core.events.keyboard.Keyboard;
import skorupinski.rpg.core.game.Game;
import skorupinski.rpg.core.map.ChunkMap;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.game.utils.graphics.GraphicsType;

public class Player extends Entity {

    public Player(Vector2 position, Vector2 size, Statistics stats, ChunkMap map) {
        super(position, size, stats, map);

        objectState = GraphicsType.WALKING;
    }

    private void handleUserInput() {
        Keyboard keyboard = Game.keyboard();

        move = new Vector2();
        if(keyboard.isPressed(Key.W)) {
            move = new Vector2(0, -stats.speed);
        } 
        if(keyboard.isPressed(Key.S)) {
            move = move.add(new Vector2(0, stats.speed));
        }
        if(keyboard.isPressed(Key.A)) {
            if(move.y != 0) {
                float x = (float) -(stats.speed / Math.sqrt(2));
                float y = move.y > 0 ? -x : x; 
                move = new Vector2(x, y);
            } else {
                move = new Vector2(-stats.speed, 0);
            }
        }
        if(keyboard.isPressed(Key.D)) {
            if(move.y != 0) {
                float x = (float) (stats.speed / Math.sqrt(2));
                float y = move.y > 0 ? x : -x; 
                move = new Vector2(x, y);
            } else {
                move = move.add(new Vector2(stats.speed, 0));
            }
        }
    }

    @Override
    public void update() {
        handleUserInput();
        super.update();
    }
    
}
