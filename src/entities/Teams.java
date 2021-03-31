/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author iyadh
 */
public class Teams {
            private SimpleIntegerProperty team_id;
             private SimpleStringProperty  team_name;
             private SimpleStringProperty team_logo;
           private SimpleStringProperty Team_Website;
            private SimpleIntegerProperty user1_id;
           private SimpleIntegerProperty  user2_id;
          private SimpleIntegerProperty  user3_id;
            private SimpleIntegerProperty user4_id;
           private SimpleIntegerProperty user5_id;

    public Teams() {
    }

    public Teams(int team_id, String team_name, String team_logo, String Team_Website, int user1_id, int user2_id, int user3_id, int user4_id, int user5_id) {
        this.team_id = new SimpleIntegerProperty(team_id);
        this.team_name = new SimpleStringProperty(team_name);
        this.team_logo = new SimpleStringProperty(team_logo);
        this.Team_Website = new SimpleStringProperty(Team_Website);
        this.user1_id = new SimpleIntegerProperty(user1_id);
        this.user2_id = new SimpleIntegerProperty(user2_id);
        this.user3_id = new SimpleIntegerProperty(user3_id);
        this.user4_id = new SimpleIntegerProperty(user4_id);
        this.user5_id = new SimpleIntegerProperty(user5_id);
    }

    public Teams(String team_name, String team_logo, String Team_Website, int user1_id, int user2_id, int user3_id, int user4_id, int user5_id) {
       this.team_name = new SimpleStringProperty(team_name);
        this.team_logo = new SimpleStringProperty(team_logo);
        this.Team_Website = new SimpleStringProperty(Team_Website);
        this.user1_id = new SimpleIntegerProperty(user1_id);
        this.user2_id = new SimpleIntegerProperty(user2_id);
        this.user3_id = new SimpleIntegerProperty(user3_id);
        this.user4_id = new SimpleIntegerProperty(user4_id);
        this.user5_id = new SimpleIntegerProperty(user5_id);
    }

  /*  public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_logo() {
        return team_logo;
    }

    public void setTeam_logo(String team_logo) {
        this.team_logo = team_logo;
    }

    public String getTeam_Website() {
        return Team_Website;
    }

    public void setTeam_Website(String Team_Website) {
        this.Team_Website = Team_Website;
    }

    public int getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(int user1_id) {
        this.user1_id = user1_id;
    }

    public int getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(int user2_id) {
        this.user2_id = user2_id;
    }

    public int getUser3_id() {
        return user3_id;
    }

    public void setUser3_id(int user3_id) {
        this.user3_id = user3_id;
    }

    public int getUser4_id() {
        return user4_id;
    }

    public void setUser4_id(int user4_id) {
        this.user4_id = user4_id;
    }

    public int getUser5_id() {
        return user5_id;
    }

    public void setUser5_id(int user5_id) {
        this.user5_id = user5_id;
    }

    @Override
    public String toString() {
        return "Teams{" + "team_id=" + team_id + ", team_name=" + team_name + ", team_logo=" + team_logo + ", Team_Website=" + Team_Website + ", user1_id=" + user1_id + ", user2_id=" + user2_id + ", user3_id=" + user3_id + ", user4_id=" + user4_id + ", user5_id=" + user5_id + '}';
    }
           
   */        

    public int getTeam_id() {
        return team_id.get();
    }

    public String getTeam_name() {
        return team_name.get();
    }

    public String getTeam_logo() {
        return team_logo.get();
    }

    public String getTeam_Website() {
        return Team_Website.get();
    }

    public int getUser1_id() {
        return user1_id.get();
    }

    public int getUser2_id() {
        return user2_id.get();
    }

    public int getUser3_id() {
        return user3_id.get();
    }

    public int getUser4_id() {
        return user4_id.get();
    }

    public int getUser5_id() {
        return user5_id.get();
    }
           
}
