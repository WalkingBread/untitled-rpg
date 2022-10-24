package skorupinski.rpg.game.objects;

import java.lang.reflect.Constructor;

import skorupinski.rpg.core.geometry.positions.Global;
import skorupinski.rpg.core.geometry.shapes.Rectangle;
import skorupinski.rpg.core.graphics.CoreGraphics;
import skorupinski.rpg.core.graphics.Painter;
import skorupinski.rpg.core.graphics.sprites.Sprite;
import skorupinski.rpg.core.math.Vector2;
import skorupinski.rpg.core.rendering.Camera;
import skorupinski.rpg.core.rendering.Renderable;
import skorupinski.rpg.core.utils.Direction4;
import skorupinski.rpg.game.World;
import skorupinski.rpg.game.utils.graphics.AnimationGroup;
import skorupinski.rpg.game.utils.graphics.GraphicsManager;
import skorupinski.rpg.game.utils.graphics.GraphicsType;

public abstract class GameObject extends Renderable<Global> {

    protected Vector2 size;

    protected World world;

    protected GraphicsManager gm;

    protected GraphicsType objectState = null;

    protected CoreGraphics currentGraphics = null;

    protected Direction4 direction;

    public GameObject(Vector2 position, Vector2 size, World world) {
        super(new Global(position));

        this.size = size;
        this.world = world;

        direction = Direction4.SOUTH;

        gm = attachGraphicsManager();
    }

    private GraphicsManager attachGraphicsManager() {
        try {
            Class<?> clazz = Class.forName(getClass().getName() + "GM");
            Constructor<?> constructor = clazz.getConstructor();
            return gm = (GraphicsManager) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void assignGraphics() {
        if(objectState != null) {
            Object graphics = gm.getGraphics(objectState);
            if(graphics instanceof AnimationGroup) {
                currentGraphics = ((AnimationGroup) graphics).getAnimationFor(direction);
            } else if(graphics instanceof CoreGraphics) {
                currentGraphics = (CoreGraphics) graphics;
            }
        }
    }

    @Override
    protected void draw(Painter painter, Vector2 position, Camera camera) {
        assignGraphics();
        if(currentGraphics != null) {
            Sprite graphics = currentGraphics.getSprite();
            Vector2 graphicsSize = graphics.getSize().toVector2();
            Vector2 offsetPosition = position.substract(new Vector2(graphicsSize.x / 2, graphicsSize.y));
            painter.sprite(currentGraphics.getSprite(), offsetPosition.toVector2i());
        }
    }

    public abstract void update();

    public boolean collidesWith(GameObject object) {
        return object.getRectangle().collidesWith(getRectangle());
    } 

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(position.vector(), size);
    }

    public void move(Vector2 distance) {
        position.set(position.vector().add(distance));
        
    }
    
}
