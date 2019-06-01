package Exerciese528;

public class RobotRun {
    //x+y<12
    public static int containWays(int x,int y){
        if (x == 1 || y == 1){
            return 1;
        }
        return containWays(x-1,y)+containWays(x,y-1);
    }
}
