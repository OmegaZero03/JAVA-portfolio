package com.beya.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.beya.listener.Listener;
import com.beya.main.Test;

public class Obstaculo implements Entity {

    private int frames;
    Body body;
    private Vector2 position;
    private Texture walkSheet;
    private TextureRegion currenteFrameWalk;
    private float textureSizeW;
    private float textureSizeH;
    private float creatX, creatY;
    private float hitboxW, hitboxH;
    private int spriteSheetcutX, spriteSheetcutY;
    private float offSet;
    private float stateTime;
    private Animation<TextureRegion> walkAnimation;
    private boolean isAnimated;
    private FixtureDef fixtureDef;

    private float velocity = -3.0f;
    public String id;

    public Obstaculo(){

        this.creatX = 20f;
        this.creatY = 3.3f;

        this.hitboxW = .1f;
        this.hitboxH = .6f;

        this.textureSizeW = .8f;
        this.textureSizeH = textureSizeW * 2;

        this.frames = 1;

        this.offSet = .2f;

        this.spriteSheetcutX = 0;
        this.spriteSheetcutY = 0;

        isAnimated = false;

        id = "red_plate";

        Test.entities.add(this);

        bodySetter();
        position = body.getPosition();

        noAnimation(Sprite.OBSTACULO_TEXTURE, 128, 256);
    }

    public Obstaculo(float creatX, float creatY, float hitboxW, float hitboxH, float textureSizeW, float textureSizeH,
                     int frames, Texture texture, int spriteW, int spriteH, int spriteSheetcutX, int spriteSheetcutY,
                     float Yoffset, String id,
                     boolean isAnimated){

        this.creatX = creatX;
        this.creatY = creatY;

        this.hitboxW = hitboxW;
        this.hitboxH = hitboxH;

        this.textureSizeW = textureSizeW;
        this.textureSizeH = textureSizeH;

        this.frames = frames;

        this.offSet = Yoffset;

        this.isAnimated = isAnimated;

        this.id = id;

        this.spriteSheetcutX = spriteSheetcutX;
        this.spriteSheetcutY = spriteSheetcutY;

        Test.entities.add(this);

        bodySetter();
        position = body.getPosition();

        if(isAnimated) Animation(texture, spriteW, spriteH);

        else noAnimation(texture, spriteW, spriteH);

    }

    public Obstaculo(float creatX, float creatY, float hitboxW, float hitboxH, float textureSizeW, float textureSizeH,
                     int frames, int spriteW, int spriteH, int spriteSheetcutX, int spriteSheetcutY,
                     float Yoffset, String id){

        this.creatX = creatX;
        this.creatY = creatY;

        this.hitboxW = hitboxW;
        this.hitboxH = hitboxH;

        this.textureSizeW = textureSizeW;
        this.textureSizeH = textureSizeH;

        this.frames = frames;

        this.offSet = Yoffset;

        this.id = id;

        isAnimated = false;

        this.spriteSheetcutX = spriteSheetcutX;
        this.spriteSheetcutY = spriteSheetcutY;

        Test.entities.add(this);

        bodySetter();
        position = body.getPosition();
        noAnimation(Sprite.OBSTACULO_TEXTURE, spriteW, spriteH);
    }


    @Override
    public void tick() {



        //Acelera pra ewsquerda
        body.setLinearVelocity(velocity, 0.0f);

        if(position.x <= -1){
            Test.entities.removeValue(this, true);
            Test.world.destroyBody(body);
        }

        if(!isAnimated) return;
        stateTime += Gdx.graphics.getDeltaTime(); //soma em 1 independente da potencia do pc

    }

    @Override
    public void render(SpriteBatch batch) {
        if (isAnimated){
            drawAnimation(batch);
        }else{
            drawNoAnimation(batch);
        }

    }

    @Override
    public void destroy() {
        walkSheet.dispose();
    }

    private void noAnimation(Texture texture,int spriteW, int spriteH){
        walkSheet = texture;
        TextureRegion[][] walk_temp = TextureRegion.split(walkSheet, spriteW , spriteH);

        TextureRegion[] walkFrames = new TextureRegion[frames];

        walkFrames[0] = walk_temp[spriteSheetcutY][spriteSheetcutX];

        currenteFrameWalk = walkFrames[0];
    }

    private void Animation(Texture texture,int spriteW, int spriteH){
        walkSheet = texture;
        TextureRegion[][] walk_temp = TextureRegion.split(walkSheet, spriteW , spriteH);

        TextureRegion[] walkFrames = new TextureRegion[frames];
        int index = 0;

        for (int j = 0; j < frames; j++){
            walkFrames[index++] = walk_temp[0][j];
        }

        walkAnimation = new Animation<TextureRegion>(0.15f, walkFrames);

        stateTime = 0f;

    }

    private void drawNoAnimation(SpriteBatch batch){
        batch.draw(currenteFrameWalk, body.getPosition().x - (textureSizeW / 2) , body.getPosition().y - (textureSizeW / 2) - offSet, textureSizeW, textureSizeH);
    }

    private void drawAnimation(SpriteBatch batch){
        currenteFrameWalk = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currenteFrameWalk, body.getPosition().x - (textureSizeW / 2) , body.getPosition().y - (textureSizeW / 2) - offSet, textureSizeW, textureSizeH);
    }

    private void bodySetter(){
        //Criando body def, definindo qual tipo do body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;

        //Definindo posição do body
        bodyDef.position.set(creatX, creatY);

        //Iniciando o body em si, e dando um shape pra ele
        body = Test.world.createBody(bodyDef);

        //Shape de poligono, um quadrado
        PolygonShape hitBox = new PolygonShape();
        hitBox.setAsBox(hitboxW, hitboxH);

        //Criando uma fixturedef a denfinição da fixture
        //Dando as regras do corpo!
        fixtureDef = new FixtureDef();
        fixtureDef.shape = hitBox; // Passando o shape de quadrado pra fixture
        fixtureDef.density = .5f;
        //fixtureDef.friction = 0.4f;
        //fixtureDef.restitution = 0.5f; //faz pular
        if(id.equals("cookie")) fixtureDef.isSensor = true;

        //fixture em si
        Fixture fixture = body.createFixture(fixtureDef);

        fixture.setUserData(this);
        body.setFixedRotation(true);




        //Se não usa mais, descarta!
        hitBox.dispose();
    }

    public void hit(){
        Test.bodyToRemove.add(body);
        Test.entities.removeValue(this, true);
    }


    public FixtureDef getFixtureDef() {
        return fixtureDef;
    }
}
