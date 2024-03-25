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


        //Cookies
        entidades.add("cookieSquare");
        entidades.add("4cookies");

        //**************Variantes de Obstáculos**************\\

            //PLACAS

                //Verdes
        entidades.add("plateG");
        entidades.add("PlateGArcCoins");

                //Verdes Duplas
        entidades.add("plateDoubleG");
        entidades.add("plateDoubleGCoins");

                //Vermelhas
        entidades.add("plateR");
        entidades.add("PlateRArcCoins");

                //Azuis
        entidades.add("plateB");
        entidades.add("PlateBArcCoins");

            //CONES
                //Variantes de cones
        entidades.add("cone");
        entidades.add("coneCoin");
        entidades.add("2cones2coins");

            //RAROS
                //Orelhão
        entidades.add("orelhao");
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

            //**************Variantes de Obstáculos**************\\

            //Variantes de cookies
            case "cookieSquare":
                ObsCreator.creatSquareCookies();
                break;
            case "4cookies":
                ObsCreator.creat4cookies();
                break;

                //PLACAS

                    //Vermelhas
            case "plateG":
                ObsCreator.creatGreenPlate();
                break;
            case "PlateGArcCoins":
                ObsCreator.creatGPlateArcCoins();
                break;

                    //Verdes
            case "PlateRArcCoins":
                ObsCreator.creatRPlateArcCoins();
                break;
            case "plateR":
                ObsCreator.creatRedPlate();
                break;

                    //Verdes Duplas
            case "plateDoubleG":
                ObsCreator.creatDoubleGreen();
                break;
            case "plateDoubleGCoins":
                ObsCreator.creatDoubleGreenSquareCoins();
                break;

                    //Azuis
            case "plateB":
                ObsCreator.creatBluePlate();
                break;
            case "PlateBArcCoins":
                ObsCreator.creatBPlateArcCoins();
                break;

                //CONES

                    //Variantes de cones
            case "cone":
                ObsCreator.creatCone(20f);
                break;
            case "coneCoin":
                ObsCreator.creatConeCoin();
                break;
            case "2cones2coins":
                ObsCreator.creatConeCoin();
                int count = 0;
                while(count < 10){
                    count++;
                }
                ObsCreator.creatConeCoin();
                break;

                //RAROS
            case "orelhao":
                ObsCreator.creatOrelhao();
                break;

        }
    }
}
