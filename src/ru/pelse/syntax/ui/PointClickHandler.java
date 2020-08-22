package ru.pelse.syntax.ui;

import java.util.ArrayList;

public class PointClickHandler {
    private ArrayList<Point> coordinatesList;
    private int amountPoints;

    public PointClickHandler(int amountPoints) {
        this.coordinatesList = new ArrayList<>(amountPoints);
    }

    public void addCoordinate(Point p) {
        coordinatesList.add(p);
    }

    public ArrayList<Point> getCoordinatesList() {
        return coordinatesList;
    }

    public void setCoordinatesList(ArrayList<Point> coordinatesList) {
        this.coordinatesList = coordinatesList;
    }

    @Override
    public String toString() {
        return "PointClickHandler{" +
                "coordinatesList=" + coordinatesList +
                '}';
    }
}