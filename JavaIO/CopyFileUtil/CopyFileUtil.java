package CopyFileUtil;

import java.io.*;

public class CopyFileUtil {

    public void CopyFile(String sourcePath, String destPath) {
        //判断源文件是否存在
        CheckSourceFileExist(sourcePath);
        //判断目的文件父目录是否存在
        CheckDestFileParentExistOrCreate(destPath);
        //拷贝文件
        boolean result = Copy(sourcePath, destPath);
        System.out.println("copy file " + result);
    }

    private void CheckSourceFileExist(String sourcePath) {
        //判断源文件是否存在
        File file = new File(sourcePath);
        if (!file.exists()) {
            System.out.println("source file doesn't exist!");
        }
    }

    private void CheckDestFileParentExistOrCreate(String destPath) {
        //判断目的文件父目录是否存在
        File file = new File(destPath);
        if (!file.getParentFile().exists()) {
            boolean result = file.getParentFile().mkdirs();
            System.out.println("create parent file " + result);
        }
    }

    private boolean Copy(String sourcePath, String destPath) {
        //拷贝文件：1、字节输入流读取源文件内容
        //        2、字节输出流写入目标文件
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destFile);
            byte[] msg = new byte[3];
            int len = -1;
            while ((len = in.read(msg)) != -1) {
                out.write(msg,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return destFile.exists();
    }
}
