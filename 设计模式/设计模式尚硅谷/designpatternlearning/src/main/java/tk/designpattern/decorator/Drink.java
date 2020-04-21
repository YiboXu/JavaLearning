package tk.designpattern.decorator;

public abstract class Drink{
    private String description;

    public Drink() {
        this.description = "This is a Drink";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "description='" + description + '\'' +
                '}';
    }

    public abstract double cost();
}
