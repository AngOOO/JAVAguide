public class TextArray {
    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            if (data[0] < data[i]) {
                int tmp = data[0];
                data[0] = data[i];
                data[i] = tmp;
            }
        }
        return data[0];
    }

    //2.计算数组中最小值
    public static int arrayMinElement(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            if (data[0] > data[i]) {
                int tmp = data[0];
                data[0] = data[i];
                data[i] = tmp;
            }
        }
        return data[0];
    }


    //3.计算数组值之和
    public static int arrayElementSum(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    //4.数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b) {
        int lengthA = a.length;
        int lengthB = b.length;
        int[] data = new int[lengthA + lengthB];
        for (int i = 0; i < lengthA; i++) {
            data[i] = a[i];
        }
        for (int i = lengthA; i < (lengthA + lengthB); i++) {
            data[i] = b[i - lengthA];
        }
        return data;
    }

    //5.数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    /*public static int[] arraySub(int[] data, int start, int end) {

    }*/

    //6.数组打印
    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "、");
        }
    }

    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data) {

    }

    public static void main(String[] args) {
        int[] data = {1, 6, 4235, 245, 235, 2335, 542};
        int[] data1 = {2, 4, 65, 76, 7};
        /*int maxData = arrayMaxElement(data);
        int minData = arrayMinElement(data);
        int sumData = arrayElementSum(data);
        System.out.println("max data:" + maxData);
        System.out.println("min data:" + minData);
        System.out.println("sum data:" + sumData);*/
        System.out.println("data + data1:");
        printArray(arrayJoin(data, data1));
    }
}

