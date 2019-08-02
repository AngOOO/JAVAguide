package TestPro;

import TestPro.CaseLoader;
import TestPro.Cases.SortCase;

public class Main {
    public static void main(String[] args) {
        CaseLoader loader = new CaseLoader();
        loader.load().run();
    }
}
