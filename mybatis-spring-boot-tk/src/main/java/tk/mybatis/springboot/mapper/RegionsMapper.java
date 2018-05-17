package tk.mybatis.springboot.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.springboot.model.Regions;
import tk.mybatis.springboot.model.RegionsMore;

import java.util.List;

public interface RegionsMapper extends BaseMapper<Regions> {
    List listChildrenById(@Param("regionsId") Integer regionsId);

    List<RegionsMore> getListOrderByNLevel();
}