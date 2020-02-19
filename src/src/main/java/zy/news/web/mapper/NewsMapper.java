package zy.news.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import zy.news.web.bean.News;

@Repository
public interface NewsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(News record);

    News selectByPrimaryKey(Long id);

    List<News> selectAll();

    int updateByPrimaryKey(News record);
}