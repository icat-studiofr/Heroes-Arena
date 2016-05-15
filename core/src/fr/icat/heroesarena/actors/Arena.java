package fr.icat.heroesarena.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import fr.icat.heroesarena.consts.World;
import fr.icat.heroesarena.managers.TiledManager;

/**
 *
 */
public final class Arena extends Group {

    public static final String NAME = "arena";

    public static final int X = 0;
    public static final int Y = 4;
    public static final int W = World.W;
    public static final int H = World.H - Controller.H;

    // --

    private TiledManager tiledManager;
    private Actor hero = null;

    public Arena(final TiledManager tiledManager) {

        this.tiledManager = tiledManager;
        setName(NAME);
        setBounds(X, Y, W, H);

        addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                int xo = (int)x, yo = (int)y;

                if(Arena.this.tiledManager.isValidCell(xo, yo)){
                    hero.setPosition(xo, yo);
                }

                return true;
            }
        });
    }

    public Actor getHero() {
        return hero;
    }

    public void setHero(Actor hero) {
        this.hero = hero;
    }
}
