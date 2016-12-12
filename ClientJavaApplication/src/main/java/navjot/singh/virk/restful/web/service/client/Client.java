package navjot.singh.virk.restful.web.service.client;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Navjot Singh Virk
 * Student number: x13112406
 * Time: Monday 3:39 AM 
 * Date: 12 Dec 2016 (Dublin, Ireland)
 */
public class Client {
    public static void main(String []args){
        ClientGui gui = new ClientGui();
        gui.setVisible(true);
        int port = 8080;
        String getURL = "http://localhost:" + port + "/api/navjot/";
        com.sun.jersey.api.client.Client client1 = com.sun.jersey.api.client.Client.create();
        WebResource target = client1.resource(getURL);
        ClientResponse response = target.type("application/json")
                    .get(ClientResponse.class);

            String output = response.getEntity(String.class);
            System.out.println("Hello" +output);
    }       
}
