import java.lang.reflect.Array;
import java.util.Arrays;

public class SequenceArrayImpl<T> implements GenericSequence<T> {
    private static final int DEFAULT = 10;
    private static final int MAXIMUM = Integer.MAX_VALUE - 5;
    private int size;
    private T[] elementData;

    public SequenceArrayImpl(){
        this.elementData = (T[]) new Object[DEFAULT];
    }
    @Override
    public void add(T data) {
        //先判断数组是否需要扩容
        ensureCapacity(size + 1);
        //不需扩容直接增加
        elementData[size++] = data;
    }
    private void ensureCapacity(int minCap){
        if(minCap < elementData.length){
            grow(minCap);//扩容
        }
    }
    private void grow(int minCap){
        int oldCap = elementData.length;
        int newCap = oldCap << 1;
        if(newCap - minCap < 0){
            newCap = minCap;
        }
        elementData = Arrays.copyOf(elementData,newCap);
        if(newCap > MAXIMUM){
            throw new ArrayIndexOutOfBoundsException("扩容超长！");
        }
    }

    @Override
    public T remove(int index) {
        //先判断下标是否正确
        rangeCheck(index);
        //再将后续数组粘贴至该位置，将最后一个置空
        int moveSize = size - index - 1;
        if(moveSize > 0){
            System.arraycopy(elementData,index+1,elementData,index,moveSize);
        }
        elementData[--size] = null;

        return elementData[index];
    }
    private boolean rangeCheck(int index){
        if(index > size){
            throw new IndexOutOfBoundsException("元素下表异常！");
        }
        return true;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public boolean contains(T data) {
        if(data == null){
            for(int i = 0;i < size;i++){
                if(elementData[i] == null){
                    return true;
                }
            }
        }else{
            for (int i = 0;i < size;i++){
                if(data.equals(elementData[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
        rangeCheck(index);
        elementData[index] = newData;
        return elementData[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for(int i = 0;i < size;i++){
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(elementData,size);
    }
}
