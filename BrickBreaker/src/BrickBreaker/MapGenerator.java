/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author Admin
 */
public class MapGenerator {
    
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public int columns;
    public final Color[] healthToColor = {null,Color.white,Color.yellow,new Color(255,106,6),Color.red,};
    
    public MapGenerator(int row,int col){
        
        columns = col;
        Random r = new Random();
        map = new int[row][col];
        for (int i = 0;i < row;i++){
            for(int j = 0;j< col;j++){
                map[i][j]= r.nextInt(4)+1;
            }
        }
        brickWidth= 540/col;
        brickHeight = 150/row;
    }
    
    public void draw(Graphics2D g){
        for (int i = 0;i < map.length;i++){
            for(int j = 0;j< map[0].length;j++){
                if(map[i][j]> 0){
                    g.setColor(healthToColor[map[i][j]]);
                    g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
                    g.setStroke( new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);                                        
                }
            }
        }
    }
    public void setBrickValue(int value, int row,int col){
        map[row][col]= value;
    }
    
    public int getBrickValue(int row,int col){
        return map[row][col];
    }
}
    
    

