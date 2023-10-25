package com.trodix.casbinserver;

import org.casbin.jcasbin.main.Enforcer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class EnforcerTest {

    @Autowired
    private Enforcer enforcer;

    // ===== Permissions =====

    @Test
    void getAllSubjects() {
        // p, v0
        List<String> subjects = enforcer.getAllSubjects();
        for(String sub : subjects) {
            System.out.println(sub);
        }
    }

    @Test
    void getAllObjects() {
        // p, v1
        List<String> objects = enforcer.getAllObjects();
        for(String obj : objects) {
            System.out.println(obj);
        }
    }

    @Test
    void getAllActions() {
        // p, v2
        List<String> actions = enforcer.getAllActions();
        for(String act : actions) {
            System.out.println(act);
        }
    }

    @Test
    void getDirectPermissionsForUserOrGroup() {
        // do g, v1 has p, v0 ?
        List<String> roles = enforcer.getAllRoles();
        for (String role : roles) {
            List<List<String>> permissionsForUser = enforcer.getPermissionsForUser(role);
            System.out.println("#" + role + "#" + " has direct permission (p) " + permissionsForUser);
        }
    }

    @Test
    void getImplicitPermissionsForUserOrGroup() {
        // do g, v1 has implicitly p, v0 ?
        List<String> roles = enforcer.getAllRoles();
        for (String role : roles) {
            List<List<String>> permissionsForUser = enforcer.getImplicitPermissionsForUser(role);
            System.out.println("#" + role + "#" + " has implicit permission (p) " + permissionsForUser);
        }
    }

    @Test
    void getXXX() {
        // do g, v0 has implicitly p, v0 ?
//        List<String> roles = enforcer.getAllRoles();
//        for (String role : roles) {
//            List<List<String>> permissionsForUser = enforcer.getImplicitPermissionsForUser(role);
//            System.out.println("#" + role + "#" + " has implicit permission (p) " + permissionsForUser);
//        }
    }

    // ===== Groups =====

    @Test
    void getGroupingPolicy() {
        // g, v0, v1
        List<List<String>> gPolicyAll = enforcer.getGroupingPolicy();
        for (List<String> gPolicies : gPolicyAll) {
            System.out.println(gPolicies);
        }
    }

    @Test
    void getAllRoles() {
        // g, v1
        List<String> roles = enforcer.getAllRoles();
        for(String role : roles) {
            System.out.println(role);
        }
    }

    @Test
    void getRolesForEachRole() {
        // g, v1a => g, v0(v1a), v1b
        List<String> subjects = enforcer.getAllRoles();
        for(String sub : subjects) {
            List<String> roles = enforcer.getImplicitRolesForUser(sub);
            System.out.println(sub + " has roles [" + String.join(",", roles) + "]");
        }
    }

}
