package com.beya;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Test extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Texture backGround;
	private OrthographicCamera camera;
	private Array<Entity> entities;
	private Runner player;
	private int loopBackground;
	private int speed;
	public static World world;
	private Box2DDebugRenderer b2dr;

	
	@Override
	public void create () {

		//Instanciando objetos
		img = new Texture("CarWindow.png");
		img = new Texture("CarWindow.png");

		//backGround = new Texture("Street.jpg");

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 2000, 1000);

		batch = new SpriteBatch();
		player = new Runner();

		entities = new Array<Entity>();
		entities.add(player);

		world = new World(new Vector2(0 , -9.8f), false);
		b2dr = new Box2DDebugRenderer();


		//Velocidade do placeholder bunda
		speed = 0;

	}

	@Override
	public void render () {

		ScreenUtils.clear(1, 1, 1, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		//Camera set up


		for (Entity e : entities) {
			e.tick();
		}

		//Carregando imagens
		batch.begin();
		speed -= 500 * Gdx.graphics.getDeltaTime();

		//Loop bunda place holder kkk
		loopStreet();

		batch.draw(img, 0 ,0, 2000, 1000);

		for (Entity e : entities) {
			e.render(batch);
		}
		batch.end();
		//Para de carregar imagens


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		b2dr.dispose();
		world.dispose();

		for (Entity e : entities) {
			e.destroy();
		}
	}

	public void loopStreet(){
		for(int i = 0; i < 20; i++){
			batch.draw(backGround, speed + (i* 2000),0, 700, 500);
		}
	}
}
