package sample.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Calendar;

public class YearlyCalendarWidget extends GridPane {
    private final int year;
    private final float sizeX;
    private final float sizeY;

    public YearlyCalendarWidget() {
        Calendar calendar = Calendar.getInstance();

        this.year = calendar.get(Calendar.YEAR);
        this.sizeX = 450;
        this.sizeY = 600;

        init();
    }

    public YearlyCalendarWidget(int year) {
        this.year = year;
        this.sizeX = 450;
        this.sizeY = 600;

        init();
    }

    public YearlyCalendarWidget(int year, float sizeX) {
        this.year = year;
        this.sizeX = sizeX;
        this.sizeY = sizeX / 3 * 4;

        init();
    }

    public YearlyCalendarWidget(int year, float sizeX, float sizeY) {
        this.year = year;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        init();
    }

    private void init() {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        this.setGridLinesVisible(true);

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                Label label = new Label(months[i * 3 + j]);
                label.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

                MonthlyCalendarWidget monthlyCalendarWidget =
                        new MonthlyCalendarWidget(year, months[i * 3 + j], sizeX / 3, sizeY / 4);

                VBox vBox = new VBox(label, monthlyCalendarWidget);
                vBox.setAlignment(Pos.CENTER);

                this.add(vBox, j, i);
            }
        }
    }

    public int getYear() {
        return year;
    }

    public float getSizeX() {
        return sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }
}
