package com.flip_chess.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.flip_chess.MainGame.MainGame;
import com.flip_chess.Stage.GameStage;

/**
 * 主游戏场景
 */
public class GameScreen extends ScreenAdapter {

    private MainGame mainGame;

    /** 主游戏舞台 */
    private GameStage gameStage;
    
    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    private void init() {
        // 创建主游戏舞台
        gameStage = new GameStage(
                getMainGame(),
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );


        // 将输入处理设置到主游戏舞台
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
        // 场景销毁时, 同时销毁所有的舞台
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
