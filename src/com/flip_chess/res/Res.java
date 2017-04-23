package com.flip_chess.res;

/**
 * 资源常量
 * 
 */
public interface Res {

    public static final float FIX_WORLD_WIDTH = 600;
    public static final float FIX_WORLD_HEIGHT = 1000;

    /**
     * 纹理图集
     */
    public static interface Atlas {

        /** 纹理图集 文件路径 */
        public static final String ATLAS_PATH = "atlas/myatlas.atlas";

        /* 纹理图集中的小图名称 */
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
     * 音效
     */
    public static interface Audios {

        /** 音效资源文件夹路径 */
        public static final String AUDIO_BASE_DIR	= "audio/";

        // 音效资源路径
        public static final String AUDIO_DIE = AUDIO_BASE_DIR + "die.ogg";
        public static final String AUDIO_HIT = AUDIO_BASE_DIR + "hit.ogg";
        public static final String AUDIO_TOUCH = AUDIO_BASE_DIR + "touch.ogg";
        public static final String AUDIO_RESTART = AUDIO_BASE_DIR + "restart.ogg";
        public static final String AUDIO_SCORE = AUDIO_BASE_DIR + "score.ogg";
    }

}




















