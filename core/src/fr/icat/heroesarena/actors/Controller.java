package fr.icat.heroesarena.actors;

import com.badlogic.gdx.scenes.scene2d.Group;
import fr.icat.heroesarena.consts.World;

/**
 * Created by Romain on 15/05/2016.
 */
public final class Controller extends Group {

    public static final String NAME = "controller";

    public static final int X = 0;
    public static final int Y = 0;
    public static final int W = World.W;
    public static final int H = World.H - Arena.H;

    // --

    public Controller() {
        setName(NAME);
        setBounds(X, Y, W, H);
    }
}
