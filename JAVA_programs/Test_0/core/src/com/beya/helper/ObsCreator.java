package com.beya.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.beya.entities.Entity;
import com.beya.entities.Obstaculo;
import com.beya.entities.Sprite;
import com.beya.helper.ObsChooser;
import com.beya.main.Test;

public class ObsCreator implements Entity {

    private ObsChooser chooser;

    public static float handPlateY = 3.4f;

    public float time;

    private float timeToCreat;
    private  float plateChooser;
    private String entiteName = "obstaculo";

    public ObsCreator(){

        chooser = new ObsChooser();
        //Test.entities.add(this);

        setTimer(2f, 6f); //Setando e resetando o timer


    }

    @Override
    public void tick() {
        float timeCalculator = ((Gdx.graphics.getDeltaTime() * 100)/60f);
        time += timeCalculator;


        if(time > timeToCreat){
            //creatPoles();

            chooser.creatRandonEntitie();
            setTimer(2f, 6f); //Reseta e seta próximo timer
        }
    }

    @Override
    public void render(SpriteBatch batch) {return;}

    @Override
    public void destroy() {}

    public static void creatRedPlate(){new Obstaculo();}

    public void setTimer(float min, float max){
        timeToCreat = MathUtils.random(min, max);
        time = 0;
    }

    public static void creatGreenPlate(){

        //Criando Objeto do obstaculo
        new Obstaculo(
                20f,
                3.3f,
                0.4f,
                0.4f,
                1f,
                1f,
                1,
                128,
                128,
                0,
                5,
                .1f,
                "green_plate"
        );
    }


    public static void creatGPlateArcCoins(){
        creatArcCoins(20f, 4.6f);
        creatGreenPlate();
    }

    public static void creatRPlateArcCoins(){
        creatArcCoins(20f, 4.9f);
        creatRedPlate();
    }

    public static void creatBPlateArcCoins(){
        creatArcCoins(20f, 4.6f);
        creatBluePlate();
    }

    public static void creatBluePlate(){

        //Criando Objeto do obstaculo
        new Obstaculo(
                20f,
                3.3f,
                0.4f,
                0.4f,
                1f,
                1f,
                1,
                128,
                128,
                0,
                4,
                .1f,
                "blue_plate"
        );
    }
    public static void creatCone(float x){

        //Criando Objeto do obstaculo
        new Obstaculo(
                x,
                2.9f,
                0.2f,
                0.2f,
                1f,
                1f,
                1,
                128,
                128,
                0,
                6,
                -.3f,
                "cone"
        );
    }

    public static void creat2ones2coins(){
        float xx = 20f;
        float distance = 2f;

        for(int i=0; i<2; i++){
            creatCookie(xx, 3.5f);
            creatCone(xx);
            xx+=distance;
        }
    }

    public static void creatConeCoin(){
        creatCookie(20f, 3.5f);
        creatCone(20f);

    }


    public static void creatCookie(float x, float y){
        new Obstaculo(
                x,
                y,
                0.2f,
                0.2f,
                .8f,
                .8f,
                7,
                Sprite.COOKIE_TEXTURE,
                128,
                128,
                1,
                0,
                0f,
                "cookie",
                true
        );
    }

    public static void creatArcCoins(float xx, float yy){
        creatCookie(xx - .7f, yy - .3f);
        creatCookie(xx - .4f, yy + .3f);
        creatCookie(xx + .4f, yy + .3f);
        creatCookie(xx + .7f, yy -.3f);
        creatCookie(xx, yy + .8f);
    }


    public static void creatSquareCookies(){

        float xx = 20f;
        float off = .5f;
        float yy = 3.3f;


        for(int i=0; i<3; i++){
            creatCookie(xx, yy);
            creatCookie(xx + off, yy);
            creatCookie(xx - off, yy);
            yy = yy + off;
        }
    }

    public static void creatPoles(){
        //Criando Objeto do obstaculo
        new Obstaculo(
                20f,
                4.5f,
                .07f,
                1.8f,
                1f,
                1f,
                1,
                128,
                128,
                2,
                1,
                0f,
                "pole"
        );

        new Obstaculo(
                22.3f,
                4.5f,
                .07f,
                1.8f,
                1f,
                1f,
                1,
                128,
                128,
                2,
                1,
                0f,
                "pole"
        );
    }
}
