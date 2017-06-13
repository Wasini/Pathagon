package model;

import java.util.List;

/**
 * Created by grazi on 13/06/17.
 */

/*
Clase que representa un juego de Pathagon donde el jugador 2 es una IA
TODO:
 */
public class PathagonGameEngine {
    //Turno del juego: turn>0 => player1
    private int turn;

    private String player1;
    private String player2;

    private List<PathagonMove> player1Moves;
    private List<PathagonMove> player2Moves;


    //Estado del juego
    private PathagonState currState;

    //Fichas disponibles para jugador 1(avaibleTokens[0]
    private int[] avaibleTokens;

    //Problema de busqueda para el juego Pathagon
    private PathagonSearchProblem<PathagonState> problem;

    //Constructor de la clase
    public PathagonGameEngine(String player1,String player2){

        this.currState = new PathagonState();
        this.player1 = player1;
        this.player2 = player2;
        updateMoves();


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
        return turn;
    }

    public int nextTurn() {
        return turn * -1;
    }

    //PRE: El movimiento mv es valido en el estado actual del juego para el jugador del turno corriente
    //POST: se modifica el estado del juego al realizar el movimiento
    //TODO
    public void mkMove(int row,int col) throws IllegalArgumentException {
        PathagonMove mv = new PathagonMove(this.turn,row,col);
        if (validMove(mv)) {
            mv.apply(this.currState);
        } else {
            throw new IllegalArgumentException("Movimiento invalid " + mv.toString());
        }

    }

    //Retorna true si el movimiento @mv es aplicable al estado corriente del juego
    //TODO
    private boolean validMove(PathagonMove mv) {
        return false;
    }

    ;

    //Retorna true si el juego esta en un estado final
    public boolean gameEnd() {
        return this.problem.end(currState);
    };





    //Retorna una lista con todos los posibles movimientos del jugador @player para el estado @st
    //TODO
    private List<PathagonMove> getAvaibleMoves(int player,PathagonState st){
        return null;
    }

    //Actualiza los movimientos de acuerdo al estado actual del juego
    private void updateMoves() {
        this.player1Moves = getAvaibleMoves(1,this.currState);
        this.player2Moves = getAvaibleMoves(-1,this.currState);
    }




}
