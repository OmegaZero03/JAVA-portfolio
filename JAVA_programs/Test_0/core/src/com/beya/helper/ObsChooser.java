package com.beya.helper;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.beya.entities.ObsCreator;

public class ObsChooser {

    public Array<String> entidades;

    public ObsChooser() {
        choices();//cria lista de escolhas



    }
    public void choices() {
        entidades = new Array<String>();

        entidades.add("cookieSquare");
        entidades.add("plateG");
        entidades.add("plateR");
    }

    public String choosed() {

        int start = 0;
        int end = entidades.size - 1;
        int numChoosed = MathUtils.random(start, end);

        return entidades.get(numChoosed);
    }

    public void creatRandonEntitie(){
        String entidade = choosed();

        switch (entidade){

            case "cookieSquare":
                ObsCreator.creatSquareCookies();
                break;

            case "plateG":
                ObsCreator.creatGreenPlate();
                break;

            case "plateR":
                ObsCreator.creatRedPlate();
                break;
        }
    }
}
