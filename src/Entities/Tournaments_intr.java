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
public class Tournaments_intr {
            private int tr_id;
            private String tr_cover;

    public Tournaments_intr(int tr_id, String tr_cover, String tr_link) {
        this.tr_id = tr_id;
        this.tr_cover = tr_cover;
        this.tr_link = tr_link;
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

    @Override
    public String toString() {
        return "Tournaments_intr{" + "tr_id=" + tr_id + ", tr_cover=" + tr_cover + ", tr_link=" + tr_link + '}';
    }

    public void setTr_cover(String tr_cover) {
        this.tr_cover = tr_cover;
    }

    public String getTr_link() {
        return tr_link;
    }

    public void setTr_link(String tr_link) {
        this.tr_link = tr_link;
    }

    public Tournaments_intr() {
    }
            private String tr_link;
          
}
