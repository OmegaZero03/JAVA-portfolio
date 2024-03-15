package com.beya.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.beya.main.Test;

public class ObsCreator implements Entity {

    public static float handPlateY = 3.4f;

    public float time = 0f;

    private float timeToCreat;
    private  float plateChooser;

    private String entiteName = "obstaculo";

    public ObsCreator(){
        //Test.entities.add(this);

        timeToCreat = MathUtils.random(2f, 6f);

        plateChooser = MathUtils.random();
    }

    @Override
    public void tick() {
        time += ((Gdx.graphics.getDeltaTime() * 100)/60f);


        if(time > timeToCreat){
            //platerChooser();

            creatSquareCookies();
            timeToCreat = MathUtils.random(2f, 6f);
            time = 0;

        }
    }

    @Override
    public void render(SpriteBatch batch) {return;}

    @Override
    public void destroy() {}

    public void creatRedPlate(){new Obstaculo();}

    public void creatGreenPlate(){
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
                1,
                1,
                0f,
                "green_plate"
        );
    }
    public void creatCookie(){
        new Obstaculo(
                20f,
                5.3f,
                0.2f,
                0.2f,
                1f,
                1f,
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

    public void creatCookie(float x, float y){
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

    public void platerChooser(){


        if(plateChooser < 0.5f){
            creatRedPlate();
            plateChooser = MathUtils.random(); // Rerandomiza
        }else{
            creatGreenPlate();
            plateChooser = MathUtils.random(); // Rerandomiza
        }
        timeToCreat = MathUtils.random(2f, 6f);
        time = 0;
    }

    public void creatSquareCookies(){

        float xx = 20f;
        float off = .5f;
        float yy = 3.3f;

        creatCookie(xx, yy);
        creatCookie(xx + off, yy);
        creatCookie(xx - off, yy);

        yy = yy + off;

        creatCookie(xx, yy);
        creatCookie(xx + off, yy);
        creatCookie(xx - off, yy);

        yy = yy + off;

        creatCookie(xx, yy);
        creatCookie(xx + off, yy);
        creatCookie(xx - off, yy);


    }

}
