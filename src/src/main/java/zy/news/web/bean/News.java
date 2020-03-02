package zy.news.web.bean;

import com.google.gson.annotations.Expose;
import lombok.Data;
import maoko.common.StringUtil;
import zy.news.web.zsys.bean.IValidate;
import zy.news.web.zsys.utils.HtmlUtils;

import java.util.Date;
import java.util.List;

@Data
public class News implements IValidate {
    private Long id;
    private Long imageid;
    private String titile;
    private Long ntid;
    private String author;
    private Date publishdate;
    private Byte reviewstatus;
    private String reviewer;
    private Date reviewdate;
    private String reviewComment;
    private Long pageview;
    @Expose(serialize = false, deserialize = false)
    private byte[] content;
    @Expose(serialize = false, deserialize = false)
    private String summary;

    //辅助变量 非数据库变量
    private String newsTName;//新闻类型名称
    private String imageUrl;//图片地址
    private String reviewstatusStr;
    private String contentStr;
    private List<ArticlAnnex> annexes;//附件列表

    public void setContent(byte[] content) {
        this.content = content;
        if (null != content && content.length > 0) {
            this.contentStr = StringUtil.getUtf8Str(content);
        } else {
            this.contentStr = "";
        }
    }

    public void setReviewstatus(Byte reviewstatus) {
        this.reviewstatus = reviewstatus;
        this.reviewstatusStr = reviewstatus.byteValue() == (byte) 0 ? NewsSimple.未通过 : NewsSimple.已通过;
    }

    @Override
    public void validate() throws Exception {
        if (StringUtil.isStringNull(titile)) {
            throw new Exception("新闻标题titile字段为空！");
        }
        if (ntid == null) {
            throw new Exception("新闻类型ntid字段为空！");
        }
        if (StringUtil.isStringNull(contentStr)) {
            throw new Exception("新闻内容contentStr字段为空！");
        }
    }


    /**
     * 将新闻内容转换为数据库blob
     */
    public void convertContent2Blob() throws Exception {
        content = StringUtil.getUtf8Bytes(contentStr);
        summary = HtmlUtils.html2Str(contentStr, 80);
    }
}