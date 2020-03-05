package zy.news.web.bean;

import lombok.Data;
import maoko.common.StringUtil;
import maoko.common.exception.OutOfRangeException;
import zy.news.web.ui.param.ArticleType;
import zy.news.web.ui.param.ReviewStatus;
import zy.news.web.zsys.bean.IValidate;

import java.util.Date;

@Data
public class Comment implements IValidate {
    public static final String 匿名 = "匿名";

    private Long id;
    private Long articleid;
    private Byte articletype;
    private String content;
    private String author;
    private String ip;
    private Date publishtime;
    private Byte reviewstatus;
    private String reviewer;
    private Date reviewdate;
    private String reviewcomment;

    //append
    private String reviewstatusStr;


    public void setReviewstatus(Byte reviewstatus) throws OutOfRangeException {
        this.reviewstatus = reviewstatus;
        this.reviewstatusStr = ReviewStatus.getInstance(reviewstatus.byteValue()).toString();
    }

    @Override
    public void validate() throws Exception {

        if (articleid == null) {
            throw new Exception("文章articleid为空！");
        }
        if (StringUtil.isStrNullOrWhiteSpace(content)) {
            throw new Exception("评论内容content为空！");
        }

        if (StringUtil.isStrNullOrWhiteSpace(ip)) {
            throw new Exception("来源ip为空！");
        }
        if (articletype == null) {
            throw new Exception("文章类型articletype为空！");
        }
        //检查文章类型返回
        ArticleType.getInstance(articletype);
    }
}