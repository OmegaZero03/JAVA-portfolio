package com.beya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Runner implements Entity {

    private final int frames = 8;
    private Texture walkSheet;
    private Animation<TextureRegion> walkAnimation;
    private TextureRegion currenteFrameWalk;
    private float stateTime;
    private float scale;

    private Body body;

    //Inicia tamanho em "scale"
    public Runner(){
        //body = new Body();
        this.scale = 2.3f;
        walkAnimation(); //Inicia Textura
    }

    @Override
    public void tick() {
        stateTime += Gdx.graphics.getDeltaTime(); //soma em 1 independente da potencia do pc
    }

    @Override
    public void render(SpriteBatch batch) {
        drawAnimation(batch);
    }

    @Override
    public void destroy()
    {
        walkSheet.dispose();

    }

    /*********************************FUNÇÕES*************************************/

    //Cuida da animação
    private void walkAnimation(){
        walkSheet = new Texture(Gdx.files.internal("Arthur_sprite.png")); //Carrega .png da sprite
        TextureRegion[][] walk_temp = TextureRegion.split(walkSheet, 128 , 128);

        TextureRegion[] walkFrames = new TextureRegion[frames];
        int index = 0;

        for (int j = 0; j < frames; j++){
            walkFrames[index++] = walk_temp[0][j];
        }

        walkAnimation = new Animation<TextureRegion>(0.1f, walkFrames);

        stateTime = 0f;
    }

    //desenha animação
    private void drawAnimation(SpriteBatch batch){
        currenteFrameWalk = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currenteFrameWalk, 100,120, 128 * scale, 128 * scale);
    }
}
