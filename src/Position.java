package P3;

public class Position {
    private int x,y;
    public Position(int x,int y){
        this.x = x;
        this.y= y;
    }

    /**
     * 获得位置的横坐标
     * @return 位置横坐标
     */
    public int getX(){
        return x;
    }

    /**
     * 获取位置的纵坐标
     * @return 位置纵坐标
     */
    public int getY(){
        return y;
    }

    /**
     * 改变位置的横纵坐标
     * @param x
     * @param y
     */
    public void changePosition(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 判断两个位置是否相等
     * @param position
     * @return 相等返回true，否则返回true
     */
    public boolean equals(Position position) {
        return this.x==position.getX() && this.y==position.getY();
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}
