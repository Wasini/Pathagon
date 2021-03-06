package graphic;

import controller.PathagonController;
import model.PathagonSearchProblem.PathagonState;

/**
 * Created by grazi on 18/06/17.
 */
public abstract class PathagonView extends javax.swing.JFrame{


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
     * Muestra el ganador del juego
     */
    public abstract void alertWinner(String player);



}
