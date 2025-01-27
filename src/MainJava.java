import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Thomas Povinelli
 * * Created 2017-Sep-13
 * * In AspectRatioTest
 */
public class MainJava extends Application {

    public double gcd(double x, double y) {
        if (x == y) return x;
        if (x < y) return gcd(x, y - x);
        if (x > y) return gcd(x - y, y);
        return 0.0;
    }

    public void start(Stage primaryStage) {
        double width = Screen.getPrimary().getBounds().getWidth();
        double height = Screen.getPrimary().getBounds().getHeight();
        double gcd = gcd(width, height);
        Label l = new Label("The aspect ratio of your primary screen is " + ((int)(width / gcd)) + ":" + ((int)(height / gcd)));
        Button b = new Button("OK");
        b.setOnAction(e -> primaryStage.close());
        l.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 18.0));
        primaryStage.setTitle("Aspect Ratio Information");
        FlowPane pane = new FlowPane(l, b);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5.0));
        pane.setHgap(5.0);
        pane.setVgap(5.0);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }

    public static void main(String[] args) {

    	launch(); 
    }
}
