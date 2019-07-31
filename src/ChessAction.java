package P3;

public class ChessAction {
	/**
	 * 判断象棋移动操作是否合法
	 * @param player
	 * @param start
	 * @param end
	 * @param board
	 * @return 如果操作合法返回true，否则返回false
	 */
    public boolean isMoveLegal(Player player,Position start,Position end,ChessBoard board){
        if(start.getX()<0 || start.getX()>=8
            ||start.getY()<0 || start.getY()>=8||
            end.getX()<0 || end.getY()>=8||
            end.getY()<0 || end.getX()>=8){
            System.out.println("Some position has beyond the bound of board!");
            return false;
        }
        if(start.equals(end)){
            System.out.println("Start position is the same as the end position!");
            return false;
        }

        if(player.getId() != board.getBriefInfo(start.getX(),start.getY())){
            System.out.println("There is no pieces or this piece belongs to the other in the start position!");
            return false;
        }

        if(player.getId() == board.getBriefInfo(end.getX(),end.getY())){
            System.out.println("There is a piece belonging to you in the end position!");
            return false;
        }else if(board.getBriefInfo(end.getX(), end.getY())!=0){
            System.out.println("There is a piece belonging to the other in the end position!");
            return false;
        }
        return true;
    }

    /**
     * 判断象棋吃子操作是否合法
     * @param player
     * @param start
     * @param end
     * @param board
     * @return 操作合法返回true，否则返回false
     */
    public boolean isRemoveLegal(Player player,Position start,Position end ,ChessBoard board){
        if(start.getX()<0 || start.getX()>=8
                ||start.getY()<0 || start.getY()>=8||
                end.getX()<0 || end.getY()>=8||
                end.getY()<0 || end.getX()>=8){
            System.out.println("Some position has beyond the bound of board!");
            return false;
        }
        if(start.equals(end)){
            System.out.println("Start position is the same as the end position!");
            return false;
        }

        if(board.getBriefInfo(start.getX(),start.getY())==0){
            System.out.println("There is no pieces of yours in the position "+ start);
            return false;
        }
        if(board.getBriefInfo(end.getX(),end.getY())==0){
            System.out.println("There is no pieces in the second position "+ end);
            return false;
        }
        if(player.getId()!=board.getBriefInfo(start.getX(), start.getY())){
            System.out.println("The piece in the first position doesn't belong to you!");
            return false;
        }
        if(player.getId()==board.getBriefInfo(end.getX(),end.getY())){
            System.out.println("The piece in the second position doesn't belong to the other!");
            return false;
        }
        return true;
    }

    /**
     * 移动棋子从一个位置到另一个位置
     * @param player
     * @param start
     * @param end
     * @param board
     * @return 移动棋子成功返回true，否则返回false
     */
    public boolean move(Player player,Position start,Position end,ChessBoard board){
        if(isMoveLegal(player,start,end,board)){
            Piece piece = new Piece(0,0,"");
            board.positionInfo[start.getX()][start.getY()] = 0;
            if(player.getId() == 1){
                for(Piece p: board.player1Pieces){
                    if(p.getPosition().equals(start)){
                        p.changePosition(end.getX(),end.getY());
                        board.positionInfo[end.getX()][end.getY()] = 1;
                        piece = p;
                        break;
                    }
                }
                player.addHistory("Move piece "+piece.getName()+" from "+start+" to "+end);
            }else {
                for(Piece p: board.player2Pieces){
                    if(p.getPosition().equals(start)){
                        p.changePosition(end.getX(),end.getY());
                        board.positionInfo[end.getX()][end.getY()] = 2;
                        piece = p;
                        break;
                    }
                }
                player.addHistory("Move piece "+piece.getName()+" from "+start+" to "+end);
            }
            return true;
        }
        return false;
    }

    /**
     * 象棋吃子操作
     * @param player
     * @param start
     * @param end
     * @param board
     * @return 吃子成功返回true，否则返回false
     */
    public boolean remove(Player player,Position start,Position end,ChessBoard board){
        if(isRemoveLegal(player,start,end,board)){
            board.positionInfo[start.getX()][start.getY()] = 0;
            board.positionInfo[end.getX()][end.getY()] = player.getId();
            if(player.getId()==1){
                for(Piece p : board.player1Pieces){
                    if(p.getPosition().equals(start)){
                        p.changePosition(end.getX(),end.getY());
                        break;
                    }
                }
                for(Piece p: board.player2Pieces){
                    if(p.getPosition().equals(end)){
                        board.player2Pieces.remove(p);
                        break;
                    }
                }
                player.addHistory("Remove piece in the position "+end+" of player2");
            }else{
                for(Piece p : board.player2Pieces){
                    if(p.getPosition().equals(start)){
                        p.changePosition(end.getX(),end.getY());
                        break;
                    }
                }
                for(Piece p: board.player1Pieces){
                    if(p.getPosition().equals(end)){
                        board.player1Pieces.remove(p);
                        break;
                    }
                }
                player.addHistory("Remove piece in the position "+end+" of player1");
            }
            return true;
        }
        return false;
    }
}
