package com.beya.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.beya.main.Test;


public class Ground implements Entity {


    //Variabeis do libGDX
    public Body body;

    private float ground_y = 2.7f;

    //private float ground_x = 10;

    public Ground(){
        Test.entities.add(this);//Iniciando chão no mundo de fato!

        bodySetter(ground_y);
    }

    public Ground(float y){
        Test.entities.add(this);

        bodySetter(y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void destroy() {

    }

    public void bodySetter(float y){
        //Definindo body
        BodyDef bodyDef = new BodyDef();
        //Setando posição do body
        bodyDef.position.set(new Vector2(10f, 0f));

        //Criando o body com as definições acima
        body = Test.world.createBody(bodyDef);

        //Retangulo de hitbox
        ChainShape chain = new ChainShape();

        chain.createChain(new float[] {-10, y, 10, y});

        //Colocando a fixture no body
        body.createFixture(chain, 0.0f).setUserData(this);
        //Discarta o que não usa mais
        chain.dispose();
    }

}
