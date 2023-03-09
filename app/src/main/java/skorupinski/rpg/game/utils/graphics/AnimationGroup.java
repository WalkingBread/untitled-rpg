package skorupinski.rpg.game.utils.graphics;

import java.util.HashMap;

import skorupinski.rpg.core.graphics.animations.Animation;
import skorupinski.rpg.core.graphics.sprites.Sprite;
import skorupinski.rpg.core.graphics.sprites.Spritesheet;
import skorupinski.rpg.core.utils.Direction4;

public class AnimationGroup {

    private Spritesheet spritesheet;

    private HashMap<Direction4, Animation> animations;

    private Direction4[] directionOrder = {
        Direction4.NORTH,
        Direction4.WEST,
        Direction4.SOUTH,
        Direction4.EAST
    };

    public AnimationGroup(Spritesheet spritesheet, int frameInterspace) {
        this.spritesheet = spritesheet;

        animations = new HashMap<>();
        for(int i = 0; i < spritesheet.getSprites().length; i++) {
            Sprite[] sprites = spritesheet.getSpritesAt(i);
            animations.put(directionOrder[i], new Animation(sprites, frameInterspace));
        }
    }

    public void setDirectionOrder(Direction4[] directionOrder) {
        this.directionOrder = directionOrder;
    }

    public Animation getAnimationFor(Direction4 direction) {
        return animations.get(direction);
    }

    public void setFunction(int[] frameIndexes, Runnable function) {
        for (HashMap.Entry<Direction4, Animation> entry : animations.entrySet()) {
            Animation animation = entry.getValue();
            animation.setFunction(frameIndexes, function);
        }
    }
}
