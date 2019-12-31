package base.basictype;

/**
 * @author liyu
 * @date 2019/12/21 13:13
 * @description
 */
public class IntegerTest {
    public static void main(String[] args) {
//        demo1();

        demo2();
    }

    private static void demo2() {
        Integer a = new Integer(200);
        Integer b = new Integer(200);
        Integer c = 200;
        Integer d = 200;
        Integer e = Integer.valueOf(200);
        Integer f = Integer.valueOf(200);
        boolean b1 = a == b;
        boolean b2 = c == d;
        boolean b3 = e == f;
        boolean b4 = a == c;
        boolean b5 = a == e;
        boolean b6 = c == e;
        boolean equals1 = a.equals(b);
        boolean equals2 = c.equals(d);
        boolean equals3 = e.equals(f);
        boolean equals4 = a.equals(c);
        boolean equals5 = a.equals(e);
        boolean equals6 = c.equals(e);
        System.out.println("a==b = " + b1);
        System.out.println("c==d = " + b2);
        System.out.println("e==f = " + b3);
        System.out.println("a==c = " + b4);
        System.out.println("a==e = " + b5);
        System.out.println("c==e = " + b6);
        System.out.println("a.equals(b) = " + equals1);
        System.out.println("c.equals(d) = " + equals2);
        System.out.println("e.equals(f) = " + equals3);
        System.out.println("a.equals(c) = " + equals4);
        System.out.println("a.equals(e) = " + equals5);
        System.out.println("c.equals(e) = " + equals6);
    }

    private static void demo1() {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer c = 100;
        Integer d = 100;
        Integer e = Integer.valueOf(100);
        Integer f = Integer.valueOf(100);
        boolean b1 = a == b;
        boolean b2 = c == d;
        boolean b3 = e == f;
        boolean b4 = a == c;
        boolean b5 = a == e;
        boolean b6 = c == e;
        boolean equals1 = a.equals(b);
        boolean equals2 = c.equals(d);
        boolean equals3 = e.equals(f);
        boolean equals4 = a.equals(c);
        boolean equals5 = a.equals(e);
        boolean equals6 = c.equals(e);
        System.out.println("a==b = " + b1);
        System.out.println("c==d = " + b2);
        System.out.println("e==f = " + b3);
        System.out.println("a==c = " + b4);
        System.out.println("a==e = " + b5);
        System.out.println("c==e = " + b6);
        System.out.println("a.equals(b) = " + equals1);
        System.out.println("c.equals(d) = " + equals2);
        System.out.println("e.equals(f) = " + equals3);
        System.out.println("a.equals(c) = " + equals4);
        System.out.println("a.equals(e) = " + equals5);
        System.out.println("c.equals(e) = " + equals6);
    }
}
