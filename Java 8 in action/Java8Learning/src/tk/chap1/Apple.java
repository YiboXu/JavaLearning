package tk.chap1;

public class Apple {
    private Colour colour;
    private float weight;

    public Apple(Colour colour, float weight){
        this.colour = colour;
        this.weight = weight;
    }

    public Apple(){
        this.colour = Colour.RED;
        this.weight = 100;
    }

    public Colour getColour(){
        return colour;
    }

    public float getWeight(){
        return weight;
    }

    public boolean isGreenApple(){
        return colour.equals(Colour.GREEN);
    }

    public boolean isHeavyApple(){
        return weight > 500;
    }

    public String toString(){
        return colour+" apple with weight="+weight;
    }
}
