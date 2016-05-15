package fr.icat.heroesarena.managers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

import fr.icat.heroesarena.consts.TMX;
import fr.icat.heroesarena.consts.World;

/**
 *
 */
public final class TiledManager implements Disposable {

    private OrthogonalTiledMapRenderer tmRender;
    private TiledMap tiledMap;

    public TiledManager(int tmxKey, Batch batch){
        tiledMap = TMX.getTiledMap(tmxKey);
        tmRender = new OrthogonalTiledMapRenderer(tiledMap, World.US, batch);
    }

    public void render(Camera camera){
        tmRender.setView((OrthographicCamera) camera);
        tmRender.render();
    }

    @Override
    public void dispose() {
        tmRender.dispose();
        tiledMap.dispose();
    }
}
