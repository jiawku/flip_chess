package com.flip_chess.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.flip_chess.MainGame.MainGame;
import com.flip_chess.Stage.GameStage;

/**
 * ����Ϸ����
 */
public class GameScreen extends ScreenAdapter {

    private MainGame mainGame;

    /** ����Ϸ��̨ */
    private GameStage gameStage;
    
    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    private void init() {
        // ��������Ϸ��̨
        gameStage = new GameStage(
                getMainGame(),
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );


        // �����봦�����õ�����Ϸ��̨
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (gameStage.isVisible()) {
            gameStage.act();
            gameStage.draw();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        // ��������ʱ, ͬʱ�������е���̨
        if (gameStage != null) {
            gameStage.dispose();
        }

    }

    public MainGame getMainGame() {
        return mainGame;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

}
