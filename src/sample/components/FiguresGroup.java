package sample.components;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FiguresGroup extends Group {

    public FiguresGroup() {
        fillContent();
    }

    private void fillContent() {
        Canvas canvas = new Canvas(300, 275); // создаем новый объект Canvas с шириной 300px, и высотой 275px
        this.getChildren().add(canvas); // добавляем его в корневой контейнер
        GraphicsContext context = canvas.getGraphicsContext2D(); // и получаем GraphicContext

        context.setFill(Color.BLUE); // устанавливаем цвет
        context.fillOval(10, 20, 50, 50); // рисуем овал с левым верхним углом в точке (10;20) и высотой = ширине = 50px

        context.setFill(Color.GREEN);
        context.fillRect(200, 50, 60, 90); // рисуем прямоугольник 60x90px с левым верхим углом в точке (200; 50)

        context.setFill(Color.CRIMSON);
        context.fillPolygon(
                new double[]{100, 160, 80}, // X координаты вершин
                new double[]{70, 90, 220}, // Y координаты вершин
                3 // количество вершин
        );

        context.setFill(Color.ORANGE);
        context.setFont(Font.font("Consolas", FontWeight.BOLD, 18)); // устанавливаем шрифт
        context.fillText("Figures Panel", 10, 254); // рисуем текст в точке (10, 254)
    }

}
