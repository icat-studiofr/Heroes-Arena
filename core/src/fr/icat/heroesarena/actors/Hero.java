package fr.icat.heroesarena.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 */
public final class Hero extends Actor {

    public static final int W = 1;
    public static final int H = 1;

    // --

    private Texture texture;


    public Hero(Texture texture){
        this.texture = texture;
        setSize(Hero.W, Hero.H);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
