package com.bingdou.cdn.controller;

import com.bingdou.tools.constants.CommonLoggerNameConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by gaoshan on 16-11-14.
 */
@Path("/cdn")
@Component
public class CdnController extends CdnBaseController {

    @POST
    @Path("/{method}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userServer(@Context HttpServletRequest request, @PathParam("method") String method) throws Exception {
        String result = baseDispatch(request, CommonLoggerNameConstants.REQUEST_PARAM_LOG_NAME,method);
        return result;
    }
}
