package zy.news.web.service;

import zy.news.web.zsys.bean.Page;
import zy.news.web.bean.OrgTrain;
import zy.news.web.zsys.bean.PageValuesResult;

/**
 * @author maoko
 * @date 2020/3/7 9:51
 */
public interface IOrgTrain extends IBaseService<OrgTrain> {

    PageValuesResult<OrgTrain> getOrgTains(Page page) throws Exception;
}
