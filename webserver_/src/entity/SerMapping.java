package entity;

import java.util.HashSet;
import java.util.Set;

/**处理以下标签
 <servlet-mapping>
 <servlet-name></servlet-name>
 <url-pattern></url-pattern>
 <url-pattern></url-pattern>
 </servlet-mapping>
 */
public class SerMapping {
    private String name;
    private Set<String> patterns;
    public SerMapping(){
        patterns = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }
    public void addPatterns(String pattern){
        this.patterns.add(pattern);
    }
}
