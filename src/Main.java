import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        String eternalReturn = "'This life as you now live it and have lived it,\n" +
        "you will have to live once more and innumerable times more;\n" +
        "and there will be nothing new in it, but every pain and every joy\n" +
        "and every thought and sigh and everything unutterably small or \n" +
        "great in your life will have to return to you, all in the same succession and sequence' ...\n" +
        "\nWould you not throw yourself down and gnash your teeth and curse the demon who spoke thus?\n" +
        "Or have you once experienced a tremendous moment when you would have answered him: \n" +
        "\n'You are a god and never have I heard anything more divine.'";


        Text textRef = new Text(eternalReturn);
        textRef.setLayoutY(120);
        textRef.setTextOrigin(VPos.TOP);
        textRef.setTextAlignment(TextAlignment.JUSTIFY);
        textRef.setWrappingWidth(440);
        textRef.setFill(Color.ANTIQUEWHITE);
        textRef.setFont(Font.font("SansSerif", FontWeight.BOLD, 28));


        TranslateTransition transTransition = new TranslateTransition(new Duration(74400), textRef);
        transTransition.setToY(-840);
        transTransition.setInterpolator(Interpolator.LINEAR);
        transTransition.setCycleCount(Timeline.INDEFINITE);


        Image image = new Image("file:image.jpg");
        ImageView imageView = new ImageView(image);
        Group textGroup = new Group(textRef);
        textGroup.setLayoutX(100);
        textGroup.setLayoutY(180);
        textGroup.setClip(new Rectangle(480, 200));
        Group root = new Group(imageView, textGroup);

        Scene scene = new Scene(root, imageView.getFitWidth(), imageView.getFitHeight());
        primaryStage.setTitle("Eternal Recurrence");
        primaryStage.setScene(scene);
        primaryStage.show();

        transTransition.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
