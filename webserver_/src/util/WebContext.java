package util;

import entity.SerMapping;
import entity.Ser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据pattern找name
 * 根据name找class
 *
 * 将对应的list转换为map
 */
public class WebContext {
    private List<Ser> ser = null;
    private List<SerMapping> serMapping = null;
    //key=servlet-name  value=servlet-class
    private Map<String, String> NCMap = new HashMap<>();
    //key=url-pattern   value=servlet-name
    private Map<String, String> PNMap = new HashMap<>();

    public WebContext(List<Ser> ser, List<SerMapping> serMapping) {
        this.ser = ser;
        this.serMapping = serMapping;
        //将ser的List装换成对应的Map
        for (Ser s : ser) {
            NCMap.put(s.getName(), s.getClz());
        }
        //将map的List装换成对应的Map
        for (SerMapping m : serMapping) {
            for (String pattern : m.getPatterns()) {
                PNMap.put(pattern, m.getName());
            }
        }
        System.out.println(NCMap);
        System.out.println(PNMap);
    }

    //通过URL找到对应class
    public String getClz(String pattern) {
        String name = PNMap.get(pattern);
        System.out.println(name);
        return NCMap.get(name);
    }
}
