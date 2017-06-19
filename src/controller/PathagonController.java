package controller;

import model.InvalidMoveException;
import model.PathagonGameEngine;
import view.DummyView;
import view.PathagonView;

/**
 * Created by grazi on 13/06/17.
 */

/*
Clase que controla un juego de pathagon y lo muestra con una vista determinada.
Tiene un juego de pathagon y una vista
Proposito: Controla el input del usuario para realizar los movimientos
 */

public class PathagonController {

    private PathagonGameEngine game;
    private PathagonView view; //TODO Cambiar por la vista nueva

    public PathagonController() {
    }

    public void newGame(String player,int difficulty) {
        this.game = new PathagonGameEngine(player,difficulty);
    }

    public void setView(PathagonView view) {
        this.view = view;
    }

    public void changeDifficulty(int difficulty) {
        if (this.game != null){
            game.setIaLevel(difficulty);
        }
    }

    /**
     * Pre: El juego no termino
     * @param row
     * @param col
     * @return
     */
    public boolean play(int row,int col) {

        if(!game.canPlay()) {
            game.changeTurn();
            view.updateView();
            return true;
        }

        try {
            game.mkMove(row,col);
            view.updateView();
            return true;
        } catch (InvalidMoveException e) {
            view.alertInvalidMove();
            e.printStackTrace();
            return false;
        }

       /* if(game.hasEnded()) {
            int result = game.getGameResult();
            if (result == 0){
                view.alertDraw();
                return false;
            }
            return false;
        }
       */

    }

    public static void main(String[] args){

    }

}

