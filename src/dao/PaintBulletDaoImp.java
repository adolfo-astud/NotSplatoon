/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import OurStack.Noded.*;
import dto.PaintBulletDto;

/**
 *
 * @author Serph
 */
public class PaintBulletDaoImp implements PaintBulletDao {

    //actúa como base de datos
    public Stackoon bulletStack = new Stackoon();
    
    
    //Carga un bala
    @Override
    public void Register(PaintBulletDto pBullet) {
        ValidateRegister(pBullet);
        bulletStack.pileUp(pBullet);
    }
    
    //quita una bala
    @Override
    public void DeleteBeginning() {
        bulletStack.dropFirst();
    }
    
    //quita un bala del color seleccionado
    @Override
    public boolean DeleteByColor(String color) {
         for (int i = 0; i < bulletStack.getSize(); i++) {
            PaintBulletDto bullet = (PaintBulletDto)bulletStack.GetByIndex(i); 
            if (bullet.getColor().equals(color)){
               return bulletStack.DeleteByIndex(i);
            }
        }
        return false;
    }
    
    
    
    //valida para que no hayan Colores repetidos repetidos
    private void ValidateRegister(PaintBulletDto bullet){
        for (int i = 0; i < bulletStack.getSize(); i++) {
            if(((PaintBulletDto)bulletStack.GetByIndex(i)).getColor().equals(bullet.getColor()))
                throw new IllegalArgumentException("El producto ya está registrado.");
        }
    } 
    
    
    @Override
    public Stackoon GetAllData() {
        return bulletStack;
    }
    
    // Reordena la lista por ID según orden: 0 - ascendente, 1- descendente
    @Override
    public void SortById(int order) {
        for (int i = 0; i < bulletStack.getSize(); i++) {
            for (int j = i + 1; j < bulletStack.getSize(); j++) {
                PaintBulletDto prodTemp = new PaintBulletDto();
                Node n1 = new Node();
                Node n2 = new Node();
                boolean orderCondition = false;
                if(order == 0)
                    orderCondition = (((PaintBulletDto)bulletStack.GetByIndex(i)).getId()) > (((PaintBulletDto)bulletStack.GetByIndex(j)).getId());
                else if(order == 1)
                    orderCondition = (((PaintBulletDto)bulletStack.GetByIndex(i)).getId()) < (((PaintBulletDto)bulletStack.GetByIndex(j)).getId());                
                if (orderCondition) {
                    n1.setValor(((PaintBulletDto)bulletStack.GetByIndex(i)));
                    n2.setValor(((PaintBulletDto)bulletStack.GetByIndex(j)));                     
                    bulletStack.GetNodeByIndex(i).setValor(n2.getValor());
                    bulletStack.GetNodeByIndex(j).setValor(n1.getValor());
                }
            }
        }
        for (int i = 0; i < bulletStack.getSize(); i++) {
        }
    }
    
    // Intercambia lugares de nodos por ID
    public void switchNodeId(int id1, int id2){
        int index1 = 0;
        int index2 = 0;
        Node bulletTemp1 = new Node();
        Node bulletTemp2 = new Node();
        for (int i = 0; i < bulletStack.getSize(); i++) {
            if(((PaintBulletDto)bulletStack.GetByIndex(i)).getId() == id1)
                index1 = i;
            if(((PaintBulletDto)bulletStack.GetByIndex(i)).getId() == id2)
                index2 = i;
        }
        
        bulletTemp1.setValor(bulletStack.GetNodeByIndex(index1).getValor());
        bulletTemp2.setValor(bulletStack.GetNodeByIndex(index2).getValor());
        bulletStack.GetNodeByIndex(index1).setValor(bulletTemp2.getValor());

        bulletStack.GetNodeByIndex(index2).setValor(bulletTemp1.getValor());
    }
    
    // Obtiene la bala con mayor ID
    public PaintBulletDto getMax() {
        if(!bulletStack.isVoid()) {
            PaintBulletDto auxBullet = new PaintBulletDto();
            auxBullet.setId(0);
            for (int i = 0; i < bulletStack.getSize(); i++) {
                if(auxBullet.getId() <= ((PaintBulletDto)bulletStack.GetByIndex(i)).getId())
                    auxBullet = (PaintBulletDto)bulletStack.GetByIndex(i);
                }
            return auxBullet;
        }
        throw new NullPointerException("No hay balas cargadas!");
    }
    
    // Obtiene la bala con menor ID
    public PaintBulletDto getMin() {
        if(!bulletStack.isVoid()){
            PaintBulletDto auxBullet = getMax();
            for (int i = 0; i < bulletStack.getSize(); i++) {
                if(auxBullet.getId() > ((PaintBulletDto)bulletStack.GetByIndex(i)).getId())
                    auxBullet = (PaintBulletDto)bulletStack.GetByIndex(i);
                }
            return auxBullet;
        }
        throw new NullPointerException("No hay balas cargadas!");
    }
    
}
