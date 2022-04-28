package com.example.fightgame;

import com.example.fightgame.model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CombatController {

    @FXML
    ImageView img_fighter = new ImageView();
    @FXML
    ImageView img_opponent = new ImageView();
    @FXML
    Button bt_fight = new Button();
    @FXML
    ComboBox cb_fighter = new ComboBox();
    @FXML
    ComboBox cb_opponent = new ComboBox();

    ArrayList<GameCharacter> characters = new ArrayList<>();

    String selectedOpponent = "";
    String selectedFighter = "";

    @FXML Label lb_combatResult = new Label();
    @FXML Label lb_historial = new Label();

    @FXML
    protected void initialize() {
        Image image = new Image(new File(String.format("src/main/resources/com/example/fightgame/images/noImage.png")).toURI().toString());
        img_fighter.setImage(image);
        img_opponent.setImage(image);
        bt_fight.setDisable(true);

        characters.add(new Huma("Charles"));
        characters.add(new Huma("Eric"));
        characters.add(new Troll("Frederic"));
        characters.add(new Troll("Lara"));
        characters.add(new Orc("Alexander"));
        characters.add(new Orc("Joane"));
        characters.add(new Nan("Sebastian"));
        characters.add(new Nan("Henry"));
        characters.add(new Huma("Pau"));

        fillOpponenetsCombo();
        fillFightersCombo();
        lb_combatResult.setText("");
    }

    /**
     * Mètode per a imprimir els noms dels personatges dins del drop down
     */
    private void fillFightersCombo() {
        ArrayList<String> fighters = new ArrayList<>();
        for (GameCharacter f: characters) {
            if(f instanceof Fighter){
                fighters.add(f.getNom());
            }
        }

        cb_fighter.setItems(FXCollections.observableArrayList(fighters));
    }

    /**
     * Mètode per a controllar el drop down dels personatges
     */
    private void fillOpponenetsCombo() {
        ArrayList<String> opponents = new ArrayList<>();
        for (GameCharacter c: characters) {
            if(!(c instanceof Fighter)){
                opponents.add(c.getNom());
            }
        }

        cb_opponent.setItems(FXCollections.observableArrayList(opponents));
    }

    /**
     * Mètode per a seleccionar el primer lluitador. No ha de permetre sel·leccionar el mateix personatge dos cops
     */
    @FXML
    public void fighterSelection() {
        if(cb_fighter.getValue() != null){
            selectedFighter = cb_fighter.getValue().toString();
            Image image = new Image(new File(String.format("src/main/resources/com/example/fightgame/images/" + selectedFighter + ".png")).toURI().toString());
            img_fighter.setImage(image);
            img_fighter.setOpacity(1);
            img_opponent.setOpacity(1);
        }
        check();
    }

    /**
     * Mètode per a seleccionar l'oponent. No ha de permetre sel·leccionar el mateix personatge dos cops
     */
    @FXML
    public void opponentSelection() {
        if(cb_opponent.getValue() != null){
            selectedOpponent = cb_opponent.getValue().toString();
            Image image = new Image(new File(String.format("src/main/resources/com/example/fightgame/images/" + selectedOpponent + ".png")).toURI().toString());
            img_opponent.setImage(image);
            img_fighter.setOpacity(1);
            img_opponent.setOpacity(1);
        }
        check();
    }

    /**
     * Mètode per a comprovar que cap dels oponents és null ""
     */
    private void check() {
        if(cb_opponent.getValue() != null && cb_fighter.getValue() != null){
            bt_fight.setDisable(false);
        }
    }

    /**
     * Mètode per a controlar l'event del botó reset
     */
    @FXML
    public void reset() {
        Alert missatgeAlerta = new Alert(Alert.AlertType.WARNING, "Els lluitadors seleccionats serán esborrats.");
        Image image = new Image(new File(String.format("src/main/resources/com/example/fightgame/images/noImage.png")).toURI().toString());
        missatgeAlerta.show();
        cb_fighter.getSelectionModel().clearSelection();
        cb_opponent.getSelectionModel().clearSelection();
        selectedFighter="";
        selectedOpponent="";
        img_fighter.setImage(image);
        img_opponent.setImage(image);
        img_fighter.setOpacity(1);
        img_opponent.setOpacity(1);
        bt_fight.setDisable(true);
        lb_combatResult.setText("");
        lb_historial.setText("");
    }

    /**
     * Mètode per a controlar l'event del botó fight
     */
    @FXML
    public void fight() {
        //TODO
        String fighterName = cb_fighter.getValue().toString();
        String opponentName = cb_opponent.getValue().toString();
        Fighter f = null;
        GameCharacter c = null;
        for (GameCharacter gc: characters) {
            if(fighterName.equals(gc.getNom())){
                f = (Fighter) gc;
            }
            if(opponentName.equals(gc.getNom())){
                c = gc;
            }
        }
        if(f.fight(c)){
            img_opponent.setOpacity(0.5f);
            img_fighter.setOpacity(1);
            lb_combatResult.setText(cb_fighter.getValue().toString() + " WINS / " + cb_opponent.getValue().toString() + " LOSES");
            int index = characters.indexOf(f);
            for (GameCharacter f2: characters) {
                if(f2 instanceof Fighter && f2.getNom().equals(cb_fighter.getValue().toString())){
                    ((Fighter) f2).win();
                    lb_historial.setText(((Fighter) f2).getVictories() + " victories / " + ((Fighter) f2).getDefeat() + " defeats");
                }
            }
        }
        else{
            img_fighter.setOpacity(0.5f);
            img_opponent.setOpacity(1);
            lb_combatResult.setText(cb_fighter.getValue().toString() + " LOSES / " + cb_opponent.getValue().toString() + " WINS");
            int index = characters.indexOf(f);
            for (GameCharacter f2: characters) {
                if(f2 instanceof Fighter && f2.getNom().equals(cb_fighter.getValue().toString())){
                    ((Fighter) f2).lose();
                    lb_historial.setText(((Fighter) f2).getVictories() + " victories / " + ((Fighter) f2).getDefeat() + " defeats");
                }
            }
        }

    }
}
