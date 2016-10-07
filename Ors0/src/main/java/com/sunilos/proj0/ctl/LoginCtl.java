package com.sunilos.proj0.ctl;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.ForgetPasswordForm;
import com.sunilos.proj0.form.LoginForm;
import com.sunilos.proj0.form.UserRegistrationForm;
import com.sunilos.proj0.service.UserServiceInt;

/**
 * Contains navigation logics for Login, Forgot Password and SignUp Usecases.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
public class LoginCtl extends BaseCtl {

    private static Logger log = Logger.getLogger(LoginCtl.class);

    /**
     * Operations
     */
    protected static final String OP_SIGNIN = "SignIn";
    protected static final String OP_SIGNUP = "SignUp";

    @Autowired
    private UserServiceInt service;

    /**
     * i18n Message source
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Displays Login View.
     * 
     * @param form
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String display(@ModelAttribute("form") LoginForm form,
            HttpSession session, Model model) {
        log.debug("Login Submit Started");
        session.invalidate();
        return "Login";
    }

    /**
     * Submits Login data.
     * 
     * @param form
     * @param bindingResult
     * @param session
     * @return
     */
    @RequestMapping(value = "/Login", method = { RequestMethod.POST })
    public String submit(Locale locale,
            @ModelAttribute("form") @Valid LoginForm form,
            BindingResult bindingResult, HttpSession session, Model model) {

        log.debug("Login Submit Started");

        System.out.println("result Fail :" + bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            return "Login";
        }

        if (OP_SIGNIN.equalsIgnoreCase(form.getOperation())) {

            UserDTO dto = new UserDTO();
            dto.setLogin(form.getEmailId());
            dto.setPassword(form.getPassword());

            dto = service.authenticate(dto);
            if (dto != null) {
                session.setAttribute("user", dto);
                model.addAttribute("message", "Welcome :" + form.getEmailId());

                return "redirect:/Welcome";
            } else {
                // Get error messages for message respurce
                String msg = messageSource.getMessage("login.error", null,
                        locale);
                model.addAttribute("error", msg);
            }
        }

        log.debug("Login Submit End");
        return "Login";

    }

    /**
     * Displays ForgetPAssword View
     * 
     * @param form
     * @param model
     * @return
     */

    @RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
    public String display(@ModelAttribute("form") ForgetPasswordForm form,
            Model model) {
        return "ForgetPassword";
    }

    /**
     * Submits ForgetPassword data.
     * 
     * @param locale
     * @param form
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
    public String submit(Locale locale,
            @ModelAttribute("form") @Valid ForgetPasswordForm form,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "ForgetPassword";
        }

        UserDTO dto = service.findByLogin(form.getLogin());

        if (dto == null) {
            String msg = messageSource.getMessage("forgetpass.error", null,
                    locale);
            model.addAttribute("error", msg);
        }
        service.forgetPassword(form.getLogin());
		model.addAttribute("success",
		        "Password has been sent to your registered Email ID!!");

        return "ForgetPassword";
    }

    /**
     * Displays SignUp view
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public String display(@ModelAttribute("form") UserRegistrationForm form,
            Model model) {
    	
        return "UserRegistration";
    }

    /**
     * Submits SignUp data
     * 
     * @param locale
     * @param form
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
    public String submit(Locale locale,
            @ModelAttribute("form") @Valid UserRegistrationForm form,
            BindingResult bindingResult, Model model) {
    	  System.out.println("in signup");
        if (bindingResult.hasErrors()) {
            return "UserRegistration";
        }
        if(OP_SIGNUP.equalsIgnoreCase(form.getOperation())){
        	  System.out.println("in signup");
        
        UserDTO dto = (UserDTO) form.getDto();
        // Default Role is Student
        dto.setRoleId((long) RoleDTO.STUDENT);
        service.registerUser(dto);
        
        }
        return "redirect:Login";
    }
}
