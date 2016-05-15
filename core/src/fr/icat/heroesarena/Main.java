package fr.icat.heroesarena;

import com.badlogic.gdx.Game;

import fr.icat.heroesarena.screens.ArenaScreen;

public final class Main extends Game {
	
	@Override
	public void create () {
        setScreen(new ArenaScreen());
	}

    @Override
    public void dispose() {
        super.dispose();

    }
}
