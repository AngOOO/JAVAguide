package TextPrintStream;

import java.io.*;

class MyPrint {
    //装饰模式
    private OutputStream out;

    public MyPrint(OutputStream out) {
        this.out = out;
    }

    private void print(String str) {
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str) {
        this.print(str + "\n");
    }

    public void printChar(char num) {
        this.print(String.valueOf(num));
    }

    public void printInt(int num) {
        this.print(String.valueOf(num));
    }

    public void printLong(long num) {
        this.print(String.valueOf(num));
    }

    public void printDouble(double num) {
        this.print(String.valueOf(num));
    }
}

public class TextPrintStream {
    public static void TextMyPrint() {
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt");
        try {
            MyPrint myPrint = new MyPrint(new FileOutputStream(file));
            myPrint.println("Hello Java!");
            myPrint.printChar('a');
            myPrint.printInt(666);
            myPrint.printLong(888l);
            myPrint.printDouble(2.56d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void CharacterPrintStream(){
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt");
        try  {
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.print('I');
            printStream.print(1024);
            printStream.println(7.88d);
            printStream.print(true);
            printStream.println("Hello World!");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void BytePrintWrite(){
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt");
        int age = 20;
        String name = "张三";
        try{
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
            printWriter.append('N');
            printWriter.print("I Love U!");
            printWriter.printf("姓名：%s,年龄：%d.",name,age);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BytePrintWrite();
    }
}
