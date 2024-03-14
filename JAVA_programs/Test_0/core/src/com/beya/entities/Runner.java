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
import com.beya.main.Test;

public class Runner implements Entity {

    //Minhas variaveis
    private final int frames = 6;
    private float runnerX = 5.5f;
    private float runnerY = /*6.4f*/3.7f;
    private float textureSize = .99f;
    private float jumpPower = 1.2f;
    public float jump;
    public boolean isRunning;

    //Minhas variáveis iniciadas no construtor
    private float hitboxPositionX;
    private float hitboxPositionY;
    private float hitboxSize;

    //Variaveis do libGDX
    private Texture walkSheet;
    private Animation<TextureRegion> walkAnimation;
    private TextureRegion currenteFrameWalk;
    private float stateTime;
    private Body body;
    private Vector2 position;

    //Inicia tamanho em "scale"
    public Runner(){
        Test.entities.add(this); //Iniciando player no mundo de fato!

        jump = 0;

        //Variáveis de inicialiazaçã0
        this.hitboxPositionX = runnerX;
        this.hitboxPositionY = runnerY;
        this.hitboxSize = (textureSize / 2) ;

        bodySetter(); // Setando física do corpo no box2D

        //body.getUserData()

        position = body.getPosition();
        walkAnimation(); //Inicia Textura
    }

    @Override
    public void tick() {
        stateTime += Gdx.graphics.getDeltaTime(); //soma em 1 independente da potencia do pc

        //System.out.println(position.y);

        if(Gdx.input.justTouched() && (jump > 0)){ // Se tocou na tela E tem pulos sobrando
            //Pule
            if (position.y > 6) {
                body.applyLinearImpulse(0.0f, jumpPower - .2f, position.x, position.y, true);
            }
            else {
                body.applyLinearImpulse(0.0f, jumpPower, position.x, position.y, true);
            }

            Test.jumpSound.play();
        }

        if(position.x <= runnerX - body.getLinearVelocity().x - 0.5f) {
            body.applyLinearImpulse(.1f * body.getMass(), 0, position.x, position.y, true);
        }

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
        walkSheet = new Texture(Gdx.files.internal("Ninja_sprite.png")); //Carrega .png da sprite
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
        batch.draw(currenteFrameWalk, body.getPosition().x - hitboxSize, body.getPosition().y - hitboxSize + .1f, textureSize, textureSize);
    }

    private void bodySetter(){
        //Criando body def, definindo qual tipo do body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        //Definindo posição do body
        bodyDef.position.set(hitboxPositionX, hitboxPositionY); // Divisões pra encaixar ele na sprite

        //Iniciando o body em si, e dando um shape pra ele
        body = Test.world.createBody(bodyDef);

        //Shape de poligono, um quadrado
        PolygonShape hitBox = new PolygonShape();
        hitBox.setAsBox(hitboxSize - .3f, hitboxSize - .1f);

        //Criando uma fixturedef a denfinição da fixture
        //Dando as regras do corpo!
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = hitBox; // Passando o shape de quadrado pra fixture
        fixtureDef.density = 0.6f;

        fixtureDef.friction = 0.4f;
        //fixtureDef.restitution = 0.5f; //faz pular

        //fixture em si
        Fixture fixture = body.createFixture(fixtureDef);

        fixture.setUserData(this);

        body.setFixedRotation(true);

        //Se não usa mais, descarta!
        hitBox.dispose();
    }

    public void hit() {
        Test.cookies++;
    }
}
