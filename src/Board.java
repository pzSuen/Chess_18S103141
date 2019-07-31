package P3;

public interface Board {
	/**
	 * 查询位置信息，打印棋子名称
	 * @param position 
	 * @return 如果所查询位置合法，返回true；否则，返回false
	 */
    public boolean searchPosition(Position position);

    /**
     * 获取玩家棋子数目
     * @param player
     * @return 返回该玩家棋子数目
     */
    public int getNumberOfPieces(Player player);
    
    /**
     * 获取简略位置信息，即此位置棋子归属
     * @param x
     * @param y
     * @return 此位置无棋子返回0，属于玩家一返回1，属于玩家二返回2
     */
    public int getBriefInfo(int x,int y);
    
    /**
     * 打印棋盘信息，显示棋子分布
     */
    public void printBoard();
}
