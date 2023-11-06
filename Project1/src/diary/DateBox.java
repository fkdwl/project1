package diary;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;

public class DateBox extends JButton {

    String day;
    Color color;
    int width;
    int height;

    public DateBox(String day, Color color, int width, int height) {
        super(day);
        this.day = day;
        this.color = color;
        this.width = width;
        this.height = height;
        setBackground(color);
        setPreferredSize(new Dimension(width, height));
    }

    public void updateDate(String day) {
        this.day = day;
        setText(day);
    }
}