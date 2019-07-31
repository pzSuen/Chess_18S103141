package P3;

import java.util.ArrayList;
import java.util.List;

public class GoBoard implements Board{
    private List<Piece> player1Pieces = new ArrayList<>();
    private List<Piece> player2Pieces = new ArrayList<>();
    private int[][] positionInfo;
    private int n;

    public GoBoard(int n){
        this.n = n;
        positionInfo = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                positionInfo[i][j] = 0;
        }
    }

    @Override
    public int getNumberOfPieces(Player player){
        if(player.getId()==1)
            return player1Pieces.size();
        else
            return player2Pieces.size();
    }

    @Override
    public int getBriefInfo(int x,int y){
        return positionInfo[x][y];
    }

    /**
     * 添加棋子到玩家一中
     * @param piece
     */
    public void addPiece1(Piece piece){
        player1Pieces.add(piece);
        positionInfo[piece.getPosition().getX()][piece.getPosition().getY()]=1;
    }

    /**添加棋子到玩家二中
     * 
     * @param piece
     */
    public void addPiece2(Piece piece){
        player2Pieces.add(piece);
        positionInfo[piece.getPosition().getX()][piece.getPosition().getY()] = 2;
    }

    /**
     * 删除棋子
     * @param piece
     */
    public void deletePiece(Piece piece) {
        for(Piece p: player1Pieces){
            if(p.equals(piece)){
                player1Pieces.remove(p);
                break;
            }
        }
        for (Piece p: player2Pieces){
            if(p.getPosition().equals(piece.getPosition())){
                player2Pieces.remove(p);
                break;
            }
        }
        positionInfo[piece.getPosition().getX()][piece.getPosition().getY()] = 0;
    }


    @Override
    public boolean searchPosition(Position position){
        if(position.getX()>18 || position.getY()>18){
            System.out.println("There is no such position!");
            return false;
        }
        switch (positionInfo[position.getX()][position.getY()]){
            case 0:
                System.out.println("There is no pieces!");
                break;
            case 1:
                Piece p1 = new Piece(-1,-1,null);
                for(Piece p : player1Pieces){
                    if(p.getPosition().equals(position)){
                        p1 = p;
                        break;
                    }
                }
                System.out.println("There is a piece belonging to player1,and piece's name is "+p1.getName());
                break;
            case 2:
                Piece p2 = new Piece(-1,-1,null);
                for(Piece p : player2Pieces){
                    if(p.getPosition().equals(position)){
                        p2 = p;
                        break;
                    }
                }
                System.out.println("There is a piece belonging to player2,and piece's name is "+p2.getName());
                break;
        }
        return true;
    }

    @Override
    public void printBoard(){
        System.out.println("The  board are as follows:");
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                System.out.print(positionInfo[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
