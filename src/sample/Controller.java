package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

    @FXML
    Label outputLabel;

    @FXML
    TableView<Product> table;

    @FXML
    TableColumn<Product, String> nameColumn;

    @FXML
    TableColumn<Product, String> priceColumn;

    @FXML
    TableColumn<Product, String> quantityColumn;

    @FXML
    TextField nameInput;

    @FXML
    TextField priceInput;

    @FXML
    TextField quantityInput;

    @FXML
    Button addButton;

    @FXML
    Button deleteButton;

    @FXML
    public void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteButtonClicked() {
        Product selectedItem = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selectedItem);

//        ObservableList<Product> productSelected, allProducteds;
//        allProducteds = table.getItems();
//        productSelected = table.getSelectionModel().getSelectedItems();
//        productSelected.forEach(allProducteds::remove);
    }

    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Product> observable, Product oldValue, Product newValue) -> {
                    outputLabel.setText("This line is " + newValue);
                }
        );
//        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
//            @Override
//            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
//                outputLabel.setText(oldValue + " -> " + newValue);
//            }
//        });
    }


}
