package com.sunilos.proj0.ctl;

import java.util.List;
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
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.form.ChangePasswordForm;
import com.sunilos.proj0.form.MyProfileForm;
import com.sunilos.proj0.form.UserForm;
import com.sunilos.proj0.service.RoleServiceInt;
import com.sunilos.proj0.service.UserServiceInt;
import com.sunilos.proj0.util.Util;

/**
 * Contains navigation logics for User, UserList, MyProfile, ChangePassword,
 * usecases.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl extends BaseCtl {

    private static Logger log = Logger.getLogger(UserCtl.class);

    @Autowired
    private UserServiceInt service;

    @Autowired
    private RoleServiceInt roleService;

    /**
     * i18n Message source
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Preload Rols List
     */
    @Override
    public void preload(Model model) {
        // Preload Role List
        List list = roleService.search(new RoleDTO());
        model.addAttribute("roleList", list);
    }

    /**
     * Displayes User view.
     * 
     * @param id
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String display(@RequestParam(required = false) Long id,
            @ModelAttribute("form") UserForm form, Model model) {

        log.debug("UserCtl doDisplay Start " + id);

        if (id != null && id > 0) {
            UserDTO dto = service.findByPK(id);
            form.populate(dto);
        }

        return "User";

    }

    /**
     * Submits User data.
     * 
     * @param locale
     * @param operation
     * @param form
     * @param bindingResult
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Locale locale, @RequestParam String operation,
            @ModelAttribute("form") @Valid UserForm form,
            BindingResult bindingResult, HttpSession session, Model model) {

        log.debug("UserCtl doSubmit Start ");

        if (bindingResult.hasErrors()) {
            return "User";
        }

        try {
            if (OP_SAVE.equals(operation)) {

                UserDTO dto = (UserDTO) form.getDto();

                if (dto.getId() > 0) {
                    service.update(dto);
                } else {
                   Long id= service.add(dto);
                   form.setId(id);
                }
                String msg = messageSource.getMessage("message.success", null,
                        locale);
                model.addAttribute("success", msg);
                return "User";
            } else if (OP_DELETE.equals(operation)) {

                service.delete(form.getId());
                return "redirect:Student/search";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Critical Issue " + e.getMessage());
        }

        return "User";
    }

    /**
     * Displays User List
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchList(@ModelAttribute("form") UserForm form, Model model) {
        model.addAttribute("list",
                service.search(new UserDTO(), form.getPageNo(), form.getPageSize()));
        return "UserList";
    }

    /**
     * Submits User List data.
     * 
     * @param locale
     * @param form
     * @param operation
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchList(Locale locale,
            @ModelAttribute("form") UserForm form,
            @RequestParam(required = false) String operation, Model model) {

        log.debug("in searchList method");

        // Calculate next page number
        int pageNo = form.getPageNo();

        if (OP_NEXT.equals(operation)) {
            pageNo++;
        } else if (OP_PREVIOUS.equals(operation)) {
            pageNo--;
        }

        pageNo = (pageNo < 1) ? 1 : pageNo;

        form.setPageNo(pageNo);

        if (OP_DELETE.equals(operation) && form.getIds() != null) {
            for (long id : form.getIds()) {
                service.delete(id);
            }

            String msg = messageSource.getMessage("message.success", null,
                    locale);
            model.addAttribute("success", msg);

        }

        // Get search attributes
        UserDTO dto = (UserDTO) form.getDto();
         System.out.println("role id is"+dto.getRoleId());
        model.addAttribute("list",
                service.search(dto, pageNo, form.getPageSize()));
        return "UserList";

    }

    /**
     * Displays MyProfile View
     * 
     * @param session
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String displayProfile(HttpSession session,
            @ModelAttribute("form") MyProfileForm form, Model model) {
        log.debug("MyProfileCtl start");
        UserDTO dto = (UserDTO) session.getAttribute("user");
        form.populate(dto);
        return "MyProfile";
    }

    /**
     * Submits MyProfile
     * 
     * @param session
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String submitProfile(Locale locale,
            @ModelAttribute("form") @Valid MyProfileForm form,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "MyProfile";
        }

        UserDTO dto = service.findByPK(form.getId());
        dto.setFirstName(form.getFirstName());
        dto.setLastName(form.getLastName());
        dto.setDob(Util.getDate(form.getDob()));
        dto.setMobileNo(form.getMobileNo());
        dto.setGender(form.getGender());

        try {
			service.update(dto);
		} catch (DuplicateRecordException e) {
			
			e.printStackTrace();
		}
        String msg = messageSource.getMessage("message.success", null, locale);
        model.addAttribute("success", msg);

        return "MyProfile";
    }

    /**
     * Displays Change Password view.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public String displayChangePassword(
            @ModelAttribute("form") ChangePasswordForm form, Model model) {
        log.debug("displayChangePassword start");
        return "ChangePassword";
    }

    /**
     * Submits Change Password data.
     * 
     * @param session
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String submitChangePassword(Locale locale, HttpSession session,
            @ModelAttribute("form") @Valid ChangePasswordForm form,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "ChangePassword";
        }

        // New password and confirm password must be same
        if (form.getNewPassword().equals(form.getConfirmPassword())) {

            UserDTO dto = (UserDTO) session.getAttribute("user");
            dto = service.findByPK(dto.getId());

            // Old password must be valid
            if (dto.getPassword().equals(form.getOldPassword())) {
                // Change Password
                dto.setPassword(form.getNewPassword());
                try {
					service.update(dto);
				} catch (DuplicateRecordException e) {
					
					e.printStackTrace();
				}
                String msg = messageSource.getMessage("message.success", null,
                        locale);
                model.addAttribute("success", msg);
            } else {
                model.addAttribute("error", "Old Password is not valid.");
            }
        } else {
            model.addAttribute("error",
                    "New Password and Confirm Password does not match");
        }
        return "ChangePassword";
    }

}
