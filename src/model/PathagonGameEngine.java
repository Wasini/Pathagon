package model;

import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;

/**
 * Created by grazi on 13/06/17.
 */

/*
Clase que representa un juego de Pathagon donde el jugador 2 es una IA
TODO:
 */
public class PathagonGameEngine {

    private String player1;
    private String player2;

    private PathagonState currState; //Estado del juego
    private PathagonSearchProblem<PathagonState> problem; //Problema de busqueda para el juego Pathagon

    //Constructor de la clase
    public PathagonGameEngine(String player1,String player2){

        this.currState = new PathagonState();
        this.problem = new PathagonSearchProblem<>(currState);
        this.player1 = player1;
        this.player2 = player2;
    }



    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getTurn() {
        return this.currState.getTurn();
    }

    public int nextTurn() {
        return this.currState.getTurn() *-1;
    }

    public void setTurn(int turn) {
        this.currState.setTurn(turn);
    }


    //PRE: El movimiento mv es valido en el estado actual del juego para el jugador del turno corriente
    //POST: se modifica el estado del juego al realizar el movimiento
    //TODO Cambiar el estado con el movimiento

    public void mkMove(int row,int col) throws InvalidMoveException {
        PathagonToken mv = new PathagonToken(this.getTurn(),row,col);
        if (problem.validMove(this.currState,mv)) {
                problem.applyMove(this.currState,mv);
        } else
            throw new InvalidMoveException("Movimiento no valido "+mv.toString());
    }




    //Retorna true si el juego esta en un estado final
    public boolean gameEnd() {
        return this.problem.end(currState);
    }



}




