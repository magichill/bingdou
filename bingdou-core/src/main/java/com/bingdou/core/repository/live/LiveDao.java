package com.bingdou.core.repository.live;

import com.bingdou.core.mapper.live.ILiveMapper;
import com.bingdou.core.model.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by gaoshan on 16-11-8.
 */
@Repository
public class LiveDao {

    @Autowired
    private ILiveMapper liveMapper;

    public void addLiveIndex(Live live){
        liveMapper.addLiveIndex(live);
    }

    public void addLive(Live live){
        liveMapper.addLive(live.getId(),live.getLiveTitle(),live.getLivePicture(),live.getPushStream(),live.getPullStream());
    }

    public Live getLiveById(int liveId){
        return liveMapper.getLiveById(liveId);
    }
}
