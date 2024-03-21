package com.beya.helper;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class ObsChooser {

    public Array<String> entidades;

    public ObsChooser() {
        choices();//cria lista de escolhas



    }
    public void choices() {
        entidades = new Array<String>();

        entidades.add("cookieSquare");

        //Variantes de placas

        //Verdes
        entidades.add("plateG");
        entidades.add("PlateGArcCoins");

        //Vermelhas
        entidades.add("plateR");
        entidades.add("PlateRArcCoins");

        //Azuis
        entidades.add("plateB");
        entidades.add("PlateBArcCoins");

        //Variantes de cones
        entidades.add("cone");
        entidades.add("coneCoin");
        entidades.add("2cones2coins");
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

            case "PlateGArcCoins":
                ObsCreator.creatGPlateArcCoins();
                break;

            case "PlateRArcCoins":
                ObsCreator.creatRPlateArcCoins();
                break;

            case "PlateBArcCoins":
                ObsCreator.creatBPlateArcCoins();
                break;

            case "plateR":
                ObsCreator.creatRedPlate();
                break;

            case "plateB":
                ObsCreator.creatBluePlate();
                break;

            case "cone":
                ObsCreator.creatCone(20f);
                break;

            case "coneCoin":
                ObsCreator.creatConeCoin();
                break;

            case "2cones2coins":
                ObsCreator.creat2ones2coins();
                break;

        }
    }
}
