package com.sunilos.proj0.ctl;

import java.util.Locale;

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

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.form.UserRegistrationForm;
import com.sunilos.proj0.service.UserServiceInt;

@Controller
public class UserRegistrationCtl extends BaseCtl {
	
	 private static Logger log = Logger.getLogger(LoginCtl.class);
	 
	 /**
	     * Operations
	     */
	 
	  protected static final String OP_SIGNUP = "SignUp";
	  @Autowired
	    private UserServiceInt service;

	    /**
	     * i18n Message source
	     */
	    @Autowired
	    private MessageSource messageSource;
	    
	    /**
	     * Displays SignUp view
	     * 
	     * @param form
	     * @param model
	     * @return
	     */
	    @RequestMapping(value = "/UserRegistration", method = RequestMethod.GET)
	    public String display(@ModelAttribute("form") UserRegistrationForm form,
	            Model model) {
	    	System.out.println("in singup");
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
	    @RequestMapping(value = "/UserRegistration", method = RequestMethod.POST)
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
