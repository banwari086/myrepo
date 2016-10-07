package com.sunilos.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.RoleDTO;

/**
 * Contains Role form elements and their declarative input validations.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class RoleForm extends BaseForm {

    @NotEmpty
    private String roleName;

    @NotEmpty
    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public BaseDTO getDto() {

        RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setName(roleName);
        dto.setDescription(roleDescription);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

        return dto;
    }

    @Override
    public void populate(BaseDTO bDto) {

        if (bDto == null) {
            return;
        }

        RoleDTO dto = (RoleDTO) bDto;

        id = dto.getId();
        roleName = dto.getName();
        roleDescription = dto.getDescription();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        createdDatetime = dto.getCreatedDatetime().getTime();
        modifiedDatetime = dto.getModifiedDatetime().getTime();
    }

}

