package sample.lp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;



public class HelloController {

    //Identificando o que vou utilizar antes do metodo

    @FXML
    private TextField escolha;
    @FXML
    private TextField cor;
    @FXML
    private TextField marca;
    @FXML
    private TextField ponta;
    @FXML
    private TextField texto;

    private Caneta caneta;

    private int contador;

    ArrayList<Caneta> estojo = new ArrayList<Caneta>();
    HashSet<String> chave = new HashSet<String>();
    HashMap<String, Caneta> myDict = new HashMap<String, Caneta>();

    //registra as informações
    public void registrar(ActionEvent actionEvent) {
        Caneta  caneta = new Caneta(cor.getText(), marca.getText(), ponta.getText(), true);
        caneta.status();
        setCaneta(caneta);
        contador = contador + 1;
        guardar(caneta, ("c" + contador));
        myDict.put(("c" + contador), caneta);
        caneta.criandocsv(caneta.getCor(), caneta.getMarca(), caneta.getPonta(), caneta.isTampa(), caneta.isTinta());
    }

    public void mostrar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String mytext = "";
        if (escolha.getText().equals("")) {
            for (String key : myDict.keySet()) {
                mytext = mytext + "\n" + "Chave: " + key + " Cor: " + myDict.get(key).getCor()
                        + " Marca: " + myDict.get(key).getMarca() + " Ponta: "
                        + myDict.get(key).getPonta();

//                mytext = mytext + "test//";
            }
            alert.setContentText(mytext);
            alert.showAndWait();
        } else {
            alert.setContentText(myDict.get(escolha.getText()).getCor()
                    + "//" + myDict.get(escolha.getText()).getMarca() + "//"
                    + myDict.get(escolha.getText()).getPonta());
            alert.showAndWait();
        }
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

    // método estojo
    public void guardar(Caneta caneta, String chave){
        this.estojo.add(caneta);
        this.chave.add(chave);
    }

    public void setCaneta(Caneta caneta) {
        this.caneta = caneta;
    }

    public Caneta getCaneta() {
        return this.caneta;
    }

}

