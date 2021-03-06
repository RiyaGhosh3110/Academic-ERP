package com.example.erp.controller;

import com.example.erp.bean.Employee;
import com.example.erp.service.EmployeeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("employee")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginEmployee(Employee employee) throws URISyntaxException {
        System.out.println("hello "+employee);
        Employee result = employeeService.employeeVerify(employee);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
}
