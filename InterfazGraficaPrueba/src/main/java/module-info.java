module com.example.interfazgraficaprueba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interfazgraficaprueba to javafx.fxml;
    exports com.example.interfazgraficaprueba;
}