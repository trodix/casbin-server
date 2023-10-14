package com.trodix.casbinserver.api.controllers;

import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/authorization")
@RequiredArgsConstructor
public class AuthorizationController {

    private final Enforcer enforcer;

    @PostMapping("enforce")
    public boolean enforce(@RequestBody String[] rvals) {
        return enforcer.enforce(rvals);
    }

    @DeleteMapping("remove-policy")
    public boolean removePolicy(@RequestBody String[] params) {
        return enforcer.removePolicy(params);
    }

    @DeleteMapping("remove-filtered-policy")
    public boolean removeFilteredPolicy(@RequestBody int fieldIndex, String[] fieldValues) {
        return enforcer.removeFilteredPolicy(fieldIndex, fieldValues);
    }

    @DeleteMapping("remove-filtered-grouping-policy")
    public boolean removeFilteredGroupingPolicy(@RequestBody int fieldIndex, String[] fieldValues) {
        return enforcer.removeFilteredGroupingPolicy(fieldIndex, fieldValues);
    }

    @PostMapping("add-policy")
    public boolean addPolicy(@RequestBody String[] params) {
        return enforcer.addPolicy(params);
    }

    @PostMapping("has-policy")
    public boolean hasPolicy(@RequestBody String[] params) {
        return enforcer.hasPolicy(params);
    }

    @PostMapping("has-grouping-policy")
    public boolean hasGroupingPolicy(@RequestBody String[] params) {
        return enforcer.hasGroupingPolicy(params);
    }

    @PostMapping("add-named-policy")
    public boolean addNamedPolicy(@RequestBody String ptype, String[] params) {
        return enforcer.addNamedPolicy(ptype, params);
    }

    @PostMapping("add-named-grouping-policy")
    public boolean addNamedGroupingPolicy(@RequestBody String ptype, String[] params) {
        return enforcer.addNamedGroupingPolicy(ptype, params);
    }

    @GetMapping("get-all-actions")
    public List<String> getAllActions() {
        return enforcer.getAllActions();
    }

    @GetMapping("get-all-objects")
    public List<String> getAllObjects() {
        return enforcer.getAllObjects();
    }

    @GetMapping("get-all-roles")
    public List<String> getAllRoles() {
        return enforcer.getAllRoles();
    }

    @GetMapping("get-all-subjects")
    public List<String> getAllSubjects() {
        return enforcer.getAllSubjects();
    }

    @PostMapping("get-implicit-permissions-for-user")
    public List<List<String>> getImplicitPermissionsForUser(@RequestBody String user, String[] domain) {
        return enforcer.getImplicitPermissionsForUser(user, domain);
    }

    @PostMapping("get-roles-for-user")
    public List<String> getRolesForUser(@RequestBody String name) {
        return enforcer.getRolesForUser(name);
    }

    @PostMapping("get-permitted-actions")
    public Set<String> getPermittedActions(@RequestBody String subject, String object) {
        return enforcer.getPermittedActions(subject, object);
    }

}
