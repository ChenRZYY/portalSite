package zy.news.web.ui.param;

import maoko.common.exception.OutOfRangeException;

/**
 * @author maoko
 * @date 2020/3/5 16:03
 */
public enum ArticleType {
    /**
     *
     */
    全部(-1),
    /**
     * 新闻
     */
    新闻(0),
    /**
     * 通告
     */
    通告(1),
    培训专栏(2),
    质量专栏(3),
    制度文档(4),
    荣誉中亚(5),
    /**
     * 分享
     */
    知识分享(6),
    文章评论(7);

    private byte value;

    public byte getValue() {
        return value;
    }

    private ArticleType(int value) {
        this.value = (byte) value;
    }

    public static ArticleType getInstance(byte value) throws OutOfRangeException {
        ArticleType articleType = null;
        switch (value) {
            case -1:
                articleType = 全部;
                break;
            case 0:
                articleType = 新闻;
                break;
            case 1:
                articleType = 通告;
                break;
            case 2:
                articleType = 培训专栏;
                break;
            case 3:
                articleType = 质量专栏;
                break;
            case 4:
                articleType = 制度文档;
                break;
            case 5:
                articleType = 荣誉中亚;
                break;
            case 6:
                articleType = 知识分享;
                break;
            case 7:
                articleType = 文章评论;
                break;
            default:
                throw new OutOfRangeException("文章类型范围值错误！");
        }
        return articleType;
    }
}
