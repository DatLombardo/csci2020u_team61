package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage window;
    private BorderPane layout;
    private TableView<StudentRecord> table;
    @Override
    public void start(Stage primaryStage) throws Exception{
        /* create the table (for the center of the user interface) */
        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());
        table.setEditable(true);

        /* create the table's columns */
        TableColumn<StudentRecord,String> sidColumn = null;
        sidColumn = new TableColumn<>("Student ID");
        sidColumn.setMinWidth(100);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
        sidColumn.setCellFactory(TextFieldTableCell.<StudentRecord>forTableColumn());
        sidColumn.setOnEditCommit((TableColumn.CellEditEvent<StudentRecord, String> event) -> {
            ((StudentRecord)event.getTableView().getItems().get(event.getTablePosition().getRow())).setSid(event.getNewValue());
        });

        TableColumn<StudentRecord,Double> midtermColumn = null;
        midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setMinWidth(100);
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord,Double> assignColumn = null;
        assignColumn = new TableColumn<>("Midterm");
        assignColumn.setMinWidth(100);
        assignColumn.setCellValueFactory(new PropertyValueFactory<>("assign"));

        TableColumn<StudentRecord,Double> fExamColumn = null;
        fExamColumn = new TableColumn<>("Final Exam");
        fExamColumn.setMinWidth(100);
        fExamColumn.setCellValueFactory(new PropertyValueFactory<>("fExam"));

        TableColumn<StudentRecord,Double> finalMarkColumn = null;
        finalMarkColumn = new TableColumn<>("Final Exam");
        finalMarkColumn.setMinWidth(100);
        finalMarkColumn.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        TableColumn<StudentRecord,String> letterGradeColumn = null;
        letterGradeColumn = new TableColumn<>("Student ID");
        letterGradeColumn.setMinWidth(100);
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
        letterGradeColumn.setCellFactory(TextFieldTableCell.<StudentRecord>forTableColumn());
        letterGradeColumn.setOnEditCommit((TableColumn.CellEditEvent<StudentRecord, String> event) -> {
            ((StudentRecord)event.getTableView().getItems().get(event.getTablePosition().getRow())).setLetterGrade(event.getNewValue());
        });


        table.getColumns().add(sidColumn);
        table.getColumns().add(midtermColumn);
        table.getColumns().add(assignColumn);
        table.getColumns().add(fExamColumn);
        table.getColumns().add(finalMarkColumn);
        table.getColumns().add(letterGradeColumn);

        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);

        /* arrange all components in the main user interface */
        layout = new BorderPane();
        layout.setCenter(table);
        layout.setBottom(editArea);

        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
