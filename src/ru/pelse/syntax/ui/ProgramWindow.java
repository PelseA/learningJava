package ru.pelse.syntax.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProgramWindow extends JFrame {
    EventHandler eventHandler;
    JButton getResult, changeCoordinates, checkFrom, checkTo;
    int minX = 15, maxX = 750, minY = 35, maxY = 520;
    MapPanel mapPanel;

    public ProgramWindow(String title) throws HeadlessException {
        super(title);
        eventHandler = new EventHandler();
        //стиль шрифта
        Font font = new Font("Sans-serif", Font.ITALIC, 12);
        //правая панель (с кнопками)
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));

        JLabel description = new JLabel();
        description.setFont(font);
        description.setForeground(Color.RED);
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setText("<html>Планируется высадка марсиан <br>" +
                "безопасное перемещение <br> возможно только <br>" +
                "в периметре треугольника</html>");
        checkFrom = new JButton("Отметить место отправления");
        checkTo = new JButton("Отметить место прибытия");
        getResult = new JButton("Узнать");
        changeCoordinates = new JButton("Изменить координаты");
        //добавить слушателя события
        checkFrom.addActionListener(eventHandler);
        checkTo.addActionListener(eventHandler);
        getResult.addActionListener(eventHandler);
        changeCoordinates.addActionListener(eventHandler);
        //поместить компоненты на панель
        buttonPanel.add(description);
        buttonPanel.add(checkFrom);
        buttonPanel.add(checkTo);
        buttonPanel.add(getResult);
        buttonPanel.add(changeCoordinates);

        //Панель с кнопками будет расположена справа (Восток)
        JPanel panelEast = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        panelEast.add(buttonPanel, gbc);

        //Панель с картой
        mapPanel = new MapPanel();
        mapPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        this.add(panelEast, BorderLayout.EAST);
        this.add(mapPanel);
        this.pack();
        this.setVisible(true);
        //image size is '760 x 510'
        this.setSize(950, 545);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //зафиксировать размер окна
        this.setResizable(false);
        //расположить окно по центру экрана (по умолчанию оно в левом верхнем углу)
        this.setLocationRelativeTo(null);
    }

    int randomX() {
        return minX + (int)(Math.random()*((maxX - minX) + 1));
    }

    int randomY() {
        return minY + (int)(Math.random()*((maxY - minY) + 1));
    }

    //вложенный класс
    public class EventHandler implements ActionListener {
        //метод вызывется при каждом событии мыши, клавиатуры
        public void actionPerformed(ActionEvent e) {
            //проверяем, на каком элементе произошло событие
            if (e.getSource() == getResult) {
                //добавить три точки на карту
                LightweightPoint point1 = new LightweightPoint(Color.BLUE);
                LightweightPoint point2 = new LightweightPoint(Color.BLUE);
                LightweightPoint point3 = new LightweightPoint(Color.BLUE);
                point1.setBounds(randomX(), randomY(), 12, 12);
                point2.setBounds(randomX(), randomY(), 12, 12);
                point3.setBounds(randomX(), randomY(), 12, 12);
                mapPanel.add(point1);
                mapPanel.add(point2);
                mapPanel.add(point3);
                mapPanel.repaint();
            }
            if(e.getSource() == checkFrom) {
                PointClickHandler pointClickHandler = new PointClickHandler(10);
                checkFrom.getRootPane().addMouseListener(new MouseAdapter() {
                    LightweightPoint clickPoint;
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        super.mouseClicked(event);
                        Point point = new Point(event.getX(), event.getY());
                        pointClickHandler.addCoordinate(point);
                        clickPoint = new LightweightPoint(Color.RED);
                        setLayout(null);
                        clickPoint.setBounds(event.getX(), event.getY(), 12, 12);
                        mapPanel.add(clickPoint);
                        mapPanel.repaint();
                        System.out.println(pointClickHandler.getCoordinatesList());
                        checkFrom.getRootPane().removeMouseListener(this);
                    }
                });
            }
            if(e.getSource() == checkTo) {
                PointClickHandler pointClickHandler = new PointClickHandler(10);
                checkTo.getRootPane().addMouseListener(new MouseAdapter() {
                    LightweightPoint clickPoint;
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        super.mouseClicked(event);
                        Point point = new Point(event.getX(), event.getY());
                        pointClickHandler.addCoordinate(point);
                        clickPoint = new LightweightPoint(Color.RED);
                        setLayout(null);
                        clickPoint.setBounds(event.getX(), event.getY(), 12, 12);
                        mapPanel.add(clickPoint);
                        mapPanel.repaint();
                        System.out.println(pointClickHandler.getCoordinatesList());
                        checkTo.getRootPane().removeMouseListener(this);
                    }
                });
            }
            //очистить результат
            if(e.getSource() == changeCoordinates) {
                PointClickHandler pointClickHandler = new PointClickHandler(10);
                addMouseListener(new MouseAdapter() {
                    //LightweightPoint clickPoint;
                    @Override
                    public void mouseClicked(MouseEvent event) {
                            super.mouseClicked(event);
                            Point point = new Point(event.getX(), event.getY());
                            pointClickHandler.addCoordinate(point);
                            LightweightPoint clickPoint = new LightweightPoint(Color.GREEN);
                            setLayout(null);
                            clickPoint.setBounds(event.getX(), event.getY(), 5, 5);
                            getContentPane().add(clickPoint);
                            getContentPane().repaint();
                        System.out.println(pointClickHandler.getCoordinatesList());
                    }
                });
            }
        }
    }

    // легковесный компонент - закрашенная точка(на самом деле Oval)
    public class LightweightPoint extends Component {
        private Color color;

        public LightweightPoint(Color color) {
            this.color = color;
        }
        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(0, 0, 10, 10);
        }
    }
}
