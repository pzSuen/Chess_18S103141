package P3;

import java.util.*;

public class ChessBoard implements Board {
    List<Piece> player1Pieces = new ArrayList<>();
    List<Piece> player2Pieces = new ArrayList<>();
    int[][] positionInfo = new int[8][8];

    /**
     * œÛ∆Â∆Â≈Ã≥ı ºªØ
     */
    public ChessBoard(){
        for(int i=2;i<5;i++){
            for(int j=0;j<8;j++){
                positionInfo[i][j]=0;
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<8;j++){
                positionInfo[i][j] = 1;
                positionInfo[7-i][j] = 2;
            }
        }

        player1Pieces.add(new Piece(0,0,"Rook"));
        player1Pieces.add(new Piece(0,7,"Rook"));
        player2Pieces.add(new Piece(7,0,"Rook"));
        player2Pieces.add(new Piece(7,7,"Rook"));
        player1Pieces.add(new Piece(0,1,"Knight"));
        player1Pieces.add(new Piece(0,6,"Knight"));
        player2Pieces.add(new Piece(7,1,"Knight"));
        player2Pieces.add(new Piece(7,6,"Knight"));
        player1Pieces.add(new Piece(0,2,"Bishop"));
        player1Pieces.add(new Piece(0,5,"Bishop"));
        player2Pieces.add(new Piece(7,2,"Bishop"));
        player2Pieces.add(new Piece(7,5,"Bishop"));
        player1Pieces.add(new Piece(0,3,"Queen"));
        player2Pieces.add(new Piece(7,3,"Queen"));
        player1Pieces.add(new Piece(0,4,"King"));
        player2Pieces.add(new Piece(7,4,"King"));
        for(int i=0;i<8;i++){
            player1Pieces.add(new Piece(1,i,"Pawn"));
            player2Pieces.add(new Piece(6,i,"Pawn"));
        }
    }

   @Override
    public int getBriefInfo(int x,int y){
        return positionInfo[x][y];
    }

    @Override
    public int getNumberOfPieces(Player player){
        if(player.getId()==1)
            return player1Pieces.size();
        else
            return player2Pieces.size();
    }

    @Override
    public boolean searchPosition(Position position){
        if(position.getX()>8 || position.getY()>8
            || position.getY()<0 || position.getX()<0){
            System.out.println("There is no such position!");
            return false;
        }
        for(Piece p : player1Pieces){
            if(p.getPosition().equals(position)){
                System.out.println("The position " + position + " belongs to player1's piece "+p.getName());
                return true;
            }
        }
        for(Piece p: player2Pieces){
            if(p.getPosition().equals(position)){
                System.out.println("The position " + position + " belongs to player2's piece "+p.getName());
                return true;
            }
        }

        System.out.println("There is no pieces in the position "+position);
        return true;
    }


    @Override
    public void printBoard(){
        for(int i=7;i>=0;i--){
            for(int j=0;j<8;j++){
                System.out.print(positionInfo[i][j]+" ");
            }
            System.out.println();
        }
    }
}
