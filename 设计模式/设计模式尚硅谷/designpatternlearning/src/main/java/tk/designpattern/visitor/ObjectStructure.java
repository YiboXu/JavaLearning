package tk.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Person> personList = new ArrayList<>();

    public void attach(Person person){
        personList.add(person);
    }

    public void detach(Person person){
        personList.remove(person);
    }

    public void action(Action visitor){
        personList.stream().forEach(person -> person.accept(visitor));
    }
}
