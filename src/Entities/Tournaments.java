/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author farou
 */
public class Tournaments {
            private ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        
        this.imageView = imageView;
    }       private int Game_id; 

    public int getGame_id() {
        return Game_id;
    }

    public void setGame_id(int Game_id) {
        this.Game_id = Game_id;
    }       private String team_name;

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
            private int tr_id;
            private String tr_cover;
            private Games games;
            private int team1_id;
            private int team2_id;
            private int team3_id;
            private int team4_id;

    public Tournaments(int tr_id, String tr_cover, int Game_id, int team1_id, int team2_id, int team3_id, int team4_id) {
        this.tr_id = tr_id;
        this.tr_cover = tr_cover;
        this.Game_id = Game_id;
        this.team1_id = team1_id;
        this.team2_id = team2_id;
        this.team3_id = team3_id;
        this.team4_id = team4_id;
    }

    public Tournaments() {
    }

    public int getTr_id() {
        return tr_id;
    }

    public void setTr_id(int tr_id) {
        this.tr_id = tr_id;
    }

    public String getTr_cover() {
        return tr_cover;
    }

    public void setTr_cover(String tr_cover) {
        this.tr_cover = tr_cover;
    }

    public  Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public int getTeam1_id() {
        return team1_id;
    }

    public void setTeam1_id(int team1_id) {
        this.team1_id = team1_id;
    }

    public int getTeam2_id() {
        return team2_id;
    }

    public void setTeam2_id(int team2_id) {
        this.team2_id = team2_id;
    }

    public int getTeam3_id() {
        return team3_id;
    }

    public void setTeam3_id(int team3_id) {
        this.team3_id = team3_id;
    }

    public int getTeam4_id() {
        return team4_id;
    }

    public void setTeam4_id(int team4_id) {
        this.team4_id = team4_id;
    }

    @Override
    public String toString() {
        return "Tournaments{" + "tr_id=" + tr_id + ", tr_cover=" + tr_cover + ", game_id=" + games + ", team1_id=" + team1_id + ", team2_id=" + team2_id + ", team3_id=" + team3_id + ", team4_id=" + team4_id + '}';
    }

 
    
}
