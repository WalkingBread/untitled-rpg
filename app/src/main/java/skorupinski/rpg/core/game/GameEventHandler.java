package skorupinski.rpg.core.game;

import skorupinski.rpg.core.graphics.Painter;

public abstract class GameEventHandler {
    
    public abstract void onTick();

    public abstract void onFrame(Painter painter);

    public abstract void onStart();

    public abstract void onClose();
}
