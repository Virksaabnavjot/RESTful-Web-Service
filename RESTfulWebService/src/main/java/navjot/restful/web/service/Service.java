
package navjot.restful.web.service;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Navjot Singh Virk
 * Student Number: x13112406
 * Time: Monday 3:07 AM
 * Data: 12 December 2016
 */

@Path("navjot")
@Produces("application/json")
public class Service {
    public static final String name = "Navjot Singh Virk";
    @GET
    @Path("/")
    @Produces("application/json")
    public Response test(@Context UriInfo info){
        List <String> list = new ArrayList<>();
        String text = "Welcome, Your Web RESTful Web Service is UP and Running.Have a Good Day!!!!";
        list.add(name);
        list.add(text);
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(list)).build();
    }
}
    

    
    