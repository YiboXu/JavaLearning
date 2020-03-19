package tk.spring.annotion.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.spring.annotion.dao.PersonDao;
import tk.spring.annotion.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public String getPersonInfo() {
        return personDao.getPerson().toString();
    }
}
