package app;

import java.time.Month;
import java.time.MonthDay;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ZodiacChecker extends Application {

    MonthDay ariesStart = MonthDay.of(3, 21);
    MonthDay ariesEnd = MonthDay.of(4, 19);

    MonthDay taurusStart = MonthDay.of(4, 20);
    MonthDay taurusEnd = MonthDay.of(5, 20);

    MonthDay geminiStart = MonthDay.of(5, 21);
    MonthDay geminiEnd = MonthDay.of(6, 20);

    MonthDay cancerStart = MonthDay.of(6, 21);
    MonthDay cancerEnd = MonthDay.of(7, 22);

    MonthDay leoStart = MonthDay.of(7, 23);
    MonthDay leoEnd = MonthDay.of(8, 22);

    MonthDay virgoStart = MonthDay.of(8, 23);
    MonthDay virgoEnd = MonthDay.of(9, 22);

    MonthDay libraStart = MonthDay.of(9, 23);
    MonthDay libraEnd = MonthDay.of(10, 22);

    MonthDay scorpioStart = MonthDay.of(10, 23);
    MonthDay scorpioEnd = MonthDay.of(11, 21);

    MonthDay sagittariusStart = MonthDay.of(11, 22);
    MonthDay sagittariusEnd = MonthDay.of(12, 21);

    MonthDay capricornStart = MonthDay.of(12, 22);
    MonthDay capricornEnd = MonthDay.of(1, 19);

    MonthDay aquariusStart = MonthDay.of(1, 20);
    MonthDay aquariusEnd = MonthDay.of(2, 18);

    MonthDay piscesStart = MonthDay.of(2, 19);
    MonthDay piscesEnd = MonthDay.of(3, 20);

    Image ariesPic, taurusPic, geminiPic, cancerPic, leoPic,
            virgoPic, libraPic, scorpioPic, sagittariusPic, capricornPic, aquariusPic, piscesPic;

    Label whatIsYourBirthdate, dateFieldLabel, monthFieldLabel, outputLabel, output;
    TextField dateField;
    ChoiceBox<Month> monthChoiceBox;
    Button checkButton;
    ImageView zodiacImage;
    Scene inputScene, outputScene;
    Stage window;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        ariesPic = new Image("resource/aries.png");
        taurusPic = new Image("resource/taurus.png");
        geminiPic = new Image("resource/gemini.png");
        cancerPic = new Image("resource/cancer.png");
        leoPic = new Image("resource/leo.png");
        virgoPic = new Image("resource/virgo.png");
        libraPic = new Image("resource/libra.png");
        scorpioPic = new Image("resource/scorpio.png");
        sagittariusPic = new Image("resource/sagittarius.png");
        capricornPic = new Image("resource/capricorn.png");
        aquariusPic = new Image("resource/aquarius.png");
        piscesPic = new Image("resource/pisces.png");

        whatIsYourBirthdate = new Label("What's your birthdate?");
        whatIsYourBirthdate.setFont(new Font("Helvetica", 20));
        dateFieldLabel = new Label("Date");
        dateField = new TextField();
        dateField.setMaxWidth(40);
        dateField.setPromptText("Date");
        monthFieldLabel = new Label("Month");
        monthChoiceBox = new ChoiceBox();
        monthChoiceBox.setMaxWidth(100);
        monthChoiceBox.getItems().addAll(Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY,
                Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER,
                Month.NOVEMBER, Month.DECEMBER);
        checkButton = new Button("Check!");
        checkButton.setOnAction(e -> checkZodiac());
        outputLabel = new Label("Your zodiac is");
        outputLabel.setFont(new Font("Helvetica", 20));
        outputLabel.setVisible(false);
        output = new Label();
        output.setFont(new Font("College Block", 40));

        HBox dateRow = new HBox(5, dateField, monthChoiceBox);
        dateRow.setAlignment(Pos.CENTER);

        VBox inputColumn = new VBox(10, whatIsYourBirthdate, dateRow);
        inputColumn.setAlignment(Pos.CENTER);

        VBox outputColumn = new VBox(1, outputLabel, output);
        outputColumn.setAlignment(Pos.CENTER);

        zodiacImage = new ImageView();

        VBox mainColumn = new VBox(40, inputColumn, checkButton, outputColumn, zodiacImage);
        mainColumn.setAlignment(Pos.CENTER);

        //Input scene
        inputScene = new Scene(mainColumn, 500, 500);
        inputScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                checkButton.fire();
            }
        });

        //Output scene
        VBox outputPane = new VBox(zodiacImage, outputLabel, output);
        outputPane.setAlignment(Pos.CENTER);
        outputScene = new Scene(outputPane, 500, 500);

        window.setTitle("Zodiac Checker");
        window.setScene(inputScene);
        window.show();
    }

    public void checkZodiac() {
        MonthDay input = MonthDay.of(monthChoiceBox.getSelectionModel().getSelectedItem(),
                Integer.parseInt(dateField.getText()));

        if (input.isAfter(piscesEnd) && input.isBefore(taurusStart)) {
            output.setText("Aries");
            zodiacImage.setImage(ariesPic);
        } else if (input.isAfter(ariesEnd) && input.isBefore(geminiStart)) {
            output.setText("Taurus");
            zodiacImage.setImage(taurusPic);
        } else if (input.isAfter(taurusEnd) && input.isBefore(cancerStart)) {
            output.setText("Gemini");
            zodiacImage.setImage(geminiPic);
        } else if (input.isAfter(geminiEnd) && input.isBefore(leoStart)) {
            output.setText("Cancer");
            zodiacImage.setImage(cancerPic);
        } else if (input.isAfter(cancerEnd) && input.isBefore(virgoStart)) {
            output.setText("Leo");
            zodiacImage.setImage(leoPic);
        } else if (input.isAfter(leoEnd) && input.isBefore(libraStart)) {
            output.setText("Virgo");
            zodiacImage.setImage(virgoPic);
        } else if (input.isAfter(virgoEnd) && input.isBefore(scorpioStart)) {
            output.setText("Libra");
            zodiacImage.setImage(libraPic);
        } else if (input.isAfter(libraEnd) && input.isBefore(sagittariusStart)) {
            output.setText("Scorpio");
            zodiacImage.setImage(scorpioPic);
        } else if (input.isAfter(scorpioEnd) && input.isBefore(capricornStart)) {
            output.setText("Sagittarius");
            zodiacImage.setImage(sagittariusPic);
        } else if (input.isAfter(sagittariusEnd) || input.isBefore(aquariusStart)) {
            output.setText("Capricorn");
            zodiacImage.setImage(capricornPic);
        } else if (input.isAfter(capricornEnd) && input.isBefore(piscesStart)) {
            output.setText("Aquarius");
            zodiacImage.setImage(aquariusPic);
        } else if (input.isAfter(aquariusEnd) && input.isBefore(ariesStart)) {
            output.setText("Pisces");
            zodiacImage.setImage(piscesPic);
        }

        window.setScene(outputScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
