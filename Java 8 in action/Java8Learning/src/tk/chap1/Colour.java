package tk.chap1;

public enum Colour {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    WHITE("White"),
    PINK("Pink"),
    BLACK("Black"),
    PURPLE("Purple");

    Colour(String value){
        this.value = value;
    }

    private String value;
    public String toString(){
        return value;
    }
}
