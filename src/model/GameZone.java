package model;

import java.awt.*;

/**
 * Created by djiby on 02/01/18.
 */
public class GameZone {

    private int abcisse;
    private int ordonnee;
    private int width;
    private int height;
    private Color borderColour;

    public GameZone() {}

    public GameZone(int abcisse, int ordonnee, int width, int height, Color borderColour) {
        this.abcisse = abcisse;
        this.ordonnee = ordonnee;
        this.width = width;
        this.height = height;
        this.borderColour = borderColour;
    }

    public int getAbcisse() {
        return abcisse;
    }

    public void setAbcisse(int abcisse) {
        this.abcisse = abcisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getBorderColour() {
        return borderColour;
    }

    public void setBorderColour(Color borderColour) {
        this.borderColour = borderColour;
    }

    public void DrawZone(){

    }
}