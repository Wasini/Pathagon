package controller;

import model.InvalidMoveException;
import model.PathagonSearchProblem.MinMaxAlphaBetaEngine;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import graphic.PathagonView;
import javax.swing.JOptionPane;


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
        this.setPlayer1(player);
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


    /**
     * Jugada de la maquina
     * si no tiene fichas pasa el turno al otro jugador
     */


    public void iaPlay() {
        if(!this.currState.isMax()) {
            JOptionPane.showMessageDialog(null,"No es el turno de la maquina","Aviso:",JOptionPane.WARNING_MESSAGE);
            return;
        }
        PathagonToken iaMove = this.ia.computeSuccessor(this.currState).getLastMove();
        if(iaMove.isNull()){
            nextTurn();
        } else{
            problem.applyMove(this.currState, iaMove);
            view.updateView();
        }
        this.turnNumber++;
    }


    /**
     * Realizae el movimiento del jugador en la pos row/col si es posible
     * Le avisa  a la vista luego de realizar el movimiento
     * @param row
     * @param col
     * @return True si el movimiento se realizo
     */
    public boolean playerPlay(int row,int col){


        if (!canPlay(currState.PLAYER1)) {
            return false;
        }

        PathagonToken mv = new PathagonToken(currState.PLAYER1,row,col);
        if (validPosition(row,col,currState.PLAYER1)) {
            problem.applyMove(this.currState, mv);
            view.updateView();
            this.turnNumber++;
            return true;
        } else {
            return false;
        }
    }


    /**
     * Dice si el jugador dado puede jugar (es su turno y le quedan fichas)
     * @return true si a player le quedna fichas y es su turno
     */
    public boolean canPlay(int PLAYER) {
        return currState.playerTokensLeft(currState.getCurrentPlayer())>0;
    }

    public boolean playerHasTurn() {
        return currState.getTurn() == currState.PLAYER1;
    }

    public boolean validPosition(int x,int y,int player) {
        return problem.validMove(currState,new PathagonToken(player,x,y));
    }


    public void changeDifficulty(int difficulty) {
        this.ia.setMaxDepth(difficulty);
    }

    public int getDifficulty(){ return this.ia.getMaxDepth();}



    public PathagonState getState(){
        return this.currState;
    }

    /**Pre el juego termino
     * Retorna -1 si gano player1, 1 si gano player2 o 0 si es un empate
     */
    public int getGameResult() {
        int tokensLeft = currState.playerTokensLeft(currState.PLAYER1) + currState.playerTokensLeft(currState.PLAYER2);
        if (tokensLeft == 0)
            return 0;
        int stateValue = problem.value(currState);

        if (stateValue == problem.minValue())
            return -1;
        if (stateValue == problem.maxValue())
            return 1;
        return 99; //NO DEERIA RETORNAR ESTO
    }

    public String getWinner(){
        return this.getGameResult()>0? this.getPlayer2():this.getPlayer1();
    }

    //Retorna true si el juego esta en un estado final
    public boolean hasEnded() {
        return this.problem.end(currState);
    }

    //Cambia al siguiente turno
    //Setea ulitmo movmiento y blockeados a nulo
    public void nextTurn() {
        this.currState.setLastMove(new PathagonToken(this.currState.getCurrentPlayer()));
        this.currState.removeBlockedMoves();
        this.currState.changeTurn();
        view.updateView();
    }

    /**
     * Le dice a la vista que muestre el resultado del juego
     * Pre: El juego esta en un estado final
     */
    public void showResult() {
            if (getGameResult() == 0 ) {
                view.alertDraw();
            } else
                view.alertWinner(getWinner());
    }



}




