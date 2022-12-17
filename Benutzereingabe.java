import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Benutzereingabe extends Application {
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		AdressBuch adressbuch = new AdressBuch();
		Label label1 = new Label("Vorname:");
		Label label2 = new Label("Nachname:");
		Label label3 = new Label("Telefon:");
		Label label4 = new Label("e-Mail:");
		Label label5 = new Label("Neuer Kontakt");
		TextField textFieldV = new TextField();
		TextField textFieldN = new TextField();
		TextField textFieldT = new TextField();
		TextField textFieldE = new TextField();
		
		HBox neuerKontakt = new HBox(label5);
		neuerKontakt.setAlignment(Pos.CENTER);
		neuerKontakt.setPadding(new Insets(10));
		neuerKontakt.setSpacing(10);
		
		HBox vorname = new HBox(label1, textFieldV);
		vorname.setAlignment(Pos.CENTER);
		vorname.setPadding(new Insets(5));
		vorname.setSpacing(10);
		
		HBox nachname = new HBox(label2, textFieldN);
		nachname.setAlignment(Pos.CENTER);
		nachname.setPadding(new Insets(5));
		nachname.setSpacing(10);
		
		HBox telefon = new HBox(label3, textFieldT);
		telefon.setAlignment(Pos.CENTER);
		telefon.setPadding(new Insets(5));
		telefon.setSpacing(10);
		
		HBox eMail = new HBox(label4, textFieldE);
		eMail.setAlignment(Pos.CENTER);
		eMail.setPadding(new Insets(5));
		eMail.setSpacing(10);
		
		VBox kontakt = new VBox(vorname, nachname, telefon, eMail);
		
		Button bh = new Button("Hinzufügen");
		Button ba = new Button("Ausdrucken");
		Button bs = new Button("Schließen");
		HBox buttonPane = new HBox(bh, ba, bs);
		buttonPane.setAlignment(Pos.BASELINE_RIGHT);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setSpacing(10);
		
		bh.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(textFieldV.getText() != "" && textFieldN.getText() != "" && textFieldT.getText() != "" && textFieldE.getText() != "") {
					adressbuch.addAdresse(textFieldV.getText(), textFieldN.getText(), textFieldT.getText(), textFieldE.getText());
				}
				textFieldV.clear();
				textFieldN.clear();
				textFieldT.clear();
				textFieldE.clear();
				textFieldV.requestFocus();
			}
		});
		ba.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				adressbuch.printAll();
			}
		});
		bs.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		BorderPane pane = new BorderPane();

		primaryStage.setTitle("Kontakte");
		pane.setTop(neuerKontakt);
		pane.setCenter(kontakt);
		pane.setBottom(buttonPane);

		Scene scene = new Scene(pane, 300, 250);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
