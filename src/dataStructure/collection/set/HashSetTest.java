package dataStructure.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.System.out;

public class HashSetTest {
    public static void main(String[] agrs){
//        baseOprateDemo();

        hashCodeAndEquals();

    }

    public static void baseOprateDemo() {
        //创建HashSet集合：
        Set<String> hashSet = new HashSet<String>();
        out.println("HashSet初始容量大小："+hashSet.size());

        //元素添加：
        hashSet.add("my");
        hashSet.add("name");
        hashSet.add("is");
        hashSet.add("jiaboyan");
        hashSet.add(",");
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("!");
        out.println("HashSet容量大小："+hashSet.size());

        //迭代器遍历：
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            out.println(str);
        }
        //增强for循环
        for(String str:hashSet){
            if("jiaboyan".equals(str)){
                out.println("你就是我想要的元素:"+str);
            }
            out.println(str);
        }

        //元素删除：
        hashSet.remove("jiaboyan");
        out.println("HashSet元素大小：" + hashSet.size());
        hashSet.clear();
        out.println("HashSet元素大小：" + hashSet.size());

        //集合判断：
        boolean isEmpty = hashSet.isEmpty();
        out.println("HashSet是否为空：" + isEmpty);
        boolean isContains = hashSet.contains("hello");
        out.println("HashSet是否包含hello：" + isContains);
    }

    public static void hashCodeAndEquals(){
        //第一个 Set集合：
        Set<String> set1 = new HashSet<String>();
        String str1 = new String("jiaboyan");
        String str2 = new String("jiaboyan");
        set1.add(str1);
        set1.add(str2);
        out.println("长度："+set1.size()+",内容为："+set1);

        //第二个 Set集合：
        Set<App> set2 = new HashSet<App>();
        App app1 = new App();
        app1.setName("jiaboyan");

        App app2 = new App();
        app2.setName("jiaboyan");

        set2.add(app1);
        set2.add(app2);
        out.println("长度："+set2.size()+",内容为："+set2);

        //第三个 Set集合：
        Set<App> set3 = new HashSet<App>();
        App app3 = new App();
        app3.setName("jiaboyan");
        set3.add(app3);
        set3.add(app3);
        out.println("长度："+set3.size()+",内容为："+set3);
    }
}
