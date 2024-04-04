package org.example;

import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Dice;
import org.example.model.Player;

import java.util.Deque;
import java.util.LinkedList;

public class Runner {
    private Board myBoard;
    private Deque<Player> players;

    private Dice dice;

    private Player winner;
    public Runner(Integer size, Integer playerCount, Integer snakes, Integer ladders) {
        myBoard = new Board(size, snakes, ladders);
        dice = new Dice(1);
        players = new LinkedList<>();
        for(int i=0; i<playerCount; i++) {
            players.add(new Player(i+1, 0));
        }
    }

    public void startGame() {
        System.out.println();
        while(winner == null) {
            Player player = getPlayerWhoRolls();

            int rollValue = dice.rollDice();


            System.out.println(player.getId() + " move: Rolled-"+rollValue);
            int nextPosition = getNextPosition(player.getCurrentPosition(), player.getCurrentPosition() + rollValue);
            System.out.println();

            player.setCurrentPosition(nextPosition);

            if(nextPosition == myBoard.getBoardSize() - 1) {
                winner = player;
            }
        }
        System.out.println("Winner is: " + winner.getId());
    }

    private Integer getNextPosition(Integer currentPosition, Integer nextPosition) {
        if(nextPosition >= myBoard.getBoardSize()) {
            System.out.println("Cant go above limit!! Roll again!!");
            return currentPosition;
        }

        Cell cell = myBoard.getCells().get(nextPosition);

        if (cell.getJump() != null && cell.getJump().getStart() == nextPosition) {
            String jumpBy = cell.getJump().getStart() > cell.getJump().getEnd() ? "snake" : "ladder";
            System.out.println(jumpBy + " from: " + cell.getJump().getStart() + " to: " + cell.getJump().getEnd());
            return cell.getJump().getEnd();
        }

        System.out.println("Moved from: " + currentPosition + " to: " + nextPosition);
        return nextPosition;
    }

    private Player getPlayerWhoRolls() {
        Player p = players.removeFirst();
        players.addLast(p);
        return p;
    }
}
