package CopyFileUtil;

public class Text {
    public static void main(String[] args) {
        String sourcePath = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt";
        String destPath = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text2.txt";
        CopyFileUtil copyFileUtil = new CopyFileUtil();
        copyFileUtil.CopyFile(sourcePath, destPath);
    }
}
