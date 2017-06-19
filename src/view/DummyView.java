package view;

import controller.PathagonController;
import model.PathagonGameEngine;



public class DummyView extends PathagonView {


    //Setup de la vista
    public DummyView(PathagonGameEngine g, PathagonController c) {
        super(g, c);
    }

    //TODO Actualizar la vista con el estado del juego
    public void updateView() {
    }

    //TODO Informa de empate
    public void alertDraw() {
    }

    //TODO informa de movimento invalido
    public void alertInvalidMove() {
    }


    //TODO Capturar con actionListeners las posiciones de las jugadas y aplicarlas con el controlador


}
