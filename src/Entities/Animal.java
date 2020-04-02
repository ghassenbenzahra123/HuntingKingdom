/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Fares
 */
public class Animal {
    private int id;
    private String region;
    private String etat;
    private int qteEstim;
    private String saison;
    private String type;
    private String desc;
    
    public Animal(int a, String b, String c, int d, String e, String f, String g)
    {
        this.id = a;
        this.region = b;
        this.etat = c;
        this.qteEstim = d;
        this.saison = e;
        this.type = f;
        this.desc = g;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getQteEstim() {
        return qteEstim;
    }

    public void setQteEstim(int qteEstim) {
        this.qteEstim = qteEstim;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
