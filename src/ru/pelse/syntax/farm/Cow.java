package ru.pelse.syntax.farm;

public class Cow extends HomeAnimal implements CanBeEaten, GivesResources {
    protected int resourcesAtATime = 3; //дает ресурсов за один раз

    public int getResourcesAtATime() {
        return resourcesAtATime;
    }

    public void setResourcesAtATime(int resourcesAtATime) {
        this.resourcesAtATime = resourcesAtATime;
    }

    @Override
    public int giveResource() {
        if (resource >= resourcesAtATime) resource -= resourcesAtATime;
        if (resource <= 0) {
            System.out.println("Корова больше не дает молоко");
            return 0;
        }
        return this.resourcesAtATime;
    }

    @Override
    public void wasEaten() {
        setOnFarm(false);
    }

}
