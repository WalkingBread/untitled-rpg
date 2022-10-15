package skorupinski.rpg;

import skorupinski.rpg.core.game.Game;
import skorupinski.rpg.core.game.GameConfig;
import skorupinski.rpg.core.game.GameEventHandler;
import skorupinski.rpg.core.game.Window;
import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.game.World;

public class Driver {
    
    public static void main(String[] args) {
 
        Window window = new Window();
        window.setTitle("test");
        window.setMinSize(600, 600);
 
        GameConfig config = new GameConfig();
        config.fps(60);
        config.tps(60);
 
        Game.init(window, config);

        World world = new World();
 
        GameEventHandler handler = new GameEventHandler() {
            @Override
            public void onTick() {
                world.update();
            }
 
            @Override
            public void onFrame(Painter painter) {
                world.display(painter);
            }
 
            @Override
            public void onStart() {
                // executed at game loop start
            }
 
            @Override
            public void onClose() {
                // executed at game termination
            }
        };
     
        Game.addGameEventHandler(handler);
        Game.start();
    }
}