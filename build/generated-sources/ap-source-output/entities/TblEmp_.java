package entities;

import entities.TblDept;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-08T16:51:48")
@StaticMetamodel(TblEmp.class)
public class TblEmp_ { 

    public static volatile SingularAttribute<TblEmp, Integer> empId;
    public static volatile SingularAttribute<TblEmp, String> empName;
    public static volatile SingularAttribute<TblEmp, TblDept> deptId;
    public static volatile SingularAttribute<TblEmp, Integer> salary;

}