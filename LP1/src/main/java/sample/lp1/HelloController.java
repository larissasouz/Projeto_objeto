package sample.lp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;



public class HelloController {

    //Identificando o que vou utilizar antes do metodo
    @FXML
    private TextField cor;
    @FXML
    private TextField marca;
    @FXML
    private TextField ponta;
    @FXML
    private TextField texto;

    private Caneta caneta;

    //registra as informações
    public void registrar(ActionEvent actionEvent) {
        Caneta  caneta = new Caneta(cor.getText(), marca.getText(), ponta.getText(), true);
        caneta.status();
        setCaneta(caneta);
        caneta.criandocsv(caneta.getCor(), caneta.getMarca(), caneta.getPonta(), caneta.isTampa(), caneta.isTinta());
    }

    // atualiza o estado da caneta: tampada ou destampada
    public void tampa(ActionEvent actionEvent) {
        try {
            this.caneta.tampar();
            caneta.criandocsv(caneta.getCor(), caneta.getMarca(), caneta.getPonta(), caneta.isTampa(), caneta.isTinta());
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("A CANETA NÃO EXISTE!");
            alert.showAndWait();
        }
    }

    // atualiza o estado da caneta: tampada ou destampada
    public void destampa(ActionEvent actionEvent) {
        try {
            this.caneta.destampar();
            caneta.criandocsv(caneta.getCor(), caneta.getMarca(), caneta.getPonta(), caneta.isTampa(), caneta.isTinta());
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("A CANETA NÃO EXISTE!");
            alert.showAndWait();
        }
    }

    // esvazia a caneta
    public void esvazia(ActionEvent actionEvent) {
        try {
            this.caneta.esvaziar();
            //caneta.lercsv();
            caneta.criandocsv(caneta.getCor(), caneta.getMarca(), caneta.getPonta(), caneta.isTampa(), caneta.isTinta());
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("A CANETA NÃO EXISTE!");
            alert.showAndWait();
        }
    }

    //escreve com a caneta
    public void escreve(ActionEvent actionEvent) {
        try {
            this.caneta.escrever(texto.getText());
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("A CANETA NÃO EXISTE!");
            alert.showAndWait();
        }
    }

    public void setCaneta(Caneta caneta) {
        this.caneta = caneta;
    }

    public Caneta getCaneta() {
        return this.caneta;
    }

}

