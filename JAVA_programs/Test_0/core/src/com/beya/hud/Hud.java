package com.beya.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.beya.main.Test;

public class Hud {

    public Stage stage;
    private Table table;
    private Label pointsLabel;
    private Label cookiesLabel;
    private int points;

    public Hud(){

        points = Test.points;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.top();
        table.setFillParent(true);

        pointsLabel = new Label(String.format("%04d",points), new Label.LabelStyle(new BitmapFont(), Color.CORAL));
        cookiesLabel = new Label(String.format("%01d", Test.cookies), new Label.LabelStyle(new BitmapFont(), Color.GOLD));

        table.add(pointsLabel).top().padTop(10).growX();
        table.add(cookiesLabel).top().padTop(10).growX();

        stage.addActor(table);

    }

    public void tick(){


        stage.draw();

        points = Test.points;

        pointsLabel.setText("Pontos: " + points);

        cookiesLabel.setText("Cookies: " + Test.cookies);

    }

}
