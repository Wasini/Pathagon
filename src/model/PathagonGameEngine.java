package model;

import model.PathagonSearchProblem.MinMaxAlphaBetaEngine;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;

/*
Clase que representa un juego de Pathagon donde el jugador 2 es una IA
TODO:
 */
public class PathagonGameEngine {

    private String player1;
    private String player2;
    private int iaLevel;

    private PathagonState currState; //Estado del juego
    private PathagonSearchProblem<PathagonState> problem; //Problema de busqueda para el juego Pathagon
    private MinMaxAlphaBetaEngine<PathagonSearchProblem<PathagonState>,PathagonState> ia;
    //Constructor de la clase
    public PathagonGameEngine(String player1,int iaLevel){

        this.currState = new PathagonState();
        this.problem = new PathagonSearchProblem<>(currState);
        this.iaLevel = iaLevel;
        this.ia = new MinMaxAlphaBetaEngine<>(this.problem,iaLevel);
        this.player1 = player1;
        this.player2 = "ImARobot";
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


    //
    //POST: se modifica el estado del juego al realizar el movimiento

    public void mkMove(int row,int col) throws InvalidMoveException {
        PathagonToken mv = new PathagonToken(this.getTurn(),row,col);
        if (problem.validMove(this.currState,mv)) {
                problem.applyMove(this.currState,mv);
        } else
            throw new InvalidMoveException("Movimiento no valido "+mv.toString());
    }


    public void iaPlay() throws InvalidMoveException{
        if(!this.currState.isMax()) {
            throw new InvalidMoveException("No es el turno de la maquina");
        }

        PathagonToken iaMove = this.ia.computeSuccessor(this.currState).getLastMove();
        this.mkMove(iaMove.row,iaMove.col);

    }

    /**
     * Dice si el jugador del turno tiene fichas disponibles para jugar
     * @return true si al jugador de currState le quedan fichas disponibles
     */
    public boolean canPlay() {
        return currState.playerTokensLeft(currState.getCurrentPlayer())>0;
    }


    /**
     * Retorna -1 si gano player1, 1 si gano player2 o 0 si es un empate
     */
    //TODO: Llevar en el estado del juego el resultado si este es un estado final
    private int getGameResult() {
        return 0;
    }

    public String getWinner(){
        return this.getGameResult()>0? this.getPlayer2():this.getPlayer1();
    }

    //Retorna true si el juego esta en un estado final
    public boolean gameEnd() {
        return this.problem.end(currState);
    }



}




