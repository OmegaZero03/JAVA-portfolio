package com.beya.entities;

import com.badlogic.gdx.graphics.Texture;

public class Sprite {

    public static Texture
            OBSTACULO_TEXTURE,
            COOKIE_TEXTURE;


    public Sprite(){

        OBSTACULO_TEXTURE = new Texture("placa_sprite.png");
        COOKIE_TEXTURE = new Texture("cookie_sprite.png");
    }
}
