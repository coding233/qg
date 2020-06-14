package com.qg.service.impl;
import com.qg.mapper.QgTradeMapper;
import com.qg.pojo.QgTrade;
import com.qg.service.QgTradeService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Component
@Service(interfaceClass=QgTradeService.class)
public class QgTradeServiceImpl implements QgTradeService {

    @Resource
    private QgTradeMapper qgTradeMapper;
    private QgTrade qgTrade;

    @Override
    public QgTrade getQgTradeById(String id)throws Exception{
        return qgTradeMapper.getQgTradeById(id);
    }

    @Override
    public List<QgTrade> getQgTradeListByMap(Map<String,Object> param)throws Exception{
        return qgTradeMapper.getQgTradeListByMap(param);
    }

    @Override
    public Integer getQgTradeCountByMap(Map<String,Object> param)throws Exception{
        return qgTradeMapper.getQgTradeCountByMap(param);
    }

    @Override
    public Integer qdtxAddQgTrade(QgTrade qgTrade)throws Exception{
        this.qgTrade = qgTrade;
        //qgTrade.setCreatedTime(new Date());
            return qgTradeMapper.insertQgTrade(qgTrade);
    }

    @Override
    public Integer qdtxModifyQgTrade(QgTrade qgTrade)throws Exception{
        //qgTrade.setUpdatedTime(new Date());
        return qgTradeMapper.updateQgTrade(qgTrade);
    }

    @Override
    public Integer qdtxDeleteQgTradeById(String id)throws Exception{
        return qgTradeMapper.deleteQgTradeById(id);
    }

    @Override
    public Integer qdtxBatchDeleteQgTrade(String ids)throws Exception{
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return qgTradeMapper.batchDeleteQgTrade(param);
    }
}
