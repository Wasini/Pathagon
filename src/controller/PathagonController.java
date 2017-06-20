package controller;

import model.InvalidMoveException;
import model.PathagonSearchProblem.MinMaxAlphaBetaEngine;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import graphic.PathagonView;


/*
Clase que representa un juego de Pathagon donde el jugador 2 es una IA
TODO:
 */
public class PathagonController {

    private String player1;
    private String player2;
    private int turnNumber;

    public PathagonState currState; //Estado del juego
    private PathagonSearchProblem<PathagonState> problem; //Problema de busqueda para el juego Pathagon
    private MinMaxAlphaBetaEngine<PathagonSearchProblem<PathagonState>,PathagonState> ia;
    private PathagonView view;


    public PathagonController(String player,int difficulty) {
        this.currState = new PathagonState();
        this.problem = new PathagonSearchProblem<>(currState);
        this.ia = new MinMaxAlphaBetaEngine<>(this.problem,difficulty);
        this.turnNumber = 0;
        this.setPlayer1(player1);
        this.setPlayer2("BepBop");
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

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setView(PathagonView view) {
        this.view = view;
    }

    public PathagonView getView(){return this.view; };



    //
    //POST: se modifica el estado del juego al realizar el movimiento

    public boolean mkMove(int row,int col) throws InvalidMoveException {
        PathagonToken mv = new PathagonToken(this.getTurn(),row,col);
        if (!canPlay()) {
            changeTurn();
            view.updateView();
        }
        if (problem.validMove(this.currState,mv)) {
                problem.applyMove(this.currState,mv);
                this.turnNumber++;
                System.out.println("ACA SE DA EL ERROR");                
                view.updateView();
                return true;
        } else {
            view.alertInvalidMove();
            throw new InvalidMoveException("Movimiento no valido! "+mv.toString());
        }
    }


    public void iaPlay() throws InvalidMoveException{
        if(!this.currState.isMax()) {
            throw new InvalidMoveException("No es el turno de la maquina");
        }
        PathagonToken iaMove = this.ia.computeSuccessor(this.currState).getLastMove();
        if(iaMove.isNull()){
            this.changeTurn();
        } else{
            this.mkMove(iaMove.row,iaMove.col);
        }
    }


    /**
     * Realizae el movimiento del jugador en la pos row/col si es posible
     * Si el movimeinto es realizado le pasa el control a la maquina para que realize el siguiente movimiento
     * @param row
     * @param col
     * @return True si el movimiento se realizo
     * @throws InvalidMoveException
     * @throws InterruptedException
     */
    public void playerPlay(int row,int col) throws InvalidMoveException, InterruptedException {
        if (this.currState.isMax()) {
            view.alertInvalidTurn();
            throw new InvalidMoveException("No es el turno de "+this.getPlayer1());
        } else {
            if (mkMove(row,col)) {
                Thread.sleep(1300);
                iaPlay();
            }
        }
    }

    public void changeTurn(){
        this.currState.changeTurn();
        this.turnNumber++;
        view.updateView();
    }

    /**
     * Dice si el jugador del turno tiene fichas disponibles para jugar
     * @return true si al jugador de currState le quedan fichas disponibles
     */
    public boolean canPlay() {
        return currState.playerTokensLeft(currState.getCurrentPlayer())>0;
    }


    public void changeDifficulty(int difficulty) {
        this.ia = new MinMaxAlphaBetaEngine<>(this.problem,difficulty);
    };

    public PathagonState getState(){
        return this.currState;
    }

    /**
     * Retorna -1 si gano player1, 1 si gano player2 o 0 si es un empate
     *TODO: Calcular el resultado
     */
    private int getGameResult() {
        return 0;
    }

    public String getWinner(){
        return this.getGameResult()>0? this.getPlayer2():this.getPlayer1();
    }

    //Retorna true si el juego esta en un estado final
    public boolean hasEnded() {
        return this.problem.end(currState);
    }

    /**
     * Le dice a la vista que muestre el resultado del juego
     * Pre: El juego esta en un estado final
     */
    public void showResult() {
        if (this.hasEnded()) {
            if (getGameResult() == 0 ) {
                view.alertDraw();
            } else
                view.alertWinner(getWinner());
        }
    }



}




