package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 处理以下标签
 <servlet>
    <servlet-name></servlet-name>
    <servlet-class></servlet-class>
 </servlet>
 */
public class Ser {
    private String name;
    private String clz;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClz() {
        return clz;
    }
    public void setClz(String clz) {
        this.clz = clz;
    }
}
