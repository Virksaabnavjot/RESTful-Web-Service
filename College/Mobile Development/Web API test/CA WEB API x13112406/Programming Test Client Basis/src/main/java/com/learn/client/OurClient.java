package com.learn.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

// Navjot Singh Virk, Student Number: x13112406
public class OurClient {
    
    private final String host;
    private final int port;
    private final String basePath;
    
    public static void main(String[] args) {
        OurClient client = new OurClient("localhost", 8080, "/api/students");
        System.out.println("Get all users response".toUpperCase());
        client.getStudents();
        System.out.println("Get an individual user response".toUpperCase());
        client.getStudent("Billo");
        System.out.println("Delete user 1 response".toUpperCase());
        client.deleteStudent(1);
        System.out.println("post a new user response".toUpperCase());
        client.updateStudent();
    }
    
    public String getURL(){
        return "http://localhost:" + port + "/api/students";
    }

    
    public OurClient(String host, int port, String basePath){
        this.host = host;
        this.port = port;
        this.basePath =basePath;
    }
    
    public void getStudents(){
        String getUrl = getURL();
        
        Client client = Client.create();
        WebResource target = client.resource(getUrl);

        ClientResponse response = target.get(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
    
    public void getStudent(String name){
        String getUrl = getURL()+"/"+name;
        
        Client client = Client.create();
        WebResource target = client.resource(getUrl);

        ClientResponse response = target.get(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }
    
    public void deleteStudent(Integer id){
        String getUrl = getURL()+"/"+id;
        
        Client client = Client.create();
        WebResource target = client.resource(getUrl);

        ClientResponse response = target.delete(ClientResponse.class);
        
        System.out.println(response.getEntity(String.class));
    }

    private void updateStudent() {
        String getUrl = getURL();
        
        Client client = Client.create();
        WebResource target = client.resource(getUrl);
        String input = "{ \"id\": 5, \"name\": \"Ajju Lyam\", \"age\": 33, \"college\": \"TCD\", \"birthday\": \"Dec 13, 2016 3:39:25 PM\", \"subjects\": [ \"Science\", \"Maths\", \"Astronomy\" ] }";

        ClientResponse response = target.post(ClientResponse.class, input);
        
        System.out.println(response.getEntity(String.class));
    }
}