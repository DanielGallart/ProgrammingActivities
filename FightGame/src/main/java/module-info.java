module com.example.fightgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.fightgame to javafx.fxml;
    exports com.example.fightgame;
}