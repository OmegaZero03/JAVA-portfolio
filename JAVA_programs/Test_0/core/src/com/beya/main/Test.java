package com.beya.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.beya.entities.Entity;
import com.beya.entities.Ground;
import com.beya.helper.ObsCreator;
import com.beya.entities.Obstaculo;
import com.beya.entities.Runner;
import com.beya.entities.Sprite;
import com.beya.hud.Hud;
import com.beya.listener.Listener;

public class Test extends Game {

	public static final float WIDTH  = 20.0f;
	public static final float HEIGHT = 10.0f;
	public static int cookies;
	private final float gravity = -9.8f;
	private SpriteBatch batch;
	private Sprite sprites;
	private Texture img;
	private Texture backGround;
	private OrthographicCamera camera;
	public static Sound cookieCollect, jumpSound;
	public static Array<Entity> entities;
	public static Array<Body> bodyToRemove;
	public static Runner player;
	public static Ground ground, wire;
	public static ObsCreator creator;
	public Hud hud;
	public static float brutePoints;
	public static int points;

	//Placeholder
	private int loopBackground;
	private int speed;
	public static World world;
	private Box2DDebugRenderer debugRender;

	
	@Override
	public void create () {

		//Instanciando objetos
		sprites = new Sprite();

		img = new Texture("CarWindow.png");

		//Carregar backGround quando houver um
		//backGround = new Texture();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);

		batch = new SpriteBatch();

		cookieCollect = Gdx.audio.newSound(Gdx.files.internal("cookies_collect.wav"));
		jumpSound = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));

		cookies = 0;

		entities = new Array<Entity>();
		bodyToRemove = new Array<Body>();

		world = new World(new Vector2(0 , gravity), false);

		world.setContactListener(new Listener());

		debugRender = new Box2DDebugRenderer();


		hud = new Hud();
		ground = new Ground();
//		/wire = new Ground(6.3f);
		player = new Runner();
		creator = new ObsCreator();


		//Velocidade do placeholder bunda
		speed = 0;

	}

	@Override
	public void render () {

		ScreenUtils.clear(1, 1, 1, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		//Camera set up

		if(Gdx.input.isKeyPressed(Input.Keys.EQUALS)){
			camera.zoom -= .03f;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.MINUS)){
			camera.zoom += .03f;
		}


		//Carregando imagens
		batch.begin();
		speed -= 500 * Gdx.graphics.getDeltaTime();


		//Loop bunda place holder kkk
		//loopStreet();

		for (Entity e : entities) {
			e.render(batch);
		}
		batch.draw(img, 0 ,0, WIDTH, HEIGHT);
		batch.end();
		//Para de carregar imagens

		creator.tick();

		for (Entity e : entities) {
			e.tick();
		}



		brutePoints += (((Gdx.graphics.getDeltaTime() * 100)/60f) * Math.pow(10, 2));
		points = MathUtils.round(brutePoints);

		hud.tick();

		//System.out.println(points);

		world.step(1/60.0f, 6, 2);

		if(bodyToRemove.size > 0) {

			for (Body b : bodyToRemove) {
				world.destroyBody(b);
			}
			bodyToRemove.clear();
		}


		debugRender.render(world, camera.combined);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		debugRender.dispose();
		world.dispose();
		hud.stage.dispose();

		for (Entity e : entities) {
			e.destroy();
		}
	}

	public void loopStreet(){
		for(int i = 0; i < 20; i++){
			batch.draw(backGround, speed + (i* 20.f),0, 7.0f, 5.0f);
		}
	}
}
