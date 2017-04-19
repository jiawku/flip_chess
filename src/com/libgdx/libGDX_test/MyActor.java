package com.libgdx.libGDX_test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * �Զ�����Ա������ʱ���� λ�ã��ߴ磬���űȣ���ת�Ƕ� �� color/alpha �����ԣ�
 */
public class MyActor extends Actor {

    private TextureRegion region;

    public MyActor(TextureRegion region) {
        super();
        this.region = region;
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    public TextureRegion getRegion() {
        return region;
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (region == null || !isVisible()) {
            return;
        }

        /*
         * �Ȱ� batch ԭ���� color ��������, ��Ϊ batch �Ǵ��ⲿ��������, ��ò�Ҫ�ı���ԭ����״̬,
         * ����������Ҫ�������� batch �� color, �����ȱ�������, �ȵ�ǰ����ִ����ʱ�ٽ� batch ԭ���� color ���û�ȥ��
         */
        Color tempBatchColor = batch.getColor();

        /*
         * ʵ������Ա��û�е����� alpha ����, alpha ��������ɫ(color)������, rgba color �е� a ��ʾ alpha;
         * ��Ա�� alpha ֵ, �����ڵ�(��̨/��Ա��)��Ҳ�� alpha ֵ(parentAlpha)�� ������������Ա�ڵ��в�����������
         * ��������Ļ��, �����������Ƶĵط�, �����ڵ�һ��������֯��Ա, ����ֱ�ӻ����κ�����, ͸���� alpha ֵֻ���ڻ���
         * ʱ�������ֳ���, ���Ը��ڵ��޷������Լ��� alpha ֵ, ��˸��ڵ�Ὣ�Լ��� alpha ֵ(����draw�����еĲ��� parentAlpha)
         * ���ݸ����Լ��������ӽڵ㣬������ֱ�ӻ����������Ա, ����Ա�������� alpha ֵ�ڻ���ʱ�ۺ����֡�
         */

        // ��ȡ��Ա�� color ����
        Color color = getColor();

        /*
         * ���� color/alpha ����, ������Ա�� rgba color ���õ������� batch��
         * ���е� alpha ��Ҫ�����Ա�͸��ڵ�� alpha, ����Ա�� alpha �븸�ڵ�� alpha ���,
         * ���縸�ڵ�� alpha Ϊ 0.5, ��Ա�� alpha Ϊ 0.5, ��ô���յ���ʾЧ������ 0.5 * 0.5 = 0.25
         */
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

        // ���� λ��, ���ź���ת��֧��, �ߴ�, ���ű�, ��ת�Ƕ�
        batch.draw(
                region, 
                getX(), getY(), 
                getOriginX(), getOriginY(), 
                getWidth(), getHeight(), 
                getScaleX(), getScaleY(), 
                getRotation()
        );

        // �� batch ԭ���� color ���û�ȥ
        batch.setColor(tempBatchColor);
    }
}
