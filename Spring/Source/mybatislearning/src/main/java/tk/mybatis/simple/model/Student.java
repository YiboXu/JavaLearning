package tk.mybatis.simple.model;

public class Student {
    private int id;
    private String name;
    private Teacher teacher;

    public int getId(){return id;}
    public String getName(){return name;}
    public Teacher getTeacher(){return teacher;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setTeacher(Teacher teacher){this.teacher = teacher;}

    public String toString(){
        return "Student: "+id+"-"+name+", teacher: "+teacher;
    }
}
