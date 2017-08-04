package com.github.evgdim.swagger.controller;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.swagger.model.HomeRequest;
import com.github.evgdim.swagger.model.HomeResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="HomeTag")
@Produces({"application/json", "application/xml"})
@Path("/")
public class HomeController {
	@POST
	@Path("home")
	@ApiOperation(value = "home", notes = "service description", response = HomeResponse.class)
	@ApiResponses({
		@ApiResponse(code=200, message="200 msg", response=HomeResponse.class),
		@ApiResponse(code=400, message="400 msg", response=HomeResponse.class),
		@ApiResponse(code=500, message="500 msg", response=HomeResponse.class)
	})
	@RequestMapping(value = "home", method=RequestMethod.POST)
	public ResponseEntity<HomeResponse> getOffering(@RequestBody HomeRequest request){
		return ResponseEntity.ok(new HomeResponse());
	}
	
	@PATCH
	@Path("people/{id}/decide")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "people/{id}/decide", 
				  notes = "Service Description", 
				  response = HomeResponse.class, 
				  produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
		@ApiResponse(code=200, message="200 msg", response=HomeResponse.class),
		@ApiResponse(code=400, message="400 msg", response=HomeResponse.class),
		@ApiResponse(code=500, message="500 msg", response=HomeResponse.class)
	})
	@RequestMapping(value = "people/{id}/decide", method=RequestMethod.PATCH, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HomeResponse> dof(@ApiParam(value = "The identifier of the Person.") @PathParam("id") @PathVariable Long id,
			@RequestBody HomeRequest request, 
			@ApiParam(value = "header description", required = true) 
			@HeaderParam("personal-num") @RequestHeader(value="personal-num") String num) {
		return ResponseEntity.ok(new HomeResponse());
	}
}
