package introsde.assignment.soap.ws;
import introsde.assignment.soap.model.LifeStatus;
import introsde.assignment.soap.model.Person;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
    

    // Method #1 Get all the people
    @WebMethod(operationName="getPeopleList")
    @WebResult(name="people") 
    public List<Person> getPeople();

    // Method #2 Read person with id = 1
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") int id);

    // Method #3 Update person with id = 1 
    @WebMethod(operationName="updatePerson")
    @WebResult(name="personId") 
    public int updatePerson(@WebParam(name="person") Person person);

     // Method #4 Create a new person
     @WebMethod(operationName="createPerson")
     @WebResult(name="personId") 
     public int addPerson(@WebParam(name="person") Person person);

    

    // @WebMethod(operationName="deletePerson")
    // @WebResult(name="personId") 
    // public int deletePerson(@WebParam(name="personId") int id);

    // @WebMethod(operationName="updatePersonHealthProfile")
    // @WebResult(name="hpId") 
    // public int updatePersonHP(@WebParam(name="personId") int id, @WebParam(name="healthProfile") LifeStatus hp);
}