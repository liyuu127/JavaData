package base.io;

import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author liyu
 * date 2020/9/14 11:11
 * description 分流器测试
 * TeeOutputStream拆分OutputStream。它以unix'tee'命令命名。它允许流分支为两个流。
 */
public class TeeStreamTest {
    private static final String SAMPLE = "Welcome to CodingDict. Simply Easy Learning.";

    public static void main(String[] args) {
        try {
            usingTeeInputStream();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void usingTeeInputStream() throws IOException {
        TeeInputStream teeInputStream = null;
        TeeOutputStream teeOutputStream = null;

        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(SAMPLE.getBytes("US-ASCII"));
            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();

            teeOutputStream = new TeeOutputStream(outputStream1, outputStream2);
            teeInputStream = new TeeInputStream(inputStream, teeOutputStream, true);
            teeInputStream.read(new byte[SAMPLE.length()]);

            System.out.println("Output stream 1: " + outputStream1.toString());
            System.out.println("Output stream 2: " + outputStream2.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //teeIn.close() closes teeIn and teeOut which in turn closes the out1 and out2.
            try {
                teeInputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
