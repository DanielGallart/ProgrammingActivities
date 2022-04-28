package com.example.fightgame.model;

public abstract class Fighter extends GameCharacter {
    int victories;
    int defeats;
    public abstract boolean fight(GameCharacter opponent);

    public Fighter(String nom, int strength, int agility, int endurance, int intellect, int spirit) {
        super(nom, strength, agility, endurance, intellect, spirit);
    }
    public void win(){
        victories ++;
    }
    public void lose(){
        loseLive();
        defeats++;
    }

    public int getVictories(){
        return victories;
    }

    public int getDefeat(){
        return defeats;
    }

    @Override
    public String toString() {
        return super.toString() +
                " victories=" + victories +
                ", defeats=" + defeats
                ;
    }
}
