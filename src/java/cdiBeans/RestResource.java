/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package cdiBeans;

import ejBeans.testBeanLocal;
import entities.TblDept;
import entities.TblEmp;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("rest")
public class RestResource {

    @Context
    private UriInfo context;
    
    @EJB testBeanLocal tbl;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }
    
    @POST
    @Path("/addDept/{dept_name}")
    public void insertDept(@PathParam("dept_name") String dept_name){
        tbl.insertDept(dept_name);
    }
    
    @PUT
    @Path("/updateDept/{dept_id}/{dept_name}")
    public void updateDept(@PathParam("dept_id") Integer dept_id, @PathParam("dept_name") String dept_name){
        tbl.updateDept(dept_id, dept_name);
    }
    @DELETE
    @Path("/deleteDept/{dept_id}")
    public void deleteDept(@PathParam("dept_id") Integer dept_id){
        tbl.deleteDept(dept_id);
    }
    @GET
    @Path("/viewDept")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblDept> viewDept(){
        return tbl.viewDept();
    }
//    
    @POST
    @Path("/addEmp/{emp_name}/{dept_id}/{salary}")
    public void insertEmp(@PathParam("emp_name") String emp_name, @PathParam("dept_id") Integer dept_id, @PathParam("salary") Integer salary){
        
    }
    @PUT
    @Path("/updateEmp/{emp_id}/{emp_name}/{dept_id}/{salary}")
    public void updateEmp(@PathParam("emp_id") Integer emp_id, @PathParam("emp_name") String emp_name, @PathParam("dept_id") Integer dept_id, @PathParam("salary") Integer salary){
        
    }
    @DELETE
    @Path("/deleteEmp/{emp_id}")
    public void deleteEmp(@PathParam("emp_id") Integer emp_id){
        
    }
    @GET
    @Path("/viewEmp")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblEmp> viewEmp(){
        return tbl.viewEmp();
    }
}
