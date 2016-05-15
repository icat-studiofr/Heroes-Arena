package fr.icat.heroesarena.managers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

import fr.icat.heroesarena.actors.Controller;
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

        MapLayer a = tiledMap.getLayers().get("aabb");

    }

    public void render(Camera camera){
        tmRender.setView((OrthographicCamera) camera);
        tmRender.render();
    }

    /**
     * Détermine si la cellule est accessible
     * @param x
     * @param y
     * @return
     */
    public boolean isValidCell(int x, int y) {
        return ((TiledMapTileLayer)tiledMap.getLayers().get("aabb"))
                    .getCell(x, y + Controller.H) == null;
    }

    @Override
    public void dispose() {
        tmRender.dispose();
        tiledMap.dispose();
    }
}
