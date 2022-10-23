package sample.lp1;

import com.opencsv.CSVWriter;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Caneta {

    // criando atributos
    private String cor;
    private String marca;
    private String ponta;
    private boolean tampa;
    private boolean tinta;

    //criando constructor
    public Caneta(String cor, String marca, String ponta, boolean tampa) {
        this.cor = cor;
        this.marca = marca;
        this.ponta = ponta;
        this.tampa = tampa;
        this.tinta = true;
    }

    //criando get e set
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPonta() {
        return ponta;
    }

    public void setPonta(String ponta) {
        this.ponta = ponta;
    }

    public boolean isTampa() {
        return tampa;
    }

    public void setTampa(boolean tampa) {
        this.tampa = tampa;
    }

    public boolean isTinta() {
        return tinta;
    }

    public void setTinta(boolean tinta) {
        this.tinta = tinta;
    }

    //criando metodos especiais
    public void escrever(String texto) {
        if (isTinta() & !isTampa()) {
            System.out.println(texto);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ESTOU SEM TINTA OU TAMPADA!!");
            alert.showAndWait();

        }
    }

    public void tampar() {
        if (!isTampa()) {
            this.tampa = true;
            status();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("JÁ ESTOU TAMPADA!!");
            alert.showAndWait();
        }
    }

    public void destampar() {
        if (isTampa()) {
            this.tampa = false;
            status();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("JÁ ESTOU DESTAMPADA!!");
            alert.showAndWait();
        }
    }

    public void esvaziar() {
        if (isTinta()) {
            this.tinta = false;
            status();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ESTOU SEM TINTA!!");
            alert.showAndWait();
        }
    }

    public void status() {
        System.out.println("------------------");
        System.out.println("Cor: " + getCor());
        System.out.println("Marca: " + getMarca());
        System.out.println("Ponta: " + getPonta());
        System.out.println("Tampada? " + isTampa());
        System.out.println("Tem tinta? " + isTinta());
    }

    public static final String CSV_PATH = "canetas.csv";

    public void criandocsv(String cor, String marca, String ponta, boolean tampa, boolean tinta) {


        try {
           System.out.println("Gerando CSV");

////lê e acrescenta no csv
            Scanner sc = new Scanner(new File("C:\\Programação\\LP1\\LP1\\canetas.csv"));
            List<String> linhas = new ArrayList<>();
            while (sc.hasNext()) {
                linhas.add(sc.nextLine());
            }
            sc.close();

//cria csv
           FileWriter fw = new FileWriter(new File(CSV_PATH));
           CSVWriter cw = new CSVWriter(fw);
           String[] headers = {"Cor", "Marca", "Ponta", "Tampada", "Tinta"};
           List<String[]> data = new ArrayList<String[]>();

//acrescenta informações no csv
            for (String linha : linhas) {
                String[] x = {linha};
                data.add(x);
            }
           String[] item1 = {cor, marca, ponta, String.valueOf(tampa), String.valueOf(tinta)};
            data.add(headers);
           data.add(item1);
           cw.writeAll(data);
           cw.close();
           fw.close();
           System.out.println("fim");
       } catch (Exception e) {
           System.out.println("nao foi");
       }

    }
}
