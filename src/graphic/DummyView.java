package graphic;


import controller.PathagonController;

public class DummyView extends PathagonView {

    public DummyView(PathagonController c) {
        super(c);
    }


    //Setup de la vista


    //TODO Actualizar la vista con el estado del juego
    public void updateView() {
    }

    //TODO Informa de empate
    public void alertDraw() {
    }

    //TODO informa de movimento invalido
    public void alertInvalidMove() {
    }

    @Override
    public void alertWinner(String player) {

    }

    @Override
    public void alertInvalidTurn() {

    }


    //TODO Capturar con actionListeners las posiciones de las jugadas y aplicarlas con el controlador


}
