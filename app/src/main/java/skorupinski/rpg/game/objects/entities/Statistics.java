package skorupinski.rpg.game.objects.entities;

public class Statistics {
    
    public int hp;

    public float speed;

    public float armor;

    public Statistics() {
        hp = 10;
        speed = 10;
        armor = 20;
    }

    public Statistics hp(int hp) {
        this.hp = hp;
        return this;
    }

    public Statistics speed(float speed) {
        this.speed = speed;
        return this;
    }

    public Statistics armor(float armor) {
        this.armor = armor;
        return this;
    }
}
