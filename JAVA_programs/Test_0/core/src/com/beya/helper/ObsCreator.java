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
        chooser.creatRandonEntitie();
        Test.entities.add(this);

        setTimer(2f, 6f); //Setando e resetando o timer


    }

    @Override
    public void tick() {
        float timeCalculator = ((Gdx.graphics.getDeltaTime() * 100)/60f);
        time += timeCalculator;


        if(time > timeToCreat){
            //creatBIGSQUARE(); //BIG TEST

            chooser.creatRandonEntitie();

            setTimer(2f, 6f); //Reseta e seta próximo timer
        }
    }

    @Override
    public void render(SpriteBatch batch) {return;}

    @Override
    public void destroy() {}

    public void setTimer(float min, float max){
        timeToCreat = MathUtils.random(min, max);
        time = 0;
    }

    //**************Criação de Obstáculos**************\\


        //VARIANTES DE PLACAS
            //Verlmehas
    public static void creatRedPlate(){new Obstaculo();}
    public static void creatRPlateArcCoins(){
        creatArcCoins(20f, 4.9f);
        creatRedPlate();
    }

            //Verdes
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

            //Verdes Duplas
    public static void creatDoubleGreen(){

        float hitBoxW = 0.7f;
        float hitBoxH = .1f;
        float dif = 2f;
        float yy = 3.3f;

        new Obstaculo(
                20f,
                yy,
                hitBoxW,
                hitBoxH,
                1.5f,
                3.3f,
                1,
                128,
                256,
                0,
                1,
                -.13f,
                "double_green_plate"
        );

        new Obstaculo(
                20f,
                yy + dif,
                hitBoxW,
                hitBoxH,
                1f,
                2f,
                1,
                128,
                128,
                7,
                7,
                .1f,
                "double_green_plate"
        );
    }
    public static void creatDoubleGreenSquareCoins(){
        creatDoubleGreen();

        float xx = 19.8f;
        float yy = 3.9f;
        float xDiff = .6f;
        float yDiff = .3f;

        for(int i=0; i<4; i++){
            creatCookie(xx, yy);
            xx += xDiff;
            yy += yDiff;
        }
    }

            //Azuis

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
    public static void creatBPlateArcCoins(){
        creatArcCoins(20f, 4.6f);
        creatBluePlate();
    }

        //VARIANTES DE CONES
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

    public static void creatConeCoin(){
        creatCookie(20f, 3.5f);
        creatCone(20f);

    }

        //VARIANTES DE COOKIES
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
    public static void creat4cookies(){

        float xx = 20f;
        float yy = 4f;

        for(int i=0; i<2; i++){
            creatCookie(xx, yy);
            creatCookie(xx + .5f, yy);
            yy -= .5f;
        }

    }

        //RAROS

            //Orelhão
    public static void creatOrelhao(){

        //Criando Objeto do obstaculo
        new Obstaculo(
                20f,
                3.2f,
                0.2f,
                0.6f,
                1f,
                2f,
                1,
                128,
                256,
                2,
                1,
                0f,
                "orelhao"
        );
    }

        //SEM USO

    public static void creatBIGSQUARE(){
        new Obstaculo(
                20f,
                3.3f,
                6f,
                1f,
                1f,
                1f,
                1,
                128,
                128,
                5,
                5,
                0f,
                "pole"
        );
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
