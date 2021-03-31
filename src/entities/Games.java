/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
  
import javafx.scene.image.ImageView;

/**
 *
 * @author farou
 */
        public class Games {

      private ImageView imageView;

            private int game_id;
            private String game_name;
            private String game_cover;
            private String description;

        public Games() {

        }
         public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    
    
    
    
    
    

    public Games(int game_id, String game_name, String game_cover, String description) {
        this.game_id = game_id;
        this.game_name = game_name;
        this.game_cover = game_cover;
        this.description = description;
    }
        

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getGame_cover() {
        return game_cover;
    }

    public void setGame_cover(String game_cover) {
        this.game_cover = game_cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Games{" + "game_id=" + game_id + ", game_name=" + game_name + ", game_cover=" + game_cover + ", description=" + description + "}\n";
    }

}
