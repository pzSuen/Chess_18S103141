package P3;

import java.util.*;

public class ChessGame implements Game{
    ChessBoard board = new ChessBoard();
    Player player1 ,player2;
    ChessAction action = new ChessAction();

    @Override public void initGame(){
        Scanner scanner1 = new Scanner(System.in);
        String player1Name,player2Name;
        System.out.println("Please input player1's name:");
        player1Name = scanner1.nextLine();
        System.out.println("Please input player2's name:");
        player2Name = scanner1.nextLine();

        player1 = new Player(player1Name,1);
        player2 = new Player(player2Name,2);
    }
    @Override public void playGame(){
        String player;
        boolean flag = true;
        while(true){
            int choice = 5;
            player = flag ? player1.getName():player2.getName();
            menu();
            board.printBoard();
            Scanner scanner = new Scanner(System.in);

            System.out.println(player+", please input your choice:");
            try{
                choice = scanner.nextInt();
            }catch(Exception e){
                System.out.println("No such choice!(Jump this step by default)");
            }
            switch (choice){
                case 0:
                    return ;
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    int startx = -1,starty =-1,endx = -1,endy = -1;
                    try{
                        System.out.println("Please input x of the start position:");
                        startx = scanner1.nextInt();
                        System.out.println("Please input y of the start position:");
                        starty = scanner1.nextInt();
                        System.out.println("Please input x of the end position:");
                        endx = scanner1.nextInt();
                        System.out.println("Please input x of the end position:");
                        endy = scanner1.nextInt();
                    }catch(Exception e){
                        System.out.println("The position you input is illegal!");
                    }
                    if(flag){
                        if(action.move(player1,new Position(startx,starty),new Position(endx,endy),board)){
                            flag = !flag;
                        }
                    }else{
                        if(action.move(player2,new Position(startx,starty),new Position(endx,endy),board)){
                            flag = !flag;
                        }
                    }
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    int yourx = -1,youry = -1,hisx = -1,hisy = -1;
                    try{
                        System.out.println("Please input x of your piece's position:");
                        yourx = scanner2.nextInt();
                        System.out.println("Please input y of your piece's position:");
                        youry = scanner2.nextInt();
                        System.out.println("Please input x of his piece's position:");
                        hisx = scanner2.nextInt();
                        System.out.println("Please input y of hit piece's position:");
                        hisy = scanner2.nextInt();
                    }catch(Exception e){
                        System.out.println("The position you input is illegal!");
                    }
                    if(flag){
                        if(action.remove(player1,new Position(yourx,youry),new Position(hisx,hisy),board)){
                            flag = !flag;
                        }
                    }else {
                        if(action.remove(player2,new Position(yourx,youry),new Position(hisx,hisy),board)){
                            flag = !flag;
                        }
                    }
                    break;
                case 3:
                    Scanner scanner3 = new Scanner(System.in);
                    int m=-1,n=-1;
                    try {
                        System.out.println("Please input the x of the position:");
                        m = scanner3.nextInt();
                        System.out.println("Please input the y of the position:");
                        n = scanner3.nextInt();
                    }catch(Exception e){
                        System.out.println("The position you input is illegal!");
                    }

                    if(board.searchPosition(new Position(m,n))) {
                        if (flag) {
                            player1.addHistory("Inquiry position's information in the (" + m + "," + n + ")");
                        } else {
                            player2.addHistory("Inquiry position's information in the (" + m + "," + n + ")");
                        }
                        flag = !flag;
                    }
                    break;
                case 4:
                    System.out.println("The number of player1 pieces in the board is "+board.getNumberOfPieces(player1));
                    System.out.println("The number of player2 pieces in the board is "+board.getNumberOfPieces(player2));
                    if(flag){
                        player1.addHistory("Calculate the number of pieces.Player1 is "+board.getNumberOfPieces(player1)+",player2 is "+
                                board.getNumberOfPieces(player2));
                    }else {
                        player2.addHistory("Calculate the number of pieces.Player1 is "+board.getNumberOfPieces(player1)+",player2 is "+
                                board.getNumberOfPieces(player2));
                    }
                    flag = !flag;
                    break;
                default:
                    System.out.println(player+" jumps this step");
                    if(flag){
                        player1.addHistory("Jump a step");
                    }else {
                        player2.addHistory("Jump a step");
                    }
                    flag = !flag;
                    break;
            }

        }
    }
    @Override public void endGame(){
        List<String> player1History ;
        List<String> player2History ;

        player1History = player1.getHistory();
        player2History = player2.getHistory();

        int i=1,j=1;
        System.out.println("Player1 has taken "+ player1History.size() +" moves, which are as follows:");
        for (String s : player1History){
            System.out.println(i+"."+s);
            i++;
        }

        System.out.println("Player2 has taken "+ player2History.size() +" moves, which are as follows:");
        for (String s: player2History){
            System.out.println(j+"."+s);
            j++;
        }

    }
    /*public static void main(String[] args){
        ChessGame chessGame = new ChessGame();
        chessGame.initGame();
        chessGame.playGame();
        chessGame.endGame();
    }*/

    @Override public void menu(){
        System.out.println("0.Exit");
        System.out.println("1.Move a piece");
        System.out.println("2.Remove other's piece");
        System.out.println("3.Inquire position's information");
        System.out.println("4.Calculate the number of players' pieces in the board");
        System.out.println("5.Jump this step");
    }
}
