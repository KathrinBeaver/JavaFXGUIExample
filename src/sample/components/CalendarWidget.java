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
import java.util.Calendar;
import java.util.Locale;

public class CalendarWidget extends GridPane {
    private final int year;
    private final String month;
    private final double sizeX;
    private final double sizeY;
    private final String[] weekDays;

    public CalendarWidget() {
        Calendar calendar = Calendar.getInstance();

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("en"));
        this.sizeX = 300;
        this.sizeY = 300;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(boolean isRu) {
        Calendar calendar = Calendar.getInstance();

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("en"));
        this.sizeX = 300;
        this.sizeY = 300;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(int year, String month) {
        this.year = year;
        this.month = month;
        this.sizeX = 300;
        this.sizeY = sizeX;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(int year, String month, boolean isRu) {
        this.year = year;
        this.month = month;
        this.sizeX = 300;
        this.sizeY = sizeX;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(int year, String month, double sizeX) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeX;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(int year, String month, double sizeX, boolean isRu) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeX;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(int year, String month, double sizeX, double sizeY) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.weekDays = new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    public CalendarWidget(int year, String month, double sizeX, double sizeY, boolean isRu) {
        this.year = year;
        this.month = month;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.weekDays = isRu ? new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"} :
                new String[]{"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        init();
    }

    private void init() {
        this.setPrefSize(sizeX, sizeY);

        Calendar calendar = Calendar.getInstance();
        switch (month) {
            case "January" -> calendar.set(year, Calendar.JANUARY, 1);
            case "February" -> calendar.set(year, Calendar.FEBRUARY, 1);
            case "March" -> calendar.set(year, Calendar.MARCH, 1);
            case "April" -> calendar.set(year, Calendar.APRIL, 1);
            case "May" -> calendar.set(year, Calendar.MAY, 1);
            case "June" -> calendar.set(year, Calendar.JUNE, 1);
            case "July" -> calendar.set(year, Calendar.JULY, 1);
            case "August" -> calendar.set(year, Calendar.AUGUST, 1);
            case "September" -> calendar.set(year, Calendar.SEPTEMBER, 1);
            case "October" -> calendar.set(year, Calendar.OCTOBER, 1);
            case "November" -> calendar.set(year, Calendar.NOVEMBER, 1);
            case "December" -> calendar.set(year, Calendar.DECEMBER, 1);
        }

        for (int i = 0; i < weekDays.length; ++i) {
            Label label = new Label(weekDays[i]);
            label.setFont(Font.font("Verdana", FontWeight.BOLD, sizeX / 25));
            label.setTextFill(i > 4 ? Color.RED : Color.BLACK);
            label.setAlignment(Pos.CENTER);
            label.setPrefSize(sizeX / 7, sizeY / 7);

            this.add(label, i, 0);
        }

        ArrayList<Button> buttonArrayList = new ArrayList<>();

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < weekDays.length; ++j) {
                Button button = new Button();
                button.setFont(Font.font("Verdana", sizeX / 25));
                button.setTextFill(j > 4 ? Color.RED : Color.BLACK);
                button.setAlignment(Pos.CENTER);
                button.setPrefSize(sizeX / 7, sizeY / 7);

                buttonArrayList.add(button);
                this.add(button, j, i + 1);
            }
        }

        int daysAmount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int start = weekDay == 1 ? weekDay + 4 : weekDay - 3;
        int i = 0;

        calendar = Calendar.getInstance();
        int day = year == calendar.get(Calendar.YEAR) &&
                month == calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("en")) ?
                calendar.get(Calendar.DAY_OF_MONTH) : -1;

        for (Button button : buttonArrayList) {
            if (i == day + 1) {
                button.setFont(Font.font("Verdana", FontWeight.BOLD, sizeX / 25));
                button.setTextFill(Color.GREEN);
            }

            if (i > start && daysAmount >= -start) {
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
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

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }
}
