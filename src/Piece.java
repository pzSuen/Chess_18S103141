package P3;

public class Piece {
    private Position position;
    private String name;

    /**
     * 判断两个棋子是否相同
     * @param piece
     * @return 相同返回true，否则返回false
     */
    public boolean equals(Piece piece) {
        return this.position.equals(piece.getPosition())&&
                this.name.equals(piece.getName());
    }

    public Piece(int x, int y, String name){
        position = new Position(x,y);
        this.name = name;
    }

    /**
     * 获得棋子的名字
     * @return 棋子名称
     */
    public String getName(){
        return name;
    }

    /**
     * 获取棋子位置信息
     * @return 棋子位置
     */
    public Position getPosition(){
        return new Position(position.getX(),position.getY());
    }

    /**
     * 改变棋子位置
     * @param x
     * @param y
     */
    public void changePosition(int x,int y){
        position.changePosition(x,y);
    }

}
