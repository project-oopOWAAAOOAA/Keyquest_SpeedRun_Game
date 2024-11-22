package Obj;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends  SuperObject{

    public OBJ_Door(){

        name = "Door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objs/door.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision=true;
    }

}
