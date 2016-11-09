package com.bingdou.core.mapper.live;

import com.bingdou.core.model.Live;
import org.apache.ibatis.annotations.Param;

/**
 * Created by gaoshan on 16-11-8.
 */
public interface ILiveMapper {

    void addLiveIndex(Live live);

    void addLive(@Param("liveId") int liveId,@Param("liveTitle") String liveTitle,
                 @Param("livePicture") String livePicture, @Param("pushStream") String pushStream,
                 @Param("pullStream") String pullStream);

    Live getLiveById(@Param("liveId") int liveId);
}
