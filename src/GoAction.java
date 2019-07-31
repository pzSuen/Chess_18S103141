package P3;

public class GoAction implements Action{
    //@Override
	/**
	 * 围棋中的提子操作
	 * @param player
	 * @param piece
	 * @param board
	 * @return提子成功返回true，否则返回false
	 */
    public boolean remove(Player player,Piece piece,GoBoard board) {
        if(removeIsLegal(player,piece.getPosition(),board)){
            board.deletePiece(piece);
            player.addHistory("Remove piece in the position "+ piece.getPosition());
            return true;
        }

        return false;
    }

    /**
     * 围棋中的加子操作
     * @param player
     * @param position
     * @param board
     * @return 加子成功返回true，否则返回false
     */
    public boolean addPiece(Player player,Position position,GoBoard board){
        if(moveIsLegal(player,position,board)){
            if(player.getId()==1)
                board.addPiece1(new Piece(position.getX(),position.getY(),"white"));
            else
                board.addPiece2(new Piece(position.getX(),position.getY(),"black"));
            player.addHistory("Add a piece in the position "+position);
            return true;
        }

        return false;
    }

    //@Override
    /**
     * 判断提子操作是否合法
     * @param player
     * @param position
     * @param board
     * @return 合法返回true，否则返回false
     */
    public boolean removeIsLegal(Player player,Position position,GoBoard board){
        if(position.getX()>18 || position.getY()>18||
        position.getX()<0 || position.getY()<0){
            System.out.println("The position is out of bound!");
            return false;
        }
        if(board.getBriefInfo(position.getX(),position.getY())==0){
            System.out.println("There is no pieces to remove!");
            return false;
        }
        if(player.getId()==board.getBriefInfo(position.getX(),position.getY())){
            System.out.println("You can't remove the pieces of yours!");
            return false;
        }
        return true;
    }

    //@Override
    /**
     * 判断加子操作是否合法
     * @param player
     * @param position
     * @param board
     * @return 合法返回true，否则返回false
     */
    public boolean moveIsLegal(Player player,Position position,GoBoard board){
        if(position.getX()>18 || position.getY()>18||
        position.getX()<0|| position.getY()<0){
            System.out.println("The position is out of bound!");
            return false;
        }
        if(board.getBriefInfo(position.getX(),position.getY())!=0){
            System.out.println("The position has been taken off!");
            return false;
        }
        return true;
    }
}
