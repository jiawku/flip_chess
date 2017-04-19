package com.libgdx.libGDX_test;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AfterAction;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * ��Ϸ��������������
 */
public class MainGame extends ApplicationAdapter {

    private static final String TAG = MainGame.class.getSimpleName();

    // �ӿ�����Ŀ��ͳʹ�� 480 * 800, ��ͳһʹ����չ�ӿڣ�StretchViewport��
    public static final float WORLD_WIDTH = 480;
    public static final float WORLD_HEIGHT = 800;

    private Texture texture;

    private Stage stage;

    private MyActor actor;

    @Override
    public void create() {
        // ���� log �������
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        // ��������, badlogic.jpg ͼƬ�Ŀ��Ϊ 256 * 256
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));

        // ʹ����չ�ӿڣ�StretchViewport��������̨
        stage = new Stage(new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT));

        // ������Ա
        actor = new MyActor(new TextureRegion(texture));

        // �����Ա����̨
        stage.addActor(actor);


        /*
         * ������ʾ
         * 
         * ��Щʱ������ҪƵ��ʹ��, ���ÿ��Ҫʹ�ö��������´���һ������, ���������ܡ�
         * LibGDX �жԶ���ʵ��ʹ���˶���ؽ����˻���, ʹ����һ����������󲻻�ֱ����ϵͳ���ն���, 
         * ���Ƿŵ�������л�����´��ظ�ʹ�á�LibGDX �����ж���ʵ���Ļ�ȡ��ͨ�� Actions ������
         * �еľ�̬������ȡ��Actions ��ʵ���˶���ػ��棩��
         * 
         * ��ȡ��һ����������󸽼�����Ա����ִ�У�addAction��, ����ִ�������Զ�����Ա�����Ƴ�
         * ���Żض�����л��档 ��Ȼ�ڶ�����û��ִ����ʱҲ������;�ֶ��Ƴ���removeAction����
         * 
         * �����ÿһ�ֶ�������ʾ���ڵ���������, ��˳�����Ӧ���Է�����ע�ͽ��в��ԣ���һ��������
         * ע�ͺ����Ҫע�͵��������Է���, ����������ͬʱִ�п�����Ч������
         */

        // 1. �ƶ�����
        testMoveToAction();

        // 2. �ƶ���������ԣ�
        // testMoveByAction();

        // 3. ��ת����
        // testRotateToAction();

        // 4. ��ת��������ԣ�
        // testRotateByAction();

        // 5. ���Ŷ���
        // testScaleToAction();

        // 6. ���Ŷ�������ԣ�
        // testScaleByAction();

        // 7. �ߴ�ı䶯��
        // testSizeToAction();

        // 8. �ߴ�ı䶯������ԣ�
        // testSizeByAction();

        // 9. ͸���ȶ���
        // testAlphaAction();

        // 10. ���ж���
        // testParallelAction();

        // 11. ˳��������������ʱ��������ʾ��
        // testSequenceAction();

        // 12. �ظ�����
        // testRepeatAction();

        // 13. Runnable ����
        // testRunnableAction();

        // 14. After ����
        // testAfterAction();
    }

    /**
     * 1. �ƶ�����
     */
    private void testMoveToAction() {
        // ������Ա��ʼ��λ��
        actor.setPosition(0, 0);

        // ��ȡһ�� MoveTo ����, 3 �����ƶ��� (150, 300) ��λ��
        MoveToAction action = Actions.moveTo(150, 300, 3.0F);

        // ��������������Ա����, ִ�ж���
        actor.addAction(action);

        /*
         * ����ִ��ԭ���鿴 Actor ����Ӧ Action ��Դ�룩: 
         * 
         * ʵ���϶�����ӵ���Ա���ϵĺ�, ��������ŵ�һ��������, Ȼ���ڸ�����Ա�߼��� actor.act()�����б�����Ŷ���������,
         * ��ÿһ����������ʱ�䲽 delta �ı���Ա��Ӧ��״̬����ֵ��Ȼ���ڻ�����Ա�� actor.draw() �����л�����Աʱʹ���µ�
         * ״̬����ֵ����, ����һ֡���, ���Ե���Ա�������������ˡ�
         */
    }

    /**
     * 2. �ƶ���������ԣ�
     */
    private void testMoveByAction() {
        // ��Ա��ʼ��λ��������ʾ����̨����
        actor.setPosition(
                actor.getStage().getWidth() / 2 - actor.getWidth() / 2, 
                actor.getStage().getHeight() / 2 - actor.getHeight() / 2
        );

        // ��ȡһ�� MoveBy ����
        // 2 ����, ����Ա��ԭλ�û�����, ˮƽ�����ƶ� 100, ��ֱ�����ƶ� -200
        MoveByAction action = Actions.moveBy(100, -200, 2.0F);

        // ��������������Ա����, ִ�ж���
        actor.addAction(action);
    }

    /**
     * 3. ��ת����
     */
    private void testRotateToAction() {
        // ������Ա��ʾ����̨����
        actor.setPosition(
                actor.getStage().getWidth() / 2 - actor.getWidth() / 2, 
                actor.getStage().getHeight() / 2 - actor.getHeight() / 2
        );

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // ������Ա�ĳ�ʼ�Ƕ�Ϊ -90 �ȣ���ʱ��Ϊ��, ˳ʱ��Ϊ����
        actor.setRotation(-90);

        // ��ȡһ�� RotateTo ����, 2 ���� ��ԭ�Ƕ� ��ת�� -270 �ȣ����սǶ�Ϊ -270 �ȣ�
        RotateToAction action = Actions.rotateTo(-270, 2.0F);

        // ִ�ж���
        actor.addAction(action);
    }

    /**
     * 4. ��ת��������ԣ�
     */
    private void testRotateByAction() {
        // ������Ա��ʾ����̨����
        actor.setPosition(
                actor.getStage().getWidth() / 2 - actor.getWidth() / 2, 
                actor.getStage().getHeight() / 2 - actor.getHeight() / 2
        );

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // ������Ա�ĳ�ʼ�Ƕ�Ϊ -90 �ȣ���ʱ��Ϊ��, ˳ʱ��Ϊ����
        actor.setRotation(-90);

        // ��ȡһ�� RotateBy ����, 2 ���� ��ԭ�ǶȻ���������45�ȣ����սǶ�Ϊ -90 + 45 = -45 �ȣ�
        RotateByAction action = Actions.rotateBy(45, 2.0F);

        // ִ�ж���
        actor.addAction(action);
    }

    /**
     * 5. ���Ŷ���
     */
    private void testScaleToAction() {
        // ������Ա��ʾ����̨����
        actor.setPosition(
                actor.getStage().getWidth() / 2 - actor.getWidth() / 2, 
                actor.getStage().getHeight() / 2 - actor.getHeight() / 2
        );

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // ������Ա��ˮƽ����ֱ�����ʼ���űȷֱ�Ϊ 0.5 �� 2.0
        actor.setScale(0.5F, 2.0F);

        // ��ȡһ�� ScaleTo ����, 2 ����ˮƽ����ֱ�������űȴ� ԭ���ű� �ֱ����ŵ� 1.0 �� 1.0,
        // ����ˮƽ����ֱ�������űȷֱ�Ϊ 1.0 �� 1.0
        ScaleToAction action = Actions.scaleTo(1.0F, 1.0F, 2.0F);

        // ִ�ж���
        actor.addAction(action);
    }

    /**
     * 6. ���Ŷ�������ԣ�
     */
    private void testScaleByAction() {
        // ������Ա��ʾ����̨����
        actor.setPosition(
                actor.getStage().getWidth() / 2 - actor.getWidth() / 2, 
                actor.getStage().getHeight() / 2 - actor.getHeight() / 2
        );

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // ������Ա��ˮƽ����ֱ�����ʼ���űȷֱ�Ϊ 0.5 �� 0.5
        actor.setScale(0.5F, 0.5F);

        // ��ȡһ�� ScaleBy ����, 2 ����ˮƽ����ֱ�������űȴ� ԭ���űȻ����� �ֱ���� 0.5 �� 0.5��������ʾ����, ������ʾ���٣�,
        // ScaleBy �Ƕ�ԭ����ֵ��������ֵ���, ����ˮƽ����ֱ��������űȾ�Ϊ: 0.5 + 0.5 = 1.0
        ScaleByAction action = Actions.scaleBy(0.5F, 0.5F, 2.0F);

        // ִ�ж���
        actor.addAction(action);
    }

    /**
     * 7. �ߴ�ı䶯��
     */
    private void testSizeToAction() {
        // ������Ա��ʼ��λ��
        actor.setPosition(0, 0);

        // ��ȡһ�� SizeTo ����, 2 ���ڴ�ԭ���ߴ�䵽��Ϊ 150, ��Ϊ 300 �����տ��Ϊ 150 * 300��
        SizeToAction action = Actions.sizeTo(150, 300, 2.0F);

        // ִ�ж���
        actor.addAction(action);

        /*
         * Scale �� Size ������:
         * 
         * Size ָ������Ա�Ŀ��, Scale ָ������Ա����� Size �����űȡ�
         * ��� Scale Ϊ 0.5, 
         * �� Size ��Ϊ 256 ʱ, ���Ƶ���Ļ�ϵĴ�С��Ϊ 256 * 0.5 = 128,
         * �� Size ��Ϊ 512 ʱ, ���Ƶ���Ļ�ϵĴ�С��Ϊ 512 * 0.5 = 256,
         */
    }

    /**
     * 8. �ߴ�ı䶯������ԣ�
     */
    private void testSizeByAction() {
        // ������Ա��ʼ��λ��
        actor.setPosition(0, 0);

        // ��Ա��ʼ���ΪͼƬ�Ŀ�� 256 * 256

        // ��ȡһ�� SizeTo ����, 2 ���ڿ�ߴ�ԭ�������Ϸֱ�����150, 300 
        // ���տ��Ϊ: 256 + 150 = 406
        // ���ո߶�Ϊ: 256 + 300 = 556
        SizeByAction action = Actions.sizeBy(150, 300, 2.0F);

        // ִ�ж���
        actor.addAction(action);
    }

    /**
     * 9. ͸���ȶ���
     */
    private void testAlphaAction() {
        // ������Ա��ʼ��λ��
        actor.setPosition(0, 0);

        // ������Ա��ʼ alpha ֵΪ 1����ȫ��͸��, Ĭ�Ͼ���Ϊ 1��
        actor.getColor().a = 1.0F;

        // ��ȡһ�� Alpha ����, 5 ���� alpha ��Ϊ 0����ȫ͸����
        AlphaAction action = Actions.alpha(0.0F, 5.0F);

        // ִ�ж���
        actor.addAction(action);
    }

    /**
     * 10. ���ж���: ͬʱ �ƶ�, ����, ��ת
     */
    private void testParallelAction() {
        // ������Ա��ʼ��״̬
        actor.setPosition(0, 0);
        actor.setScale(0.5F, 0.5F);
        actor.setRotation(0);

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // �ƶ�����
        MoveToAction moveTo = Actions.moveTo(150, 500, 3.0F);

        // ���Ŷ���
        ScaleToAction scaleTo = Actions.scaleTo(1.0F, 1.0F, 3.0F);

        // ��ת����
        RotateByAction rotateBy = Actions.rotateBy(360.0F, 3.0F);

        // ���ж���, ���� moveTo, scaleTo, rotateBy
        ParallelAction parallelAction = Actions.parallel(moveTo, scaleTo, rotateBy);

        // ִ�в��ж���
        actor.addAction(parallelAction);
    }

    /**
     * 11. ˳��������������ʱ��������ʾ��: ����ʱ, Ȼ���ƶ�, ����ת������
     */
    private void testSequenceAction() {
        // ������Ա��ʼ��״̬
        actor.setPosition(0, 0);
        actor.setScale(1.0F, 1.0F);
        actor.setRotation(0);

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // 1. ��ʱ����, ��ʱ 3 ��
        DelayAction delay = Actions.delay(3.0F);

        // 2. �ƶ�����
        MoveToAction moveTo = Actions.moveTo(150, 500, 3.0F);

        // 3. ���ж���, ���� ���� �� ��ת ��������
        ParallelAction parallel = Actions.parallel(
                Actions.scaleTo(0.5F, 0.5F, 3.0F), 
                Actions.rotateBy(360.0F, 3.0F)
        );

        // ˳����, ���� delay, moveTo, parallel
        SequenceAction sequenceAction = Actions.sequence(delay, moveTo, parallel);

        // ִ��˳����
        actor.addAction(sequenceAction);
    }

    /**
     * 12. �ظ�����: �ظ� ��С, �Ŵ�
     */
    private void testRepeatAction() {
        // ������Ա��ʾ����̨����
        actor.setPosition(
                actor.getStage().getWidth() / 2 - actor.getWidth() / 2, 
                actor.getStage().getHeight() / 2 - actor.getHeight() / 2
        );

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // ������Ա��ʼ���ű�
        actor.setScale(1.0F, 1.0F);

        // ˳����: ����С�� 0.5, �ٷŴ� 1.0
        SequenceAction sequence = Actions.sequence(
                Actions.scaleTo(0.5F, 0.5F, 2.0F), 
                Actions.scaleTo(1.0F, 1.0F, 2.0F)
        );

        // �ظ�����: �ظ�ִ�� sequence
        RepeatAction repeatAction = Actions.forever(sequence);

        // ִ���ظ�����
        actor.addAction(repeatAction);
    }

    /**
     * 13. Runnable ����: �ʵ�ʱ��ִ���Լ��Ĵ���, ��˳����һ��ʹ�ÿ����ڼ���ĳ�����������
     */
    private void testRunnableAction() {
        // ������Ա��ʼ��״̬
        actor.setPosition(0, 0);

        // �ƶ�����
        MoveToAction moveTo = Actions.moveTo(150, 300, 3.0F);

        // Runnable ����
        RunnableAction runnable = Actions.run(new Runnable() {
            @Override
            public void run() {
                // ��ӡһ�� log ��ʾ������ִ��
                Gdx.app.log(TAG, "The runnable action has been running.");
            }
        });

        // ˳����: �� moveTo ����ִ�����ִ�� runnable ����
        SequenceAction sequence = Actions.sequence(moveTo, runnable);

        // ִ��˳����
        actor.addAction(sequence);
    }

    /**
     * 14. After ����: �����ڼ�����Ա������ִ�����
     */
    private void testAfterAction() {
        // ������Ա��ʼ��״̬
        actor.setPosition(0, 0);
        actor.setRotation(0);

        // ���ź���ת֧�����õ���Ա����
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);

        // �ƶ�����, �ƶ� 3 ��
        MoveToAction moveTo = Actions.moveTo(150, 300, 3.0F);

        // ��ת����, ��ת 2 ��
        RotateByAction rotateBy = Actions.rotateBy(360.0F, 2.0F);

        // Runnable ����
        RunnableAction runnable = Actions.run(new Runnable() {
            @Override
            public void run() {
                // ��ӡһ�� log ��ʾ������ִ��
                Gdx.app.log(TAG, "��Ա���������ж������Ѿ�ִ������");
            }
        });

        // After ����, ����һ�� runnable ����
        AfterAction afterAction = Actions.after(runnable);

        // ͬʱ��Ӷ����������Ա: ������ִ�� moveTo �� rotateBy, ��ִ�����ִ�� afterAction
        actor.addAction(moveTo);
        actor.addAction(rotateBy);
        actor.addAction(afterAction);
    }

    @Override
    public void render() {
        // ʹ�õ���ɫ����
        Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // ������̨�߼�
        stage.act();
        // ������̨
        stage.draw();
    }

    @Override
    public void dispose() {
        // �ͷ���Դ
        if (stage != null) {
            stage.dispose();
        }
        if (texture != null) {
            texture.dispose();
        }
    }

}