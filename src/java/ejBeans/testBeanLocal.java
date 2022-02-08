/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejBeans;

import entities.TblDept;
import entities.TblEmp;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface testBeanLocal {

    public void insertDept(String dept_name);
    public void updateDept(Integer dept_id, String dept_name);
    public void deleteDept(Integer dept_id);
    public Collection<TblDept> viewDept();
    public String deptNameById(Integer deptId);
    
    public void insertEmp(String emp_name, Integer dept_id, Integer salary);
    public void updateEmp(Integer emp_id, String emp_name, Integer dept_id, Integer salary);
    public void deleteEmp(Integer emp_id);
    public String empNameById(Integer empId);
    public Integer empDeptById(Integer empId);
    public Integer empSalaryById(Integer empId);
    public Collection<TblEmp> viewEmp();
}
