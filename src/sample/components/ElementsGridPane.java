package sample.components;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class ElementsGridPane extends GridPane {

    protected final int WEEKS_OF_MONTH = 6;
    protected final int DAYS_OF_WEEK = 7;

    public ElementsGridPane() {
        fillContent();
    }

    private void fillContent() {
        this.setGridLinesVisible(true);
        RowConstraints firstRow = new RowConstraints();
        firstRow.setPercentHeight(10);
        this.getRowConstraints().add(firstRow);
        for (int i = 0; i < DAYS_OF_WEEK; i++) {
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(30);
            this.getColumnConstraints().add(column1);
        }

        for (int i = 0; i < WEEKS_OF_MONTH; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(30);
            this.getRowConstraints().add(row);
        }

        this.add(new Label("ПН"), 0, 0);
        this.add(new Label("ВТ"), 1, 0);
        this.add(new Label("СР"), 2, 0);
        this.add(new Label("ЧТ"), 3, 0);
        this.add(new Label("ПТ"), 4, 0);
        this.add(new Label("СБ"), 5, 0);
        this.add(new Label("ВС"), 6, 0);

        int dayOfWeek = 0;
        int numOfWeek = 1;
        for (int day = 1; day < 32; day++) {
            this.add(new Label("" + day), dayOfWeek, numOfWeek);
            dayOfWeek++;
            if (!(dayOfWeek % 7 > 0)) {
                dayOfWeek = day % 7;
                numOfWeek++;
            }
        }
    }

}
