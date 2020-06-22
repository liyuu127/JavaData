package base.designpatterns.structuralpattern.proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:38
 * @description DBQuery 是真实主题，负责实际的业务操作
 */
public class DBQuery implements IDBQuery {
    public DBQuery() {
        try {
            Thread.sleep(1000);//假设数据库连接等耗时操作
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }

}
