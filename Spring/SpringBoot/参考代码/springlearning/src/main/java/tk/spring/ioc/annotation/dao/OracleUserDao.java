package tk.spring.ioc.annotation.dao;

public class OracleUserDao implements UserDao {
    private String firstName;
    private String lastName;
    private Integer id1;
    private Integer id2;
    private int id3;

    public OracleUserDao(String firstName, String lastName, Integer id1, Integer id2, int id3){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
    }

    @Override
    public void getUser(){
        System.out.println("Oracle get user: "+firstName+","+lastName+"-"+id1+"-"+id2+"-"+id3);
    }
}
