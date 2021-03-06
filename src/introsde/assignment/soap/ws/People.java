package introsde.assignment.soap.ws;
import introsde.assignment.soap.model.*;


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


     //Method #5 Delete a person
    @WebMethod(operationName="deletePerson")
    @WebResult(name="deletedPersonId") 
    public int deletePerson(@WebParam(name="personId") int id);

    //Method #6 Read person history
    @WebMethod(operationName="readPersonHistory")
    @WebResult(name="healthMeasure") 
    public List<HealthMeasureHistory> readPersonHistory(@WebParam(name="personId") int id,  @WebParam(name="measureType") String measure);

    //Method #7 Read all measure types
    @WebMethod(operationName="readMeasureTypes")
    @WebResult(name="measureTypes") 
    public List<MeasureDefinition> readMeasureTypes();

    //Method #8 Read value of measure type history mid=1 
    @WebMethod(operationName="readMeasureHistoryId")
    @WebResult(name="measures") 
    public HealthMeasureHistory readMeasureHistoryId(@WebParam(name="historyMeasureId") int id);

    //Method #9 
    @WebMethod(operationName="updatePersonHealthMeasureHistory")
    @WebResult(name="healthMeasureHistoryObject") 
    public HealthMeasureHistory createNewMeasure(@WebParam(name="idPerson") int id, 
        @WebParam(name="measureType") String measureType, @WebParam(name="newHealthMeasureHistory") HealthMeasureHistory newHealthMeasureHistory);
    
    // @WebMethod(operationName="updatePersonHealthProfile")
    // @WebResult(name="hpId") 
    // public int updatePersonHP(@WebParam(name="personId") int id, @WebParam(name="healthProfile") LifeStatus hp);
}