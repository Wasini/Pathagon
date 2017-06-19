package view;

import controller.PathagonController;
import model.PathagonSearchProblem.PathagonState;

import javax.swing.*;

/**
 * Created by grazi on 18/06/17.
 */
public abstract class PathagonView extends JPanel {


    protected PathagonState gameState;
    protected PathagonController gameControl;


    public PathagonView(PathagonController c) {
        gameState = c.getState();
        gameControl = c;
    }

    /**
     * Actualiza la vista del juego
     */
    public abstract void updateView();

    /**
     * Informa sobre empate
     */
    public abstract void alertDraw();

    /**
     * Informa sobre movimiento invalido
     */
    public abstract void alertInvalidMove();


    /**
     * Muestra el ganador del juego
     */
    public abstract void alertWinner(String player);

    public abstract void alertInvalidTurn();
}
