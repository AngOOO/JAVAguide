package TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executors;

public class TextFile {
    public static void TextFile1() {
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text.txt");
        boolean result = false;
        try {
            result = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result) {
            System.out.println("创建文件成功。");
        } else {
            System.out.println("创建文件失败。");
        }
    }

    public static void TextFile2() {
        File file = new File("C:" + File.separator + "Users" + File.separator +
                "ANGOOO" + File.separator + "Documents" + File.separator + "javaidea" + File.separator +
                "JavaIO" + File.separator + "src" + File.separator + "Text.txt");
        if (file.exists()) {
            System.out.println("文件删除：" + file.delete());
        } else {
            try {
                System.out.println("创建文件：" + file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void TextFile3() {
        File file = new File("C:" + File.separator + "Users" + File.separator +
                "ANGOOO" + File.separator + "Documents" + File.separator + "javaidea" + File.separator +
                "JavaIO" + File.separator + "src" + File.separator + "Text.txt");
        System.out.println("父路径：" + file.getParent());
        System.out.println("父文件：" + file.getParentFile());
        System.out.println("判断是否为目录：" + file.isDirectory());
        System.out.println("判断是否为目录：" + file.getParentFile().isDirectory());
        System.out.println("判断是否为文件：" + file.isFile());
        System.out.println("文件大小：" + file.length() + "字节");
        System.out.println("文件最后一次修改时间：" + new Date(file.lastModified()));

        String path = "C:" + File.separator + "Users" + File.separator +
                "ANGOOO" + File.separator + "Documents" + File.separator + "javaidea" + File.separator +
                "JavaIO" + File.separator + "src" + File.separator + "Text";
        File directory = new File(path);
        System.out.println("创建父目录：" + directory.mkdir());
        //mkdir  (如果父目录不存在，创建失败)
        //mkdirs (如果父目录不存在，一并创建)
    }

    public static void TextFile4() {
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea");
        File[] filesList = file.listFiles();
        if (filesList != null) {
            for (File f : filesList) {
                System.out.println(f);
            }
        }
    }

    public static void TextFile5() {
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea");
        /*int level = 0;
        System.out.println(file.getName());
        listFile(file, level + 1);*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                int level = 0;
                System.out.println(file.getName());
                listFile(file, level + 1);
            }
        }).start();
    }

    public static String levelSymbol(int level) {
        StringBuilder sb = new StringBuilder("┗━");
        for (int i = 0; i < level; i++) {
            sb.append("━");
        }
        return sb.toString();
    }

    public static void listFile(File file, int level) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(levelSymbol(level) + f.getName());
                    if (f.isDirectory()) {
                        listFile(f, level + 1);
                    }
                }
            }
        } else {
            System.out.println(levelSymbol(level) + file.getName());
        }
    }

    public static void main(String[] args) {
        TextFile5();
    }
}
