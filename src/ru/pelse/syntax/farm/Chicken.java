package ru.pelse.syntax.farm;

public class Chicken extends HomeAnimal implements GivesResources {
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
            System.out.println("Курица больше не несется");
            return 0;
        }
        return this.resourcesAtATime;
    }
}
