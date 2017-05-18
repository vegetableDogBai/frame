package com.bdl.actions;

import com.bdl.domain.Users;
import com.bdl.forms.UserForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bdl.service.UserService;
/**
 * Created by bdl19 on 2017/5/16.
 */
public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        UserForm userform = (UserForm)form;
        System.out.println(userform.getPassword());
        System.out.println(userform.getUsername());
        //if("bdl".equals(userform.getUsername())){
            /*if ("123".equals(userform.getPassword())) {
                request.setAttribute("username", userform.getUsername());
                return mapping.findForward("ok");
            }
        //}
        return mapping.findForward("err");*/
            UserService service = new UserService();
        Users user = new Users();
        user.setUser_name(userform.getUsername());
        user.setUser_pwd(userform.getPassword());

        if (service.checkUser(user)) {
            request.setAttribute("username", userform.getUsername());
            return mapping.findForward("ok");
        }
        return mapping.findForward("err");
    }

   /* @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response) throws Exception {
        UserForm userform = (UserForm)form;
        System.out.println(userform.getPassword());
        System.out.println(userform.getUsername());
        if("bdl".equals(userform.getUsername())){
            if ("123".equals(userform.getPassword())) {
                return mapping.findForward("ok");
            }
        }
        return mapping.findForward("err");
    }*/

}
