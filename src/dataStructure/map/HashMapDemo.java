package dataStructure.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        // �������ظ���ֵ�����ظ�
        map.put("san", "����");
        map.put("si", "����");
        map.put("wu", "����");
        map.put("wang", "����");
        map.put("wang", "����2");// ����������
        map.put("lao", "����");
        System.out.println("-------ֱ�����hashmap:-------");
        System.out.println(map);
        /**
         * ����HashMap
         */
        // 1.��ȡMap�е����м�
        System.out.println("-------foreach��ȡMap�����еļ�:------");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + "  ");
        }
        System.out.println();//����
        // 2.��ȡMap������ֵ
        System.out.println("-------foreach��ȡMap�����е�ֵ:------");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.print(value + "  ");
        }
        System.out.println();//����
        // 3.�õ�key��ֵ��ͬʱ�õ�key����Ӧ��ֵ
        System.out.println("-------�õ�key��ֵ��ͬʱ�õ�key����Ӧ��ֵ:-------");
        Set<String> keys2 = map.keySet();
        for (String key : keys2) {
            System.out.print(key + "��" + map.get(key) + "   ");

        }
        /**
         * ����һ�ֲ����õı�����ʽ
         */
        // ���ҵ���put(key,value)������ʱ�����Ȼ��key��value��װ��
        // Entry�����̬�ڲ�������У���Entry���������ӵ������У������������ȡ
        // map�е����м�ֵ�ԣ�����ֻҪ��ȡ�����е�����Entry���󣬽�����
        // ����Entry�����е�getKey()��getValue()�������ܻ�ȡ��ֵ����
        Set<java.util.Map.Entry<String, String>> entrys = map.entrySet();
        for (java.util.Map.Entry<String, String> entry : entrys) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        /**
         * HashMap�������÷���
         */
        System.out.println("after map.size()��" + map.size());
        System.out.println("after map.isEmpty()��" + map.isEmpty());
        System.out.println(map.remove("san"));
        System.out.println("after map.remove()��" + map);
        System.out.println("after map.get(si)��" + map.get("si"));
        System.out.println("after map.containsKey(si)��" + map.containsKey("si"));
        System.out.println("after containsValue(����)��" + map.containsValue("����"));
        System.out.println(map.replace("si", "����2"));
        System.out.println("after map.replace(si, ����2):" + map);
    }

}