package tk.designpattern.uml;

public class PersonServiceBean extends DaoSupport{
    private PersonDao personDao;
    private Department department = new Department();

    public void save(Person person){}
    public IDCard getIDCard(Integer id){return null;}
    public void modify(){
    }
}
