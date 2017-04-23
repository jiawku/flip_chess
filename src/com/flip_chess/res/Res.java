package com.flip_chess.res;

/**
 * ��Դ����
 * 
 */
public interface Res {

    public static final float FIX_WORLD_WIDTH = 600;
    public static final float FIX_WORLD_HEIGHT = 1000;

    /**
     * ����ͼ��
     */
    public static interface Atlas {

        /** ����ͼ�� �ļ�·�� */
        public static final String ATLAS_PATH = "atlas/myatlas.atlas";

        /* ����ͼ���е�Сͼ���� */
        public static final String IMAGE_BACK	= "back";
        public static final String IMAGE_RED_BIN	= "red_bin";
        public static final String IMAGE_RED_JIANG	= "red_jiang";
        public static final String IMAGE_RED_JU	= "red_ju";
        public static final String IMAGE_RED_MA	= "red_ma";
        public static final String IMAGE_RED_PAO	= "red_pao";
        public static final String IMAGE_RED_SHI	= "red_shi";
        public static final String IMAGE_RED_XIANG	= "red_xiang";
        public static final String IMAGE_BLACK_BIN	= "black_bin";
        public static final String IMAGE_BLACK_JIANG	= "black_jiang";
        public static final String IMAGE_BLACK_JU	= "black_ju";
        public static final String IMAGE_BLACK_MA	= "black_ma";
        public static final String IMAGE_BLACK_PAO	= "black_pao";
        public static final String IMAGE_BLACK_SHI	= "black_shi";
        public static final String IMAGE_BLACK_XIANG	= "black_xiang";
    }

    /**
     * ��Ч
     */
    public static interface Audios {

        /** ��Ч��Դ�ļ���·�� */
        public static final String AUDIO_BASE_DIR	= "audio/";

        // ��Ч��Դ·��
        public static final String AUDIO_DIE = AUDIO_BASE_DIR + "die.ogg";
        public static final String AUDIO_HIT = AUDIO_BASE_DIR + "hit.ogg";
        public static final String AUDIO_TOUCH = AUDIO_BASE_DIR + "touch.ogg";
        public static final String AUDIO_RESTART = AUDIO_BASE_DIR + "restart.ogg";
        public static final String AUDIO_SCORE = AUDIO_BASE_DIR + "score.ogg";
    }

}




















