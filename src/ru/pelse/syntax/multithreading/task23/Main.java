package ru.pelse.syntax.multithreading.task23;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Реализовать сигнализации, реагирующие на повышение температуры.
        //Класс Sensor инкрементально повышает температуру, и на каждое изменение
        // температуры оповещает слушателей.
        // Их должно быть три, соответствующие уровням тревоги: Green - 100, Yellow - 300, Red - 600.
        //Описываете интерфейс Alarm, имеющий метод void tempChanged(int temp), и подписываете
        // три реализации к датчику на оповещения.
        //Сигнализации сработают по преодолению определенного порога температуры:
        //100 градусов - Green
        //300 градусов - Green, Yellow
        //600 градусов - Green, Yellow, Red
        //
        //Срабатывание - вывод в консоль сообщения. Если сигнализация сработала, то сообщение
        // не повторяется на дальнейшее повышение температуры, но если опустится ниже порога,
        // а потом опять преодолеет, то выведется снова.

        Alarm greenSign = temperature -> { //пример с лямбда
            if (temperature >= 100) System.out.println("Достигнут порог в 100 градусов");
        };

        Alarm yellowSign = new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if (temp >= 300) System.out.println("Достигнут порог в 300 градусов");
            }
        };
        Alarm redSign = new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if (temp >= 600) System.out.println("Достигнут порог в 600 градусов");
            }
        };

        Sensor sensor = new Sensor(50);
        sensor.addListener(yellowSign);
        sensor.addListener(greenSign);
        sensor.addListener(redSign);
        sensor.increaseTemperature();
    }
}

interface Alarm {
    void tempChanged(int temperature);
}

class Sensor {

    private int initialTemperature;

    private ArrayList<Alarm> listeners = new ArrayList<>();

    public void addListener(Alarm tempChanged) {
        listeners.add(tempChanged);
    }

    public void removeListener(Alarm tempChanged) {
        listeners.remove(tempChanged);
    }

    public Sensor(int initialTemperature) {
        this.setInitialTemperature(initialTemperature);
    }

    public int getInitialTemperature() {
        return initialTemperature;
    }

    public void setInitialTemperature(int initialTemperature) {
        this.initialTemperature = initialTemperature;
    }

    public void increaseTemperature() {
        while (true) {
            if (getInitialTemperature() >= 600) {
                notifyListeners(listeners, getInitialTemperature());
                break;
            } else {
                notifyListeners(listeners, getInitialTemperature());
                setInitialTemperature(getInitialTemperature() + 50);
            }
        }
    }

    public void notifyListeners(ArrayList<Alarm> listeners, int temperature) {
        listeners.forEach(listener -> listener.tempChanged(temperature));
    }
}
