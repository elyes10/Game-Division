/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author farou
 */
public class Tournaments {
            private int tr_id;
            private String tr_cover;
            private int game_id;
            private int team_id;

    public Tournaments(int tr_id, String tr_cover, int game_id, int team_id) {
        this.tr_id = tr_id;
        this.tr_cover = tr_cover;
        this.game_id = game_id;
        this.team_id = team_id;
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

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "Tournaments{" + "tr_id=" + tr_id + ", tr_cover=" + tr_cover + ", game_id=" + game_id + ", team_id=" + team_id + '}';
    }

    
}
