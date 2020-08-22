package ru.pelse.syntax.ui;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    public void paintComponent (Graphics g) {
        //image size is '700 x 430'
        Image image = new ImageIcon("sources/jframe_img/praga.gif").getImage();
        g.drawImage(image, 2, 2, this);
    }
}
