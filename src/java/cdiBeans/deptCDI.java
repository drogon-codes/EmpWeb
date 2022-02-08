/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import ejBeans.testBeanLocal;
import entities.TblDept;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Admin
 */
//@Named(value = "deptCDI")
@ManagedBean(name = "deptCDI")
@SessionScoped
@Dependent
public class deptCDI {
   @EJB testBeanLocal tl;
   String deptName;
   Integer uDeptId=0;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public void insertDept(){
        if(uDeptId==0)
        {
            this.tl.insertDept(deptName);
            deptName = null;
        }
        else
        {
            this.tl.updateDept(uDeptId, deptName);
        }
        
    }
    
    public Collection<TblDept> viewDept(){
       return this.tl.viewDept();
    }
    
    public void deleteDept(Integer deptId){
        this.tl.deleteDept(deptId);
    }
    
    public void updateDept(Integer deptId){
        uDeptId = deptId;
        deptName = this.tl.deptNameById(deptId);
//        this.tl.updateDept(deptId, deptName);
    }
    
    public deptCDI() {
    }
    
}
