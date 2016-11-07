package com.bingdou.api.controller;

import com.bingdou.core.helper.BaseController;
import com.bingdou.tools.JsonUtil;
import com.bingdou.tools.constants.CommonLoggerNameConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by gaoshan on 16-11-3.
 */
@Path("/live")
@Component
public class LiveController extends BaseController {

    @GET
    @Path("/{method}")
    @Produces({MediaType.APPLICATION_JSON})
    public String home(@Context HttpServletRequest request, @PathParam("method") String method) throws Exception {
        return baseDispatch(request, CommonLoggerNameConstants.REQUEST_PARAM_LOG_NAME,method);
    }
}
