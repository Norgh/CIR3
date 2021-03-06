package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Restaurant");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setGridLinesVisible(true);
        Text scenetitle = new Text("My Restaurant Manager");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 1, 1);
       
       
        
        Button Cuisine = new Button("Cuisine");
        Cuisine.setMinSize(100, 10);
        HBox hCuisine = new HBox(10);
        hCuisine.setAlignment(Pos.CENTER);
        hCuisine.getChildren().add(Cuisine);
        grid.add(hCuisine, 0, 5, 1, 1);
        
        Button Commande = new Button("Commande");
        Commande.setMinSize(100, 10);
        HBox hCommande = new HBox(10);
        hCommande.setAlignment(Pos.CENTER);
        hCommande.getChildren().add(Commande);
        grid.add(hCommande, 0, 6, 1, 1);
        
        Button Bar = new Button("Bar");
        Bar.setMinSize(100, 10);
        HBox hBar = new HBox(10);
        hBar.setAlignment(Pos.CENTER);
        hBar.getChildren().add(Bar);
        grid.add(hBar, 0, 7, 1, 1);
        
        Button Monitoring = new Button("Monitoring");
        Monitoring.setMinSize(100, 10);
        HBox hMonitoring = new HBox(10);
        hMonitoring.setAlignment(Pos.CENTER);
        hMonitoring.getChildren().add(Monitoring);
        grid.add(hMonitoring, 0, 8, 1, 1);
        
        Button Stocks = new Button("Stocks");
        Stocks.setMinSize(100, 10);
        HBox hStocks = new HBox(10);
        hStocks.setAlignment(Pos.CENTER);
        hStocks.getChildren().add(Stocks);
        grid.add(hStocks, 0, 9, 1, 1);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 2);
        actiontarget.setId("actiontarget");
        grid.setColumnSpan(actiontarget, 1);
        grid.setHalignment(actiontarget, RIGHT);
        Cuisine.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Sign in button pressed");
                
                
            }
            
        });
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
        (Main.class.getResource("application.css").toExternalForm());
   
        primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}