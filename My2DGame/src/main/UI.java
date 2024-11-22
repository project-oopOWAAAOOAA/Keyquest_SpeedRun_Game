package main;

import Obj.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    Gamepanel gp;
    Font times_new_roman_40, times_new_roman_80B;

    BufferedImage keyImage;
    public boolean messageON = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");


    public UI(Gamepanel gp)
    {
        this.gp = gp;

        times_new_roman_40 = new Font("Times New Roman",Font.PLAIN, 40);
        times_new_roman_80B = new Font("Times New Roman",Font.BOLD, 80);

        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;

    }

    public void showMessage(String text)
    {
        message = text;
        messageON = true;
    }
    public void draw(Graphics2D g2){

        if(gameFinished == true ){

            g2.setFont(times_new_roman_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

             x = gp.screenWidth/2- textLength/2;
             y = gp.screenHeight/2 - (gp.tileSize*3);
             g2.drawString(text, x, y);

            text = "Your time is:"+dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2- textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*5);
            g2.drawString(text, x, y);

            g2.setFont(times_new_roman_80B);
            g2.setColor(Color.yellow);

            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2- textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        }
        else {
            g2.setFont(times_new_roman_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2,gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x "+gp.player.hasKey,74,65);

            //TIME
            playTime +=(double)1/60;
            g2.drawString("Time:"+dFormat.format(playTime),gp.tileSize*11, 65);

            //MESSAGE

            if(messageON == true)
            {

                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message,gp.tileSize*6,gp.tileSize*4);

                messageCounter++;

                if(messageCounter > 120){
                    messageCounter=0;
                    messageON=false;

                }
            }
        }


    }
}
