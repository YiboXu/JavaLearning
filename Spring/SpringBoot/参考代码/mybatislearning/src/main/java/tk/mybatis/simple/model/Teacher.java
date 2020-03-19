package tk.mybatis.simple.model;

public class Teacher {
    private int id;
    private String name;

    public int getId(){return id;}
    public String getName(){return name;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}

    public String toString(){
        return "Teacher: "+id+"-"+name;
    }
}
