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
 * ��Ϸ�����������
 * 
 */
public class MainGame extends Game {

    /** ������ */
    private float worldWidth;
    /** ����߶� */
    private float worldHeight;

    /** ��Դ������ */
    private AssetManager assetManager;

    /** ����ͼ�� */
    private TextureAtlas atlas;

    /** ����Ϸ���� */
    private GameScreen gameScreen;

    @Override
    public void create() {
        // ���� LOG �������
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        // Ϊ�˲�ѹ�������ͼƬ, ��ʵ����Ļ��������������
        worldWidth = Res.FIX_WORLD_WIDTH;
        worldHeight = Res.FIX_WORLD_HEIGHT;

        Gdx.app.log(TAG, "World Size: " + worldWidth + " * " + worldHeight);

        // ������Դ������
        assetManager = new AssetManager();

        // ������Դ
        assetManager.load(Res.Atlas.ATLAS_PATH, TextureAtlas.class);

/*        assetManager.load(Res.Audios.AUDIO_DIE, Sound.class);
        assetManager.load(Res.Audios.AUDIO_HIT, Sound.class);
        assetManager.load(Res.Audios.AUDIO_TOUCH, Sound.class);
        assetManager.load(Res.Audios.AUDIO_RESTART, Sound.class);
        assetManager.load(Res.Audios.AUDIO_SCORE, Sound.class);
*/
        // �ȴ���Դ�������
        assetManager.finishLoading();

        // ��ȡ��Դ
        atlas = assetManager.get(Res.Atlas.ATLAS_PATH, TextureAtlas.class);


        // ��������Ϸ����
        gameScreen = new GameScreen(this);

        // ���õ�ǰ����
        setScreen(gameScreen);

    
    }

    @Override
    public void render() {
        // ��ɫ����
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // ������Ⱦ����
        super.render();

    }

    @Override
    public void dispose() {
        super.dispose();
        // Ӧ���˳�ʱ��Ҫ�ֶ����ٳ���
        if (gameScreen != null) {
            gameScreen.dispose();
        }
        // Ӧ���˳�ʱ�ͷ���Դ
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
















