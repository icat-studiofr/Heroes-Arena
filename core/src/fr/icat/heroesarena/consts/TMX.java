package fr.icat.heroesarena.consts;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Created by Romain on 15/05/2016.
 */
public final class TMX {

    public static final int TEST = 514562;

    private static final ObjectMap<Integer, String> datas;

    static {
        datas = new ObjectMap<Integer, String>();
        datas.put(TEST, "test");
    }

    public static final TiledMap getTiledMap(int key) {
        try {
            return new TmxMapLoader().load("boards/" + datas.get(key) + ".tmx");
        } catch (Exception e){
            return null;
        }
    }
}
