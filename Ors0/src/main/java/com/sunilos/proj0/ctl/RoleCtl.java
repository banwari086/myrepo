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
import org.springframework.web.bind.annotation.RequestParam;

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.form.RoleForm;
import com.sunilos.proj0.service.RoleServiceInt;

/**
 * Contains navigation logics for Role and Role List Usecases.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/Role")
public class RoleCtl extends BaseCtl {

    private static Logger log = Logger.getLogger(RoleCtl.class);

    @Autowired
    private RoleServiceInt service;

    /**
     * i18n Message source
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Displays Role view.
     * 
     * @param id
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String display(@RequestParam(required = false) Long id,
            @ModelAttribute("form") RoleForm form, Model model) {

        log.debug("RoleCtl doDisplay() Start");

        if (id != null && id > 0) {
            form.populate(service.findByPK(id));
        }
        return "Role";
    }

    /**
     * Submits Role data.
     * 
     * @param locale
     * @param operation
     * @param form
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Locale locale,
            @RequestParam(required = false) String operation,
            @ModelAttribute("form") @Valid RoleForm form,
            BindingResult bindingResult, Model model) {

        log.debug("RoleCtl doSubmit() Start");

        if (bindingResult.hasErrors()) {
            return "Role";
        }

        try {
            if (OP_SAVE.equalsIgnoreCase(operation)) {

                RoleDTO dto = (RoleDTO) form.getDto();

                if (dto.getId() > 0) {
                    service.update(dto);
                } else {
                    long id = service.add(dto);
                   // form.setId(id);
                }
                String msg = messageSource.getMessage("message.success", null,
                        locale);
                model.addAttribute("success", msg);

            } else if (OP_DELETE.equalsIgnoreCase(operation)) {
                service.delete(form.getId());
                String msg = messageSource.getMessage("message.success", null,
                        locale);
                model.addAttribute("success", msg);
                return "redirect:Role/search";
            }
            else if(OP_CANCEL.equalsIgnoreCase(operation)){
            	 RoleDTO dto = (RoleDTO) form.getDto();
            	if(dto.getId()>0){
            		
            		return "redirect:Role/search";            	
            		}
            	else{
            		return "redirect:Role";
            	}
            }

        } catch (Exception e) {
            model.addAttribute("error", "Critical Issue " + e.getMessage());
        }

        return "Role";
    }

    /**
     * Displays Role List view.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchList(@ModelAttribute("form") RoleForm form, Model model) {
    	int i=service.search(new RoleDTO()).size();
    	int size=0;
    	if(i%5==0){
    		
    		size= i/5;
    		}
    	else{
    		size=(i/5)+1;
    	}
        model.addAttribute("size", size);   	
        model.addAttribute("list",
                service.search(new RoleDTO(), form.getPageNo(), form.getPageSize()));
        return "RoleList";
    }

    /**
     * Submits Role List data.
     * 
     * @param locale
     * @param form
     * @param operation
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = { 
            RequestMethod.POST })
    public String searchList(Locale locale,
            @ModelAttribute("form") RoleForm form,
            @RequestParam(required=false) Integer pageNO,
            @RequestParam(required = false) String operation, Model model) {

        log.debug("in searchList method");

        // Calculate next page number
        int pageNo = form.getPageNo();
        if(pageNO!= null && pageNO>0){
        	pageNo=pageNO;
        	
        }
        
        if (OP_NEXT.equals(operation)) {
        	pageNo++;
        } else if (OP_PREVIOUS.equals(operation)) {
        	pageNo--;
        }
        else if(OP_SEARCH.equals(operation)){
        	pageNo = 1;
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
        RoleDTO dto = (RoleDTO) form.getDto();

        model.addAttribute("list",
                service.search(dto, pageNo, form.getPageSize()));
        int i=service.search(dto).size();
        int size=0;
        if(i%5==0){
        	size=i/5;
        }
        else{
        	size=(i/5)+1;
        }
        if(i==0){
        	String msg=messageSource.getMessage("error.notFound", null, locale);
        	model.addAttribute("error", msg);
        }
        model.addAttribute("size", size);
        return "RoleList";
    }

}

