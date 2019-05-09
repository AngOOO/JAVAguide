package CombineFileUtil;

public class Text {
    public static void main(String[] args) {
        String fileA = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt";
        String fileB = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text2.txt";
        String deatFile = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text3.txt";
        CombineFileUtil combineFileUtil = new CombineFileUtil();
        //combineFileUtil.CombineFile1(fileA,fileB,deatFile);
        combineFileUtil.CombineFile2(fileA,fileB,deatFile);
    }
}
