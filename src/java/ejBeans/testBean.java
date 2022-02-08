/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejBeans;

import entities.TblDept;
import entities.TblEmp;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Admin
 */
@Stateless
public class testBean implements testBeanLocal {
    
@PersistenceContext(unitName = "empWebPU")
EntityManager em;

    @Override
    public void insertDept(String dept_name){
        TblDept td = new TblDept();
        td.setDeptName(dept_name);
        em.persist(td);
    }
    
    @Override
    public void deleteDept(Integer dept_id) {
        TblDept td = em.find(TblDept.class, dept_id);
        em.remove(td);
    }

    @Override
    public void insertEmp(String emp_name, Integer dept_id, Integer salary) {
        TblEmp te = new TblEmp();
        te.setEmpName(emp_name);
        TblDept td = em.find(TblDept.class, dept_id);
        te.setDeptId(td);
        te.setSalary(salary);
        em.persist(te);
    }

    @Override
    public void deleteEmp(Integer emp_id) {
        TblEmp te = em.find(TblEmp.class, emp_id);
        em.remove(te);
    }

    @Override
    public void updateDept(Integer dept_id, String dept_name) {
        TblDept td = em.find(TblDept.class, dept_id);
        td.setDeptName(dept_name);
        em.merge(td);
    }
    
    @Override
    public String deptNameById(Integer deptId) {
        TblDept d = em.find(TblDept.class, deptId);
        return d.getDeptName();
    }
    
    @Override
    public void updateEmp(Integer emp_id, String emp_name, Integer dept_id, Integer salary) {
        TblEmp te = em.find(TblEmp.class, emp_id);
        te.setEmpName(emp_name);
        TblDept td = em.find(TblDept.class, dept_id);
        te.setDeptId(td);
        te.setSalary(salary);
        em.merge(te);
    }

    @Override
    public Collection<TblDept> viewDept() {
        List td = em.createNamedQuery("TblDept.findAll").getResultList();
        return td;
    }

    @Override
    public Collection<TblEmp> viewEmp() {
    List te = em.createNamedQuery("TblEmp.findAll").getResultList();
        return te;
    }

    @Override
    public String empNameById(Integer empId) {
        TblEmp te = em.find(TblEmp.class, empId);
        return te.getEmpName();
    }

    @Override
    public Integer empDeptById(Integer empId) {
        TblEmp te = em.find(TblEmp.class, empId);
        return te.getDeptId().getDeptId();
    }

    @Override
    public Integer empSalaryById(Integer empId) {
        TblEmp te = em.find(TblEmp.class, empId);
        return te.getSalary();
    }

    
    
}
