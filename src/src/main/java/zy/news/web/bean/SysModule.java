package zy.news.web.bean;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysModule {
    private Long id;

    private String modulename;

    private Long parent;

    @Expose(serialize = false, deserialize = false)
    private Date updatetime;

    private int haschild;//0 不包含儿子 >0：包含儿子

}