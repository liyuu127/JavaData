package base.designpatterns.structuralpattern.proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:44
 * @description
 */
public class Test {
    public static void main(String[] args){
        IDBQuery q = new DBQueryProxy(); //使用代里
        String request = q.request();//在真正使用时才创建真实对象
        System.out.println("request = " + request);
    }
}
