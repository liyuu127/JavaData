package base.designpatterns.structuralpattern.composite;

/**
 * @author liyu
 * @date 2019/12/5 10:50
 * @description 人力资源部（树叶节点）
 */
public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
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
        System.out.println(name + "   负责公司财务收支管理");
    }

    @Override
    public void remove(Company company) {

    }

}

