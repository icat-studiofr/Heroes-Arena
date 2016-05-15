package fr.icat.heroesarena.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import fr.icat.heroesarena.actors.Arena;
import fr.icat.heroesarena.actors.Controller;
import fr.icat.heroesarena.actors.Hero;
import fr.icat.heroesarena.consts.TMX;
import fr.icat.heroesarena.consts.World;
import fr.icat.heroesarena.managers.GridManager;
import fr.icat.heroesarena.managers.TiledManager;

/**
 *
 */
public final class ArenaScreen extends ScreenAdapter{

    private TiledManager tiledManager;
    private GridManager gridManager;
    private int boardKey = TMX.TEST;
    private Stage stage;

    // --

    @Override
    public void show() {

        stage = new Stage(new StretchViewport(World.W, World.H));
        Gdx.input.setInputProcessor(stage);

        gridManager = new GridManager();
        tiledManager = new TiledManager(boardKey, stage.getBatch());

        Arena arena = new Arena(tiledManager);

        stage.addActor(arena);
        stage.addActor(new Controller());

        Hero hero = new Hero(new Texture("heroes/hitman.png"));
        arena.addActor(hero);
        arena.setHero(hero);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);

        tiledManager.render(stage.getCamera());
        gridManager.render(stage.getCamera());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        tiledManager.dispose();
        gridManager.dispose();
        stage.dispose();
    }

    public void setBoardKey(Integer boardKey) {
        this.boardKey = boardKey;
    }
}
