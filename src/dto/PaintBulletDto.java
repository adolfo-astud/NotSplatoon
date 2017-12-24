/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author CETECOM
 */
public class PaintBulletDto {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private String color;
    private int id;
    //private String code; //(?)

    public PaintBulletDto() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "color=" + color ;    
    }
    
    
    
}
