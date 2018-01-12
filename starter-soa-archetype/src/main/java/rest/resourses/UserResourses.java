package rest.resourses;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import domain.User;
import services.UserService;
@Path("users")
@RequestScoped
public class UserResourses {
	@EJB
	private UserService userService;

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response doAddUser(User user) {
		userService.addUser(user);
		return Response.status(Status.CREATED).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doFindAllUsers() {
		return Response.status(Status.FOUND).entity(userService.findAllUsers()).build();
	}

}
