package demo.spring.rest.number.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Class to route all rest-request for number to words operations.
 */
@Path("/v1/numbertowords")
public interface INumberToWordsRS {
	
	/**
	 * Rest Service to convert numbers to words.
	 * 
	 * @param header : header should have mdn, esn, user-agent etc..
	 * @param userDetail : Bean with all user-details
	 * @return returns rest-response[json ].
	 */
	@GET
	@Path("/convert/{number}")
	@Produces({"application/json"})
	public Response convertNumberToWord(@PathParam("number") long number);

	
}
