package Exercises530;

public class GrayCode {
    public String[] getGray(int n) {
        String[] perCode = new String[]{"0","1"};
        if(n == 1){//只有一位格雷码 0、1
            return perCode;
        }
        perCode = getGray(n - 1);
        //第二次的格雷码比第一次的格雷码长度多出一半
        String[] curCode = new String[2*perCode.length];
        //第二次的格雷码的前一半是第一次格雷码前面加0
        //后一半是第一次格雷码前面加1并且逆序
        for(int i = 0;i < perCode.length;i++){
            curCode[i] = "0"+perCode[i];
            curCode[curCode.length - 1 - i] = "1"+perCode[i];
        }
        return curCode;
    }
}
