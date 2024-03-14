package com.beya.listener;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.beya.entities.Ground;
import com.beya.entities.Obstaculo;
import com.beya.entities.Runner;
import com.beya.main.Test;

public class Listener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if(fa == null || fb == null) return;
        if(fa.getUserData() == null || fb.getUserData() == null) return;

        //Função que cuida de coletar os cookies
        collectCookie(fa, fb);

        // Da mais um pulo ao player
        jumpControler(fa, fb, true);

    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if(fa == null || fb == null) return;
        if(fa.getUserData() == null || fb.getUserData() == null) return;

        //Tira um pulo do player
        jumpControler(fa, fb, false);
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {}
    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {}

    private boolean isTouchingObstacule(Fixture a, Fixture b){
        if (a.getUserData() instanceof Obstaculo || b.getUserData() instanceof Obstaculo){
            return a.getUserData() instanceof Runner || b.getUserData() instanceof Runner;
        }
        return false;
    }

    private boolean isTouchingGround(Fixture a, Fixture b){
        if ((a.getUserData() instanceof Ground || b.getUserData() instanceof Ground)){
            return a.getUserData() instanceof Runner || b.getUserData() instanceof Runner;
        }
        return false;
    }

    private void collectCookie(Fixture fa, Fixture fb){

        if(isTouchingObstacule(fa, fb)){
            Obstaculo obs;
            Runner r;

            if(fa.getUserData() instanceof Obstaculo){
                obs = (Obstaculo) fa.getUserData();
                r = (Runner) fb.getUserData();
            }else{
                obs = (Obstaculo) fb.getUserData();
                r = (Runner) fa.getUserData();
            }


            if(obs.id.equals("cookie")){
                Test.cookieCollect.play();
                obs.hit();
                Test.cookies++;
            }
        }
    }

    public void jumpControler(Fixture fa, Fixture fb, boolean moreOrLess){

        if(isTouchingGround(fa, fb)) {
            Ground ground;
            Runner r;

            if (fa.getUserData() instanceof Ground) {
                ground = (Ground) fa.getUserData();
                r = (Runner) fb.getUserData();
            } else {
                ground = (Ground) fb.getUserData();
                r = (Runner) fa.getUserData();
            }

            //Tira um do pulo
            if (moreOrLess) Test.player.jump++;
            else Test.player.jump--;
        }
    }

}
