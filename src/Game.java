package P3;

public interface Game {
	/**
	 * 游戏初始化
	 */
    public void initGame();
    
    /**
     * 进行游戏，是游戏主程序
     */
    public void playGame();
    
    /**
     * 结束游戏，并打印各玩家历史足迹
     */
    public void endGame();
    
    /**
     * 打印菜单
     */
    public void menu();
}
