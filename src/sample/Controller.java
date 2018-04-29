package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

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
        System.out.println(nameInput.getText());
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
    }


}
