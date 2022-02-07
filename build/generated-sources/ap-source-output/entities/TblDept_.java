package entities;

import entities.TblEmp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-07T15:25:46")
@StaticMetamodel(TblDept.class)
public class TblDept_ { 

    public static volatile SingularAttribute<TblDept, String> deptName;
    public static volatile SingularAttribute<TblDept, Integer> deptId;
    public static volatile CollectionAttribute<TblDept, TblEmp> tblEmpCollection;

}