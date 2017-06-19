package view;

import controller.PathagonController;
import model.PathagonGameEngine;

import javax.swing.*;

/**
 * Created by grazi on 18/06/17.
 */
public abstract class PathagonView extends JPanel {


    protected PathagonGameEngine game;
    protected PathagonController gameControl;

    public PathagonView(PathagonController c) {
        gameControl = c;
    }

    public PathagonView(PathagonGameEngine g,PathagonController c) {
        game = g;
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
}
