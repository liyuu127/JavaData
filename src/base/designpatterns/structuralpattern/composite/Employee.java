package base.designpatterns.structuralpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2019/12/4 19:25
 * @description
 */
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;//²¿ÏÂ

    //constructor
    public Employee(String name, String dept, int salary, List<Employee> subordinates) {
        super();
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = subordinates;
        subordinates = new ArrayList<Employee>();
    }


    public Employee(String name, String dept, int salary) {
        super();
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<Employee>();
    }


    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String toString() {
        return "Employee :[ Name : " + name
                + ", dept : " + dept + ", salary :"
                + salary + " ]";
    }
}
