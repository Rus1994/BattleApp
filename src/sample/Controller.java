package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Observer{

    Battle battle;
    Squad squad1;
    Squad squad2;

    @Override
    public void showMessage(String msg) {
        output_textArea.appendText(msg  + "\n");
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startBattle_btn;

    @FXML
    private ComboBox<String> typeWarrior_comboBox;

    @FXML
    private TextField nameSquad1_textField;

    @FXML
    private TextField nameSquad2_textField;

    @FXML
    private TextArea output_textArea;

    @FXML
    private Button addWarrior_btn;

    @FXML
    private ComboBox<Squad> squadForAdd_comboBox;

    @FXML
    void initialize() {
        battle = new Battle();
        squad1 = new Squad();
        squad2 = new Squad();
        battle.addObserver(this);

        ObservableList<String> listType = FXCollections.observableArrayList("Викинги", "Рыцари");
        typeWarrior_comboBox.setItems(listType);

        startBattle_btn.setOnAction(event -> {
            battle.fight(squad1, squad2); // передавать готовые отряды
        });

        ObservableList<Squad> list = FXCollections.observableArrayList(squad1, squad2);
        squadForAdd_comboBox.setItems(list);
        nameSquad1_textField.setOnAction(event -> {squad1.setNameSquad(nameSquad1_textField.getText());});
        nameSquad2_textField.setOnAction(event -> {squad2.setNameSquad(nameSquad2_textField.getText());});


        addWarrior_btn.setOnAction(event -> {
            Squad squad = squadForAdd_comboBox.getValue();

            switch (listType.indexOf(typeWarrior_comboBox.getValue())) {
                case 0:
                    squad.addWarrior(new Viking(squad.getNameSquad()));
                    showMessage("Добавлен Викинг в отряд " + squad.getNameSquad());
                    break;
                case 1:
                    squad.addWarrior(new Knight(squad.getNameSquad()));
                    showMessage("Добавлен Рыцарь в отряд " + squad.getNameSquad());
                    break;
            }
        });
    }
}

