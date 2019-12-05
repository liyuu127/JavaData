package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/5 9:14
 * @description 财务部（树叶节点）
 */
public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void display(int depth) {
        System.out.println("第 " + depth + " 层的机构名为： " + name);
    }

    @Override
    public void lineofDuty() {
        System.out.println(name + "    负责员工招聘管理培训");
    }

    @Override
    public void remove(Company company) {

    }

}

