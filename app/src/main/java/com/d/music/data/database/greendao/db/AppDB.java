package com.d.music.data.database.greendao.db;

import android.content.Context;

import com.d.music.data.database.greendao.dao.DaoMaster;
import com.d.music.data.database.greendao.dao.DaoSession;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/**
 * AppDB
 */
public abstract class AppDB extends AbstractDB<DaoMaster, DaoSession> {
    public static final int TABLE_COUNT = 25; // 所有表数目：5+20
    public static final int TABLE_INDEX_COUNT = 30;

    public static final int MUSIC = 1; // 歌曲
    public static final int LOCAL_ALL_MUSIC = 2; // 本地歌曲
    public static final int COLLECTION_MUSIC = 3; // 收藏歌曲

    public static final int CUSTOM_LIST = 4; // 自定义列表
    public static final int TRANSFER = 5; // 传输列表

    public static final int CUSTOM_MUSIC_INDEX = 10; // 自定义歌曲 + 0...19 --> 20张表
    public static final int CUSTOM_MUSIC_COUNT = 20; // 自定义歌曲，表数目

    /**
     * SortType
     */
    public static final int ORDER_TYPE_CUSTOM = 0; // 自定义歌曲，排序方式：按自定义排序
    public static final int ORDER_TYPE_NAME = 1; // 自定义歌曲，排序方式：按名称排序
    public static final int ORDER_TYPE_TIME = 2; // 自定义歌曲，排序方式：按时间排序

    protected AbstractDao[] daos;

    protected AppDB(Context context) {
        super(context);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), "dmusic.db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        // GreenDao的Session会将第一次query的结果缓存起来，后面如果调用相同的查询语句则会直接显示缓存的对象
        // 两种解决方式：
        // Type1：每次查询更新的表之前调用一下<daoSession.clear();>清除缓存
        // Type2：初始化时使用无缓存模式
        daoSession = daoMaster.newSession(IdentityScopeType.None);//无缓存模式
        initDaos();
    }

    private void initDaos() {
        daos = new AbstractDao[TABLE_INDEX_COUNT];
        for (int i = 0; i < TABLE_INDEX_COUNT; i++) {
            if (i / 10 == 0) {
                switch (i) {
                    case MUSIC:
                        daos[i] = daoSession.getMusicModelDao();
                        break;
                    case LOCAL_ALL_MUSIC:
                        daos[i] = daoSession.getLocalAllMusicDao();
                        break;
                    case COLLECTION_MUSIC:
                        daos[i] = daoSession.getCollectionMusicDao();
                        break;
                    case CUSTOM_LIST:
                        daos[i] = daoSession.getCustomListModelDao();
                        break;
                    case TRANSFER:
                        daos[i] = daoSession.getTransferModelDao();
                        break;
                }
            } else {
                switch (i - CUSTOM_MUSIC_INDEX) {
                    case 0:
                        daos[i] = daoSession.getCustomMusic0Dao();
                        break;
                    case 1:
                        daos[i] = daoSession.getCustomMusic1Dao();
                        break;
                    case 2:
                        daos[i] = daoSession.getCustomMusic2Dao();
                        break;
                    case 3:
                        daos[i] = daoSession.getCustomMusic3Dao();
                        break;
                    case 4:
                        daos[i] = daoSession.getCustomMusic4Dao();
                        break;
                    case 5:
                        daos[i] = daoSession.getCustomMusic5Dao();
                        break;
                    case 6:
                        daos[i] = daoSession.getCustomMusic6Dao();
                        break;
                    case 7:
                        daos[i] = daoSession.getCustomMusic7Dao();
                        break;
                    case 8:
                        daos[i] = daoSession.getCustomMusic8Dao();
                        break;
                    case 9:
                        daos[i] = daoSession.getCustomMusic9Dao();
                        break;
                    case 10:
                        daos[i] = daoSession.getCustomMusic10Dao();
                        break;
                    case 11:
                        daos[i] = daoSession.getCustomMusic11Dao();
                        break;
                    case 12:
                        daos[i] = daoSession.getCustomMusic12Dao();
                        break;
                    case 13:
                        daos[i] = daoSession.getCustomMusic13Dao();
                        break;
                    case 14:
                        daos[i] = daoSession.getCustomMusic14Dao();
                        break;
                    case 15:
                        daos[i] = daoSession.getCustomMusic15Dao();
                        break;
                    case 16:
                        daos[i] = daoSession.getCustomMusic16Dao();
                        break;
                    case 17:
                        daos[i] = daoSession.getCustomMusic17Dao();
                        break;
                    case 18:
                        daos[i] = daoSession.getCustomMusic18Dao();
                        break;
                    case 19:
                        daos[i] = daoSession.getCustomMusic19Dao();
                        break;
                }
            }
        }
    }
}
