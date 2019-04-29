public class Text {
    public static void main(String[] args){
        DoubleLinkListImpl doubleLinkList = new DoubleLinkListImpl();
        doubleLinkList.add("ta");
        doubleLinkList.add("zhongyu");
        doubleLinkList.add("huilaile");
        doubleLinkList.clear();
        int size = doubleLinkList.size();
        System.out.println(size);
    }
}
