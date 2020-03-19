package tk.spring.annotion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.spring.annotion.dao.PersonDao;
import tk.spring.annotion.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
