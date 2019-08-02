package TestPro;

import TestPro.annotation.Benchmark;
import TestPro.annotation.Measurement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class CaseRunner {
    private static final int DEFAULT_ITERATIONS = 10;
    private static final int DEFAULT_GROUP = 5;
    private List<Case> cas;

    public CaseRunner(List<Case> caseList) {
        this.cas = caseList;
    }

    //没有把预热考虑进来
    //每组实验前都预热
    public void run() {
        for (Case bCase : cas) {
            int iterations = DEFAULT_ITERATIONS;
            int group = DEFAULT_GROUP;
            //先获取类级别的配置
            Measurement classMeasurement = bCase.getClass().getAnnotation(Measurement.class);
            if (classMeasurement != null) {
                iterations = classMeasurement.iterations();
                group = classMeasurement.group();
            }
            //找到对象中哪些方法是需要测试的方法
            //找到所有方法
            Method[] methods = bCase.getClass().getMethods();
            //查看该方法是否被benchmark注解
            for (Method method : methods) {
                Benchmark benchmark = method.getAnnotation(Benchmark.class);
                if (benchmark == null) {
                    continue;
                }
                Measurement methodMeasurement = method.getAnnotation(Measurement.class);
                if (methodMeasurement != null) {
                    iterations = methodMeasurement.iterations();
                    group = methodMeasurement.group();
                }
                runCase(bCase, method, iterations, group);
            }
        }
    }

    private void runCase(Case bCase, Method method, int iterations, int group) {
        System.out.println(method.getName());
        for (int i = 0; i < group; i++) {
            System.out.println("第" + i + "次实验");
            long t1 = System.nanoTime();
            for (int j = 0; j < iterations; j++) {
                try {
                    method.invoke(bCase);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            long t2 = System.nanoTime();
            System.out.println("耗时：" + (t2 - t1) + "纳秒");
        }
    }
}

public class CaseLoader {
    //指定加载
    public CaseRunner load() {
        String pkg = "TestPro/Cases";
        String pkgD = "TestPro.Cases";
        List<String> classNameList = new ArrayList<String>();
        List<Case> caseList = new ArrayList<Case>();
        try {
            //1，根据固定类，找到类加载器
            //2，根据加载器找到类文件所在路径
            //3，扫描路径的所有类文件
            ClassLoader classLoader = this.getClass().getClassLoader();
            Enumeration<URL> urls = classLoader.getResources(pkg);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (!url.getProtocol().equals("file")) {
                    //如果不是*.class文件，暂时不支持
                    continue;
                }
                String dirname = URLDecoder.decode(url.getPath(), "utf8");
                File dir = new File(dirname);
                if (!dir.isDirectory()) {
                    //不是目录
                    continue;
                }
                //扫描该目下的所有*.class文件，作为所有类文件
                File[] files = dir.listFiles();
                if (files == null) {
                    continue;
                }
                for (File file : files) {
                    //没有判断后缀是否是.class
                    String filename = file.getName();
                    String className = filename.substring(0, filename.length() - 6);
                    classNameList.add(className);
                }
            }
            for (String className : classNameList) {
                //得到类的实例
                Class cls = Class.forName(pkgD + "." + className);
                if (hasInterface(cls, Case.class)) {
                    caseList.add((Case) cls.newInstance());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return new CaseRunner(caseList);
    }

    //判断该类是否为这个类文件中的类
    private boolean hasInterface(Class<?> cls, Class<?> itf) {
        Class[] interfs = cls.getInterfaces();
        for (Class<?> i : interfs) {
            if (i == itf) {
                return true;
            }
        }
        return false;
    }
}
