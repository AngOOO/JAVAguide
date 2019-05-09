package CombineFileUtil;


import java.io.*;

public class CombineFileUtil {
    //通过FileOutputStream(destFile,true)在新文件中按顺序追加fileA、fileB
    //将fileA和fileB合并为destFile存放在指定目录中
    public void CombineFile1(String FileA, String FileB, String DestFile) {
        File fileA = new File(FileA);
        File fileB = new File(FileB);
        File destFile = new File(DestFile);
        if (!destFile.exists()) {
            try {
                boolean result = destFile.createNewFile();
                System.out.println("destFile创建：" + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream inA = null;
            InputStream inB = null;
            OutputStream out = null;
            if (fileA.exists() && fileB.exists() && destFile.exists()) {
                try {
                    inA = new FileInputStream(fileA);
                    inB = new FileInputStream(fileB);
                    out = new FileOutputStream(destFile, true);
                    int len = -1;
                    byte[] msg = new byte[3];
                    while ((len = inA.read(msg)) != -1) {
                        out.write(msg, 0, len);
                    }
                    while ((len = inB.read(msg)) != -1) {
                        out.write(msg, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        inA.close();
                        inB.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("DestFile已存在！请重新选择目标文件！");
        }
    }

    public void CombineFile2(String FileA, String FileB, String DestFile) {
        File fileA = new File(FileA);
        File fileB = new File(FileB);
        File destFile = new File(DestFile);
        if (!destFile.exists()) {
            FileInputStream inA = null;
            FileInputStream inB = null;
            ByteArrayOutputStream out = null;
            FileOutputStream destFileOut = null;
            try {
                inA = new FileInputStream(fileA);
                inB = new FileInputStream(fileB);
                out = new ByteArrayOutputStream();
                destFileOut = new FileOutputStream(destFile);
                byte[] msg = new byte[3];
                int len = -1;
                while ((len = inA.read(msg)) != -1) {
                    out.write(msg, 0, len);
                }
                while ((len = inB.read(msg)) != -1) {
                    out.write(msg, 0, len);
                }
                destFileOut.write(out.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inA.close();
                    inB.close();
                    out.close();
                    destFileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("目标文件已存在，请重新选择！");
        }
    }
}
