package introsde.assignment.soap.ws;
import introsde.assignment.soap.model.LifeStatus;
import introsde.assignment.soap.model.Person;

import java.util.List;

import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

    // Method #1 Get all the people
    @Override
     public List<Person> getPeople() {
         return Person.getAll();
     }

    // Method #2 Read person with id = 1
    @Override
    public Person readPerson(int id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getName());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

     // Method #3 Update person with id = 1 
    @Override
    public int updatePerson(Person person) {
        Person.updatePerson(person);
        return person.getIdPerson();
     }


     //Method #4 Create a new person
    @Override
    public int addPerson(Person person) {
        Person newPerson = Person.savePerson(person);
        return newPerson.getIdPerson();
     }

    
     //Method #5 Delete a person
    @Override
    public int deletePerson(int id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }

    // @Override
    // public int updatePersonHP(int id, LifeStatus hp) {
    //     LifeStatus ls = LifeStatus.getLifeStatusById(hp.getIdMeasure());
    //     if (ls.getPerson().getIdPerson() == id) {
    //         LifeStatus.updateLifeStatus(hp);
    //         return hp.getIdMeasure();
    //     } else {
    //         return -1;
    //     }
    // }

}