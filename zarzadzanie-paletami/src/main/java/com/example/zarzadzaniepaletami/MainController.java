package com.example.zarzadzaniepaletami;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

import static com.example.zarzadzaniepaletami.BinPacking3D.toLoad;

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
    private TextField quantity_input;

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
            int quantity = Integer.parseInt(quantity_input.getText());

            Pallet pallet = new Pallet(length, width, height, weight, quantity);

            cargo.add(pallet);

            length_input.clear();
            width_input.clear();
            height_input.clear();
            weight_input.clear();
            quantity_input.clear();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Złe dane");
            alert.setHeaderText(null);
            alert.setContentText("Proszę wprowadzić poprawne dane.");
            alert.showAndWait();
        }
    }

    public Button calculate_button;
    public Button add_button;
    public Button delete_button;

    @FXML
    public void calculateTrailer() {
        try {
            List<Trailer> trailers = trailerManager.getTrailers();
            if (cargo.isEmpty()) return;

            float totalWeight = (float) cargo.stream()
                    .mapToDouble(p -> p.getWeight() * p.getQuantity())
                    .sum();

            for (Trailer trailer : trailers) {
                boolean fitsInWeight = (totalWeight <= trailer.getMaxLoad());
                boolean fitsInDimensions = BinPacking3D.calculate(cargo, trailer);

                if (fitsInWeight && fitsInDimensions) {
                    showAlert("Naczepa " + trailer.getName() + " pomieści wszystkie palety");
                    return;
                }
            }

            float maxTrailerLoad = trailers.stream()
                    .map(Trailer::getMaxLoad)
                    .max(Float::compare)
                    .orElse(0f);

            String message;
            if (totalWeight > maxTrailerLoad) {
                float excess = totalWeight - maxTrailerLoad;
                message = String.format("Przekroczono maksymalną ładowność o %.2f kg", excess);
            } else {
                message = String.format("Brak miejsca - pozostało do załadowania: %d palet", toLoad);
            }


            showAlert("Żadna naczepa nie pomieści ładunku.\n" + message);

        } catch (Exception e) {
            showErrorAlert("Błąd podczas obliczeń: " + e.getMessage());
        }
    }

    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wynik kalkulacji");
        alert.setHeaderText(null);
        alert.setContentText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog-pane");

        alert.showAndWait();
    }

    private void showErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void deletePallet() {
        Pallet selectedPallet = table.getSelectionModel().getSelectedItem();
        if (selectedPallet != null) {
            cargo.remove(selectedPallet);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brak wyboru");
            alert.setHeaderText(null);
            alert.setContentText("Proszę zaznaczyć paletę do usunięcia.");
            alert.showAndWait();
        }
    }

}