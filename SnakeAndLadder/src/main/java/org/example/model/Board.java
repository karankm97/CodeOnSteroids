package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    @Getter
    List<Cell> cells;
    @Getter
    private Integer boardSize;

    public Board(Integer boardSize, Integer snakes, Integer ladders) {
        boardSize.hashCode();
        this.boardSize = boardSize;
        cells = new ArrayList<>();
        initBoard(boardSize);
        addSnakesAndLadder(snakes, ladders);
    }

    private void addSnakesAndLadder(Integer numSnakes, Integer numLadder) {
        while(numSnakes != 0) {
            int posStart = ThreadLocalRandom.current().nextInt(0, cells.size()-1);
            int posEnd = ThreadLocalRandom.current().nextInt(0, cells.size()-1);

            if(posEnd >= posStart) continue;

            Cell cell = cells.get(posStart);
            Jump snake = new Jump(posStart, posEnd);
            cell.setJump(snake);
            numSnakes--;
            System.out.println("Add snake from: " + posStart + " and to: " + posEnd);
        }

        while(numLadder != 0) {
            int posStart = ThreadLocalRandom.current().nextInt(0, cells.size()-1);
            int posEnd = ThreadLocalRandom.current().nextInt(0, cells.size()-1);

            if(posStart >= posEnd) continue;

            Cell cell = cells.get(posStart);
            Jump ladder = new Jump(posStart, posEnd);
            cell.setJump(ladder);
            numLadder--;
            System.out.println("Added ladder from: " + posStart + " and to: " + posEnd);
        }
    }

    private void initBoard(Integer boardSize) {
        for(int i=0; i<boardSize; i++) {
            cells.add(new Cell(null));
        }
    }
}
