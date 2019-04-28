package SequenceStudy.SequenceArray;

import java.util.Arrays;

public class SequenceArrayImpl implements Sequence{
    private static final int DEFAULT_CAPACITY = 10;//数组默认大小
    private int size = 0;//存放元素个数
    private Object[] elementData;//存放元素的对象数组
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 5;//数组最大值

    //初始化数组，默认为10个元素
    public SequenceArrayImpl(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    //增
    public void add(Object data){
        ensureCapacity(size+1);//判断是否超出数组长度，若超出扩容后加数，若不超出直接增加数
        elementData[size++] = data;
    }

    //判断是否超出数组长度，若超出扩容后加数，若不超出直接增加数
    private void ensureCapacity(int minCap){
        if(minCap - elementData.length > 0){
            grow(minCap);
        }
    }

    //扩容
    private void grow(int minCap){
        int oldCap = elementData.length;
        int newCap = oldCap << 1;//扩容为原来的二倍
        if(newCap - minCap < 0){//二倍大小若不够将其扩容为需要大小
            newCap = minCap;
        }
        if(newCap - MAX_ARRAY_SIZE > 0){//扩容至超出数组最大长度为数组越界异常
            throw new ArrayIndexOutOfBoundsException("超出数组最大长度！");
        }
        elementData = Arrays.copyOf(elementData,newCap);//新数组被扩容为newCap长
    }

    //删
    public Object remove(int index){
        rangCheck(index);//先检查被删除元素下标是否存在
        Object oldData = elementData[index];//若存在，将该元素后续所有元素粘贴到该元素位置
        int moveSize = size - index - 1;
        if(moveSize > 0){//判断被删除元素是否为最后一个元素，不是的将后续元素粘贴到该元素位置
            System.arraycopy(elementData,index + 1,elementData,index,moveSize);
        }
        elementData[--size] = null;//若删除的是最后一个元素，直接置空
        return oldData;
    }

    //检查被删除元素下标是否存在
    private void rangCheck(int index){
        if(index >= size){//下标超出数组范围
            throw new ArrayIndexOutOfBoundsException("该元素不存在！");
        }
    }

    //查
    public Object get(int index){
        rangCheck(index);//判断所查找元素下标是否存在
        return elementData[index];//若存在，直接将所查找元素返回
    }

    //找
    public boolean contains(Object data){
        if(data == null) {//判断所找元素是否为null
            for(int i = 0;i < size;i++){
                if(elementData[i] == null){
                    return true;
                }
            }
        }
        else{//找其他元素
            for(int i = 0;i < size;i++){
                if(data.equals(elementData)){
                    return true;
                }
            }
        }
        return false;
    }

    //改
    public Object set(int index,Object newData){
        rangCheck(index);//判断所改元素是否存在
        Object oldData = elementData[index];//更改旧数据为新数据
        elementData[index] = newData;
        return oldData;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for(int i = 0;i < size;i++){
            elementData[i] = null;
        }
        this.size = 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }
}
