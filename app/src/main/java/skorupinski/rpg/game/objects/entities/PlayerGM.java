package skorupinski.rpg.game.objects.entities;

import skorupinski.rpg.game.utils.graphics.GraphicsManager;
import skorupinski.rpg.game.utils.graphics.GraphicsType;

public class PlayerGM extends GraphicsManager{
    @Override
    protected void establishGraphics() {
        add(GraphicsType.WALKING, animationGroup("test.png", 5, 64));
        add(GraphicsType.STANDING, stillGraphics("still.png"));
    }
    
}
