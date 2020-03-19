package tk.spring.annotion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tk.spring.annotion.service.Impl.PersonServiceImpl;
import tk.spring.annotion.service.PersonService;

@Controller("personController")
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void printPersonInfo(){
        logger.info(personService.getPersonInfo());
    }
}
