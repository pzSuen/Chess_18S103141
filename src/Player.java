package P3;

import java.util.*;

public class Player {
    private String name;
    private int id;
    private List<String> history = new ArrayList<>();

    public Player(String name,int id){
        this.name = name;
        this.id = id;
    }

    /**
     * 获取玩家ID
     * @return 玩家ID
     */
    public int getId(){
        return id;
    }
    
    /**
     * 获取玩家名称
     * @return 玩家名称
     */
    public String getName(){
        return name;
    }

    /**
     * 获取玩家历史足迹
     * @return 玩家历史足迹
     */
    public List<String> getHistory(){
        return history;
    }

    /**
     * 添加历史足迹
     * @param s
     */
    public void addHistory(String s){
        history.add(s);
    }
}
