package base.io.path;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyu
 * @date 2019/11/26 16:40
 * @description https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247484947&amp;idx=1&amp;sn=5b3075b83724f5d510e4220488cc1d16&source=41#wechat_redirect
 */
public class PathDemo {


    public static void main(String[] args) throws IOException {
        //����һ��Path
//        demo1();

        //File��Path֮���ת����File��URI֮���ת��
//        demo2();

//        ��������Path���ļ�ϵͳ���Ƿ����
//        demo3();

        //�����ļ�/�ļ���
//        ɾ���ļ���Ŀ¼
//        demo4();

//        �Ƴ�������
//        demo5();

        //�ļ�����
//        demo6();

        //��ȡ�ļ�����
//        demo7();

        //�����ļ���
//        demo8();

        //���������ļ�Ŀ¼
//        demo9();
        fileReadAndWrite();
        return;

    }

    private static void fileReadAndWrite() throws IOException {
        var pathPrefix = "C:\\Users\\haylion\\Downloads\\0923-01-safeControl\\";
        var path = pathPrefix + "metro-safeControl-info-2021-09-22-0.log";
        var outPath = pathPrefix + "tag.log";
        var fr = new FileReader(path);
        var bf = new BufferedReader(fr);
        HashSet<Integer> tagSet = new HashSet<>();
        AtomicInteger preTag = new AtomicInteger(-1);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath));
        bf.lines()
                .filter(s -> s.contains("<<<<< ip"))
                .map(s -> s.substring(0, 23) + "---" + s.substring(s.indexOf("hex")))
//                .filter(s -> {
//                    int tag = Integer.valueOf(s.substring(38, 42), 16);
//                    if(preTag.get() ==tag){
//                        return false;
//                    }else {
//                        preTag.set(tag);
//                        return true;
//                    }
//                })
//                .filter(s -> {
//                    Integer tag = Integer.valueOf(s.substring(38, 42), 16);
//                    if (tagSet.contains(tag)) {
//                        return false;
//                    } else {
//                        tagSet.add(tag);
//                        return true;
//                    }
//                })
                .map(s -> {
                    String hex = s.substring(38, 42);
                    return s + "  " + hex + "  " + Integer.valueOf(hex, 16).toString();
                })
                .forEach(s -> {
                    try {
                        bufferedWriter.write(s);
                        bufferedWriter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bufferedWriter.flush();
        bufferedWriter.close();
        bf.close();
    }

    private static void demo9() {
        Path src = Paths.get("src");
        List pathLinkList = new LinkedList<Path>();
        try {
            Files.walkFileTree(src, new FindJavaVistor(pathLinkList));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pathLinkList.forEach(e -> System.out.println("e = " + e));
    }

    private static class FindJavaVistor extends SimpleFileVisitor<Path> {
        private List<Path> result;

        public FindJavaVistor(List<Path> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                result.add(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    private static void demo8() {
        Path path = Paths.get("resources/test");
        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            for (Path path1 : path) {
                System.out.println("path1 = " + path1.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo7() {
        Path path = Paths.get("resources/pathTest2.txt");
        try {
            System.out.println(Files.getLastModifiedTime(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Files.size(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isDirectory(path));
        try {
            System.out.println(Files.readAttributes(path, "*"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo6() {
        //        ��һ���ļ���һ����ַ���Ƶ���һ��λ��
        Path path = Paths.get("resources/test");
        boolean exists = Files.exists(path);
        System.out.println("exists = " + exists);
        if (!exists) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path sourcePath = Paths.get("resources/pathTest2.txt");
        Path destinationPath = Paths.get("resources/test/pathTest2Copy.txt");
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);//ǿ�Ƹ����Ѿ����ڵ�Ŀ���ļ�
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo5() {
        //?	normalize() : ����һ��·������·������������Ԫ�ص�������
        //?	toRealPath() : �ں���toAbsolutePath()������normalize()����

        //.��ʾ���ǵ�ǰĿ¼
        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());//���C:\Users\Administrator\NIODemo\.
        Path currentDir2 = Paths.get(".\\NIODemo.iml");
        System.out.println("ԭʼ·����ʽ��" + currentDir2.toAbsolutePath());
        System.out.println("ִ��normalize��������֮��" + currentDir2.toAbsolutePath().normalize());
        try {
            System.out.println("ִ��toRealPath()����֮��" + currentDir2.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //..��ʾ��Ŀ¼����˵����һ��Ŀ¼��
        Path currentDir3 = Paths.get("..");
        System.out.println("ԭʼ·����ʽ��" + currentDir3.toAbsolutePath());
        System.out.println("ִ��normalize��������֮��" + currentDir3.toAbsolutePath().normalize());
        try {
            System.out.println("ִ��toRealPath()����֮��" + currentDir3.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo4() {
        //�����ļ�
        Path absolutePath = Paths.get("D:\\javaWorkplace\\gitDesktopWorkplace\\JavaData\\resources\\pathTest3.txt");
        System.out.println("Files.exists(absolutePath = " + Files.exists(absolutePath));
        if (!Files.exists(absolutePath)) {
            try {
                Files.createFile(absolutePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //�����ļ���
        Path path = Paths.get("resources/test");
        boolean exists = Files.exists(path);
        System.out.println("exists = " + exists);
        if (!exists) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //ɾ���ļ���Ŀ¼
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo3() {
        //��������Path���ļ�ϵͳ���Ƿ����
        Path relativePath = Paths.get("resources/pathTest1.txt");
        boolean exists = Files.exists(relativePath, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});//��ʾ���ʱ���������������ļ�
        System.out.println("exists = " + exists);
    }

    private static void demo2() {
        //        File��Path֮���ת����File��URI֮���ת��
        File file = new File("D:\\javaWorkplace\\gitDesktopWorkplace\\JavaData\\resources\\pathTest3.txt");
        Path path = file.toPath();
        System.out.println("path = " + path);
        File file1 = path.toFile();
        System.out.println("file1 = " + file1);
        URI uri = path.toUri();
        System.out.println("uri = " + uri);
    }

    private static void demo1() {
        //ʹ�þ���·��
        Path absolutePath = Paths.get("D:\\javaWorkplace\\gitDesktopWorkplace\\JavaData\\resources\\pathTest1.txt");
        Path absolutePath2 = FileSystems.getDefault().getPath("D:\\javaWorkplace\\gitDesktopWorkplace\\JavaData\\resources\\pathTest1.txt");
        //���·�� ע�ⲻ��/resources/pathTest1.txt
        Path relativePath = Paths.get("resources/pathTest1.txt");
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("relativePath = " + relativePath);
    }
}
