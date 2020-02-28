package tk.springmvc.model;


import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public Company(){}

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name="name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
