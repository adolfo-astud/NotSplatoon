/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PaintBulletDto;

/**
 *
 * @author CETECOM
 */
public interface BaseDao {
    
    public void Register(PaintBulletDto pBullet);
    public void DeleteBeginning();
    public boolean DeleteByColor(String color);
    
    
}
