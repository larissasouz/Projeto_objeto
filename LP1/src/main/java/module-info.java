module sample.lp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;


    opens sample.lp1 to javafx.fxml;
    exports sample.lp1;
}