package com.flip_chess.MainGame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

import com.flip_chess.res.Res;
import com.flip_chess.Screen.GameScreen;

/**
 * 游戏主程序入口类
 * 
 */
public class MainGame extends Game {

    /** 世界宽度 */
    private float worldWidth;
    /** 世界高度 */
    private float worldHeight;

    /** 资源管理器 */
    private AssetManager assetManager;

    /** 纹理图集 */
    private TextureAtlas atlas;

    /** 主游戏场景 */
    private GameScreen gameScreen;

    @Override
    public void create() {
        // 设置 LOG 输出级别
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        // 为了不压扁或拉长图片, 按实际屏幕比例计算世界宽高
        worldWidth = Res.FIX_WORLD_WIDTH;
        worldHeight = Res.FIX_WORLD_HEIGHT;

        Gdx.app.log(TAG, "World Size: " + worldWidth + " * " + worldHeight);

        // 创建资源管理器
        assetManager = new AssetManager();

        // 加载资源
        assetManager.load(Res.Atlas.ATLAS_PATH, TextureAtlas.class);

/*        assetManager.load(Res.Audios.AUDIO_DIE, Sound.class);
        assetManager.load(Res.Audios.AUDIO_HIT, Sound.class);
        assetManager.load(Res.Audios.AUDIO_TOUCH, Sound.class);
        assetManager.load(Res.Audios.AUDIO_RESTART, Sound.class);
        assetManager.load(Res.Audios.AUDIO_SCORE, Sound.class);
*/
        // 等待资源加载完毕
        assetManager.finishLoading();

        // 获取资源
        atlas = assetManager.get(Res.Atlas.ATLAS_PATH, TextureAtlas.class);


        // 创建主游戏场景
        gameScreen = new GameScreen(this);

        // 设置当前场景
        setScreen(gameScreen);

    
    }

    @Override
    public void render() {
        // 黑色清屏
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 父类渲染场景
        super.render();

    }

    @Override
    public void dispose() {
        super.dispose();
        // 应用退出时需要手动销毁场景
        if (gameScreen != null) {
            gameScreen.dispose();
        }
        // 应用退出时释放资源
        if (assetManager != null) {
            assetManager.dispose();
        }
    }

    public float getWorldWidth() {
        return worldWidth;
    }

    public float getWorldHeight() {
        return worldHeight;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }


}
















