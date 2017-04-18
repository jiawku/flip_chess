package com.libgdx.libGDX_test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


/**
 * ��Ϸ������������, ʵ�� ApplicationListener �ӿ�
 */
public class MainGame implements ApplicationListener {

    @Override
    public void create() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void render() {
        /*
         * ����������ɫΪ��ɫ��RGBA��, 
         * 
         * LibGDX ��ʹ�� 4 ���������ͱ�����ֵ��Χ 0.0 ~ 1.0����ʾһ����ɫ���ֱ��ʾ��ɫ�� RGBA �ĸ�ͨ����,
         * 
         * ʮ��������ɫ�븡����ɫ֮���ת��: ��ʮ��������ɫ��ÿһ���������� 255 �õ��ĸ��������Ǹ�����ɫ��Ӧ��ͨ��ֵ��
         */
        Gdx.gl.glClearColor(1, 0, 0, 1);

        // ����
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
    }
}

