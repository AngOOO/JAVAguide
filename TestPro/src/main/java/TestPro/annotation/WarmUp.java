package TestPro.annotation;

public @interface WarmUp {
    //若不指定预热次数，默认0次
    int iterations() default 0;
}
