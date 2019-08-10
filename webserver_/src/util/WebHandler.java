package util;


import entity.Ser;
import entity.SerMapping;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *解析xml处理器
 */
public class WebHandler extends DefaultHandler {
    private List<Ser> entities = new ArrayList<>();
    private List<SerMapping> mappings = new ArrayList<>();
    private Ser ser;
    private SerMapping serMapping;
    //存储操作标签
    private String tag;
    private boolean isMapping = false;

    public List<Ser> getEntities() {
        return entities;
    }

    public List<SerMapping> getMappings() {
        return mappings;
    }

    //开始解析文档
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;
            if ("servlet".equals(tag)) {
                ser = new Ser();
                isMapping = false;
            } else if ("servlet-ser".equals(tag)) {
                serMapping = new SerMapping();
                isMapping = true;
            }
        }
    }

    //解析内容
    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String contents = new String(chars, start, length).trim();
        if (tag != null) {
            if (isMapping) {//操作servlet-ser
                if ("servlet-name".equals(tag)) {
                    serMapping.setName(contents);
                } else if ("url-pattern".equals(tag)) {
                    serMapping.addPatterns(contents);
                }
            } else {//操作servlet
                if ("servlet-name".equals(tag)) {
                    ser.setName(contents);
                } else if ("servlet-class".equals(tag)) {
                    ser.setClz(contents);
                }
            }
        }
    }

    //解析文档结束
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if ("servlet".equals(qName)) {
                entities.add(ser);
            } else if ("servlet-ser".equals(qName)) {
                mappings.add(serMapping);
            }
        }
        tag = null;
    }
}
