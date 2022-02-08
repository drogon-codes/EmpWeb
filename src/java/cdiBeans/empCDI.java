/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import ejBeans.testBeanLocal;
import entities.TblDept;
import entities.TblEmp;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "empCDI")
@SessionScoped
@Dependent
public class empCDI {
    
    @EJB testBeanLocal tb;
    
    String empName;
    Integer deptId, salary, uEmpId=0;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
    public void insertEmp()
    {
        if(uEmpId == 0){
            this.tb.insertEmp(empName, deptId, salary);
            empName=null; 
            deptId=null; 
            salary=null;
        }
        else
        {
            this.tb.updateEmp(uEmpId, empName, deptId, salary);
            empName=null; 
            deptId=null; 
            salary=null;
        }
    }
    
    public Collection<TblEmp> viewEmp(){
        return this.tb.viewEmp();
    }
    
    public void deleteEmp(Integer empId){
        this.tb.deleteEmp(empId);
    }
    
    public Collection<TblDept> allDept(){
        return this.tb.viewDept();
    }
    
    public void updateEmp(Integer empId){
        uEmpId = empId;
        empName = this.tb.empNameById(empId);
        deptId = this.tb.empDeptById(empId);
        salary = this.tb.empSalaryById(empId);
    }
    public empCDI() {
    }
    
}
