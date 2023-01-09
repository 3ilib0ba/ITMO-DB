package com.example.demo.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PermissionsConfig {
    public final HashMap<String, String[]> allowedUrls;

    public PermissionsConfig(){
        this.allowedUrls = new HashMap<>();

        //UNAUTHORIZED permissions
        String[] unauthorized = {
                ".*/gen.*"
        };

        //USER permissions
        String[] user = {
                ".*/api/v1/hello.*"
        };

        //ADMIN permissions
        String[] admin = {
                ".*/api/v1/static.*"
        };

        //MANAGER permissions
        String[] manager = {
                ".*/???"
        };

        //INSTRUCTOR permissions
        String[] instructor = {
                ".*/???"
        };

        //Do not edit this part if you are not adding new role
        allowedUrls.put(RoleConfig.UNAUTHORIZED.toString(), unauthorized);
        allowedUrls.put(RoleConfig.ROLE_USER.toString(), user);
        allowedUrls.put(RoleConfig.ROLE_ADMIN.toString(), admin);
        allowedUrls.put(RoleConfig.ROLE_MANAGER.toString(), manager);
        allowedUrls.put(RoleConfig.ROLE_INSTRUCTOR.toString(), instructor);

    }
}
