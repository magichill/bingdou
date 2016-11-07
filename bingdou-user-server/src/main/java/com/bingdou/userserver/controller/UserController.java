package com.bingdou.userserver.controller;

import com.bingdou.core.helper.BaseController;
import com.bingdou.tools.constants.CommonLoggerNameConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by gaoshan on 16-10-29.
 */
@Path("/user")
@Component
public class UserController extends BaseController{

//    @Autowired
//    private UserBaseService userBaseService;
//
//    @POST
//    @Path("/json")
//    @Produces({MediaType.APPLICATION_JSON})
//    public String json(RegisterRequest registerRequest) throws Exception {
//        return JsonUtil.bean2JsonStr(registerRequest);
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public String home(@Context HttpServletRequest request,@PathParam("id") int id) {
//        String orderId = request.getParameter("orderId");
//        System.out.println(orderId);
//        User user = userBaseService.getDetailById(id);
//        return JsonUtil.bean2JsonStr("你好");
//    }

    @POST
    @Path("/{method}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userServer(@Context HttpServletRequest request,@PathParam("method") String method) throws Exception {
        String result = baseDispatch(request, CommonLoggerNameConstants.REQUEST_PARAM_LOG_NAME,method);
        return result;
    }
}
