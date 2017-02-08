package com.startup.nearbyparking;

/**
 * Created by Eftakhar on 06-02-2017.
 */

public class FareListItem extends Object{




    //String psname;
    String fcar;
    String ncar;
    String fbike;
    String nbike;

    public FareListItem(String fcar, String fbike, String nbike, String ncar) {
        this.fcar = fcar;
        this.fbike = fbike;
        this.nbike = nbike;
        this.ncar = ncar;

    }


    public String getFbike() {
        return fbike;
    }

    public void setFbike(String fbike) {
        this.fbike = fbike;
    }

    public String getFcar() {
        return fcar;
    }

    public void setFcar(String fcar) {
        this.fcar = fcar;
    }

    public String getNbike() {
        return nbike;
    }

    public void setNbike(String nbike) {
        this.nbike = nbike;
    }

    public String getNcar() {
        return ncar;
    }

    public void setNcar(String ncar) {
        this.ncar = ncar;
    }

  /*  public String getPsname() {
        return psname;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }*/
}
