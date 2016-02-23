/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasventure;

import java.io.*;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Tobias
 */
public class Dungeon {
    
    private String title;
    private int sx,sy;
    private String[][] feld = new String[35][35];
    
    public Dungeon(int level) throws IOException{
        String lvl = String.valueOf(level);
        String path = System.getProperty("java.class.path");
        FileReader fr;
        fr = new FileReader(path+"/hasventure/"+lvl+".csv");
        BufferedReader br = new BufferedReader(fr);

        String zeile = "";
        String[] tiles;
        int row = 0;
        while( (zeile = br.readLine()) != null ) {
            tiles = zeile.split(",");
            if(tiles[0].equals("1")){
                title = tiles[1];
                System.out.println(title);
            } else {
                for(int i=0; i<tiles.length; i++){
                    if(tiles[i].equals("G")){
                        feld[row][i] = "G";
                    } else if(tiles[i].equals("B")){
                        feld[row][i] = "B";
                    } else if(tiles[i].equals("S")){
                        feld[row][i] = "S";
                        sx = row;
                        sy = i;
                    } else if(tiles[i].equals("C")){
                        feld[row][i] = "C";
                    }
                }
            }
            row++;
        }

        br.close();
    }

    public String getTitle() {
        return title;
    }
    
    public String[][] getDungeonTiles(){
        return feld;
    }
    
    public int spawnX(){
        return sx;
    }
    
    public int spawnY(){
        return sy;
    }
    
}
