package com.example.zarzadzaniepaletami;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {
    private TrailerManager trailerManager = new TrailerManager();
    @FXML
    private TextField length_input;

    @FXML
    private TextField width_input;

    @FXML
    private TextField height_input;

    @FXML
    private TextField weight_input;

    @FXML
    private Spinner<Integer> quantity_input;

    @FXML
    private TableView<Pallet> table;

    @FXML
    private TableColumn<Pallet, Float> column_length;

    @FXML
    private TableColumn<Pallet, Float> column_width;

    @FXML
    private TableColumn<Pallet, Float> column_height;

    @FXML
    private TableColumn<Pallet, Float> column_weight;

    @FXML
    private TableColumn<Pallet, Float> column_quantity;

    @FXML
    private ObservableList<Pallet> cargo = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,5);

        valueFactory.setValue(5);

        quantity_input.setValueFactory(valueFactory);

        column_length.setCellValueFactory(new PropertyValueFactory<>("length"));
        column_width.setCellValueFactory(new PropertyValueFactory<>("width"));
        column_height.setCellValueFactory(new PropertyValueFactory<>("height"));
        column_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        column_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table.setItems(cargo);
    }


    @FXML
    private void addPallet() {
        try {
            float length = Float.parseFloat(length_input.getText());
            float width = Float.parseFloat(width_input.getText());
            float height = Float.parseFloat(height_input.getText());
            float weight = Float.parseFloat(weight_input.getText());
            int quantity = (int) quantity_input.getValue();

            Pallet pallet = new Pallet(length, width, height, weight, quantity);

            cargo.add(pallet);

            length_input.clear();
            width_input.clear();
            height_input.clear();
            weight_input.clear();
            quantity_input.getValueFactory().setValue(1);

        } catch (NumberFormatException e) {
            System.out.println("Wprowadź poprawne dane");
        }
    }

    public Button calculate_button;
    public Button add_button;

    @FXML
    private void calculate() {
        try {
            List<Trailer> trailers = trailerManager.getTrailers();



            /*StringBuilder result = new StringBuilder("Wyniki:\n");
            for (Trailer trailer : trailers) {
                float trailerVolume = (trailer.getLength() * trailer.getWidth() * trailer.getHeight()) / 1000000; // m^3

                if (totalVolume <= trailerVolume && totalWeight <= trailer.getMaxLoad()) {
                    result.append("Naczepa ").append(trailer.getName()).append(" pomieści wszystkie palety.\n");
                } else {
                    result.append("Naczepa ").append(trailer.getName()).append(" nie pomieści wszystkich palet.\n");
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wyniki Kalkulacji");
            alert.setHeaderText(null);
            alert.setContentText(result.toString());
            alert.showAndWait();*/
        } catch (Exception e) {
            System.out.println("Wystąpił błąd podczas obliczeń: " + e.getMessage());
        }
    }

}