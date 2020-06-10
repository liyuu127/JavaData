package base.io.keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author liyu
 * @date 2020/5/9 14:49
 * @description
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            System.out.println("ÊäÈë = " + scanner.nextLine());
//        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String srt;
        while ((srt=bufferedReader.readLine())!=null){
            System.out.println("»Ø´ð£º" + srt.replace("Âð",""));
        }
    }
}
