package com.mycompany.mavenproject1;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Student Number: X13112406
 * Name: Navjot Singh Virk
 * 
 */
@Path("/students")
public class StudentsService {

    /**
     * this method responds to a GET request for the resource located at '/students'
     * 
     * @return A HTTP Response object which has as it's entity a JSON representation of the resource
     * INVOKE via curl -vi -X GET http://localhost:8080/api/students
     */
    @GET
    public Response getStudents() {
        // retreieve a List of Student objects
        List<Student> list = getStudentList();
        // instantiante a Gson object
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        // convert the list to a JSON representation
        String message = g.toJson(list);
        // return a response with the HTTP status 200, and the entity included
        return Response.status(200).entity(message).build();
    }

    /**
     * Returns a map of Students
     * @return a map of students
     */
    private Map<Integer, Student> getUserMap() {
        Map<Integer, Student> map = new HashMap<>();
        // the key is the id and the value is the Student Object
        
        map.put(1, new Student(1, "Navjot Singh", 21, "NCI", new Date(), getSubjects()));
        map.put(2, new Student(2, "Johnny", 23, "DIT", new Date(), getSubjects()));
        map.put(3, new Student(3, "Philip Genius", 45, "UCD", new Date(), getSubjects()));
        map.put(4, new Student(4, "Billo", 21, "NCI", new Date(), getSubjects()));
        map.put(5,new Student(5, "Ajju Lyam", 33, "TCD", new Date(), getSubjects()));

        return map;
    }

    /**
     * Returns a list of Subjects
     * @return a list of subjects
     */
    private List<String> getSubjects(){
        List<String> subjects = new ArrayList<>();
        subjects.add("Science");
        subjects.add("Maths");
        subjects.add("Astronomy");
        
        return subjects;
    }
    
    
    /**
     * Returns a list of Students
     * @return a list of students
     */
    private List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Navjot Singh", 21, "NCI", new Date(), getSubjects()));
        students.add(new Student(2, "Johnny", 23, "DIT", new Date(), getSubjects()));
        students.add(new Student(3, "Philip Genius", 45, "UCD", new Date(), getSubjects()));
        students.add(new Student(4, "Billo", 21, "NCI", new Date(), getSubjects()));
        students.add(new Student(5, "Ajju Lyam", 33, "TCD", new Date(), getSubjects()));
        
        return students;
    }

    /** 
     * responds to a delete request
     * @param id the id of the use
     * @return a response indicating what happened with the request, was the user found and deleted?
     * INVOKE  curl -vi -X DELETE http://localhost:8080/api/students/12
     */
    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") Integer id) {
        // this method could be extended to actually check if the student is in the list and return a sensible error code if the student is not found
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("request_status", "true");
        Gson g = new Gson();
        String message = g.toJson(errorMap);
        return Response.status(200).entity(message).build();
    }

    /** 
     * Responds to a GET request for a specific student by name.g. /students/name
     * @param name the name of the student
     * @return 
     * INVOKE curl -vi -X GET http://localhost:8080/api/students/Johnny get a 200 response
     * INVOKE curl -vi -X GET http://localhost:8080/api/students/Johnny get a 404
     */
    @GET
    @Path("/{name}")
    public Response getStudent(@PathParam("name") String name) {
        List<Student> list = getStudentList();
        Student student = null;
        for(int i = 0; i <= list.size(); i++){
        if(list.get(i).getName() == name){
            student  = list.get(i);
            
            
        }
       }
      
        // if the student does not exist
        if (student == null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("request_status", "failed");
            Gson g = new Gson();
            String message = g.toJson(errorMap);
            // return a 404
            return Response.status(404).entity(message).build();
        }
        
        // otherwise we convert and return the user we have searched for
        Gson g = new Gson();
        String message = g.toJson(student);

        return Response.status(200).entity(message).build();
    }
        
    
    
  

    /**
     * Handles a post request
     * @param requestBody JSON String which is converted to a Java Object of type Student
     * @return 
     * INVOKE curl -vi -X POST http://localhost:8080/api/students/ -d "{"id":6,"name": "Navjot Singh", "age": 21, "college": "NCI", "birthday": "Dec 13, 2016 3:39:25 PM", "subjects": [ "Science", "Maths", "Astronomy" ] }"
     **/
    @POST
    public Response handlePost(String requestBody) {
        System.out.println(requestBody);
        Student u = updateStudentToDatabase(requestBody);

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", "success");
        jsonMap.put("resource-uri", "/students/"+u.getID()); // assume 12 is the ID of the student we pretended to create
        Gson gson = new Gson();

        return Response.status(200).entity(gson.toJson(jsonMap)).build();
    }

    private Student updateStudentToDatabase(String requestBody) {
        Gson gson = new Gson();

        Student u = gson.fromJson(requestBody, Student.class);
        return u; // lie and say we added the user to the database
    }

}