package tk.mybatis.springboot.service;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.springboot.mapper.RegionsMapper;
import tk.mybatis.springboot.model.RegionsMore;

import java.util.List;

@Service
@Transactional
public class RegionsService {

    @Autowired
    private RegionsMapper regionsMapper;

    public String getListByNLevel(){
        List<RegionsMore> regions = regionsMapper.getListOrderByNLevel();

        RegionsMore root = new RegionsMore(0,0,"root", "nothing");

        for(RegionsMore region : regions){
            root.add(region);
        }

        JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根
        return obj.toString();
    }

}
