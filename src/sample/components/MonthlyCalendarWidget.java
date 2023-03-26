package sample.components;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class MonthlyCalendarWidget extends GridPane {
    private final int year;
    private final String month;
    private final float sizeX;
    private final float sizeY;
    private final String[] weekDays;

    public MonthlyCalendarWidget() {
        Calendar calendar = Calendar.getInstance();

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("en"));
        this.sizeX = 300;
        this.sizeY = 300;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(boolean isRu) {
        Calendar calendar = Calendar.getInstance();

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("en"));
        this.sizeX = 300;
        this.sizeY = 300;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(int year, String month) {
        this.year = year;
        this.month = month;
        this.sizeX = 300;
        this.sizeY = sizeX;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(int year, String month, boolean isRu) {
        this.year = year;
        this.month = month;
        this.sizeX = 300;
        this.sizeY = sizeX;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(int year, String month, float sizeX) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeX;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(int year, String month, float sizeX, boolean isRu) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeX;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(int year, String month, float sizeX, float sizeY) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public MonthlyCalendarWidget(int year, String month, float sizeX, float sizeY, boolean isRu) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    private void init() {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        ArrayList<Button> buttonArrayList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Arrays.asList(months).indexOf(month), 1);
        int daysAmount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int start = weekDay == 1 ? weekDay + 4 : weekDay - 3;

        calendar = Calendar.getInstance();
        int day = year == calendar.get(Calendar.YEAR) &&
                month.equals(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("en"))) ?
                calendar.get(Calendar.DAY_OF_MONTH) : -2;

        this.setPrefSize(sizeX, sizeY);

        for (int i = 0; i < weekDays.length; ++i) {
            Label label = new Label(weekDays[i]);
            label.setFont(Font.font("Verdana", FontWeight.BOLD, sizeX / 20));
            label.setTextFill(i > 4 ? Color.RED : Color.BLACK);
            label.setAlignment(Pos.CENTER);
            label.setPrefSize(sizeX / 7, sizeY / 7);

            this.add(label, i, 0);
        }

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < weekDays.length; ++j) {
                Button button = new Button();
                button.setFont(Font.font("Verdana", sizeX / 20));
                button.setTextFill(j > 4 ? Color.RED : Color.BLACK);
                button.setAlignment(Pos.CENTER);
                button.setPrefSize(sizeX / 7, sizeY / 7);

                buttonArrayList.add(button);
                this.add(button, j, i + 1);
            }
        }

        int i = 0;

        for (Button button : buttonArrayList) {
            if (i == day + 1) {
                button.setStyle("-fx-border-color: green");
                button.setTextFill(Color.GREEN);
            }

            if (i > start && daysAmount >= -start) {
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        onButtonAction(button, month, year);
                    }
                });
                button.setText(String.valueOf(i - start));
            } else {
                button.setDisable(true);
            }

            --daysAmount;
            ++i;
        }
    }

    private void onButtonAction(Button button, String month, int year) {
        System.out.println(button.getText() + " " + month + " " + year);
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public float getSizeX() {
        return sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }
}
