package skorupinski.rpg.core.math;

public class Range {
    
    private float lower;

    private float upper;

    public Range(float lower, float upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public boolean contains(float number) {
        if(lower > upper) {
            return number >= lower || number < upper;
        } else {
            return number >= lower && number < upper;
        }
    }

    public float getLower() {
        return lower;
    }

    public float getUpper() {
        return upper;
    }

    public float getMid() {
        return (lower + upper) / 2;
    }
    
}