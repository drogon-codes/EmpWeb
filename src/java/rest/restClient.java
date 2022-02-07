/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RestResource [rest]<br>
 * USAGE:
 * <pre>
 *        restClient client = new restClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Admin
 */
public class restClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/empWeb/webresources";

    public restClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void insertDept(String dept_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addDept/{0}", new Object[]{dept_name})).request().post(null);
    }

    public <T> T viewEmp(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("viewEmp");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteEmp(String emp_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteEmp/{0}", new Object[]{emp_id})).request().delete();
    }

    public <T> T viewDept(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("viewDept");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteDept(String dept_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteDept/{0}", new Object[]{dept_id})).request().delete();
    }

    public void insertEmp(String emp_name, String dept_id, String salary) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addEmp/{0}/{1}/{2}", new Object[]{emp_name, dept_id, salary})).request().post(null);
    }

    public void updateDept(String dept_id, String dept_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDept/{0}/{1}", new Object[]{dept_id, dept_name})).request().put(null);
    }

    public void updateEmp(String emp_id, String emp_name, String dept_id, String salary) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateEmp/{0}/{1}/{2}/{3}", new Object[]{emp_id, emp_name, dept_id, salary})).request().put(null);
    }

    public void close() {
        client.close();
    }
    
}
