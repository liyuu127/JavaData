package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/4 19:27
 * @description
 */
public class CompositePatternDemo {
    public static void main(String[] args) {

//        demo1();
        demo2();

    }

    private static void demo2() {
        //一个总公司
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        //三个子公司
        ConcreteCompany com1 = new ConcreteCompany("广州分公司");
        com1.add(new HRDepartment("广州分公司人力资源部"));
        com1.add(new FinanceDepartment("广州分公司财务部"));
        root.add(com1);

        ConcreteCompany com2 = new ConcreteCompany("杭州分公司");
        com2.add(new HRDepartment("杭州分公司人力资源部"));
        com2.add(new FinanceDepartment("杭州分公司财务部"));
        root.add(com2);

        ConcreteCompany com3 = new ConcreteCompany("深圳分公司");
        com3.add(new HRDepartment("深圳分公司人力资源部"));
        com3.add(new FinanceDepartment("深圳分公司财务部"));
        root.add(com3);

        System.out.println("-------公司结构图--------");
        root.display(1);
        System.out.println("----------各部门职责----------");
        root.lineofDuty();
    }

    private static void demo1() {
        Employee CEO = new Employee("John", "CEO", 30000);
        Employee headSales = new Employee("Robert", "Head Sales", 20000);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);
        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印该组织的所有员工
        System.out.println("-------------------公司员工情况----------------------");
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            //打印CEO的直属一级部下
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                //打印CEO的二级部下
                System.out.println(employee);
            }
        }
    }

}
