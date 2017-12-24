/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import OurStack.Noded.Stackoon;
import dto.PaintBulletDto;

/**
 *
 * @author Serph
 */
public interface PaintBulletDao extends BaseDao{
    
    public Stackoon GetAllData();
    public void SortById(int order);
    public void switchNodeId(int id1, int id2);
    public PaintBulletDto getMax();
    public PaintBulletDto getMin();
    
}
