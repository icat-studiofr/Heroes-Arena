package fr.icat.heroesarena.managers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;

import fr.icat.heroesarena.actors.Arena;

/**
 *
 */
public final class GridManager implements Disposable{

    private ShapeRenderer shape;
    private Color color = Color.BLACK;

    public GridManager(){
        shape = new ShapeRenderer();
    }

    public void render(Camera camera) {
        shape.setProjectionMatrix(camera.combined);
        shape.setColor(color);

        shape.begin(ShapeRenderer.ShapeType.Line);
        for (int i = Arena.X + 1; i < Arena.W; i++) {
            shape.line(i, Arena.Y, i, Arena.H + Arena.Y);
        }
        for (int i = Arena.Y + 1; i < Arena.H + Arena.Y; i++) {
            shape.line(0, i, Arena.W + Arena.X, i);
        }
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
