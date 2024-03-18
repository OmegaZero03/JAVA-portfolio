package com.beya.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
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
            //platerChooser();
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
        Obstaculo greenPlate = new Obstaculo(
                20f,
                3.3f,
                0.4f,
                0.4f,
                1f,
                1f,
                1,
                128,
                128,
                1,
                1,
                0f,
                "green_plate"
        );
    }

    public static void creatCookie(float x, float y){
        Obstaculo cookie = new Obstaculo(
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
}
