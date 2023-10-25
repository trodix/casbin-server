package com.trodix.casbinserver.api.v1;

import com.trodix.casbinserver.api.v1.requests.*;
import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/authorization")
@RequiredArgsConstructor
public class AuthorizationApi {

    private final Enforcer enforcer;

    @PostMapping("enforce")
    public boolean enforce(@RequestBody EnforceRequest request) {
        return enforcer.enforce(request.rvals());
    }

    @PostMapping("remove-policy")
    public boolean removePolicy(@RequestBody RemovePolicyRequest request) {
        return enforcer.removePolicy(request.params());
    }

    @PostMapping("remove-filtered-policy")
    public boolean removeFilteredPolicy(@RequestBody RemoveFilteredPolicyRequest request) {
        return enforcer.removeFilteredPolicy(request.fieldIndex(), request.fieldValues());
    }

    @PostMapping("remove-filtered-grouping-policy")
    public boolean removeFilteredGroupingPolicy(@RequestBody RemoveFilteredGroupingPolicyRequest request) {
        return enforcer.removeFilteredGroupingPolicy(request.fieldIndex(), request.fieldValues());
    }

    @PostMapping("add-policy")
    public boolean addPolicy(@RequestBody AddPolicyRequest request) {
        return enforcer.addPolicy(request.params());
    }

    @PostMapping("has-policy")
    public boolean hasPolicy(@RequestBody HasPolicyRequest request) {
        return enforcer.hasPolicy(request.params());
    }

    @PostMapping("has-grouping-policy")
    public boolean hasGroupingPolicy(@RequestBody HasGroupingPolicyRequest request) {
        return enforcer.hasGroupingPolicy(request.params());
    }

    @PostMapping("add-named-policy")
    public boolean addNamedPolicy(@RequestBody AddNamedPolicyRequest request) {
        return enforcer.addNamedPolicy(request.ptype(), request.params());
    }

    @PostMapping("add-named-grouping-policy")
    public boolean addNamedGroupingPolicy(@RequestBody AddNamedGroupingPolicyRequest request) {
        return enforcer.addNamedGroupingPolicy(request.ptype(), request.params());
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
    public List<List<String>> getImplicitPermissionsForUser(@RequestBody GetImplicitPermissionsForUserRequest request) {
        return enforcer.getImplicitPermissionsForUser(request.user(), request.domain());
    }

    @PostMapping("get-roles-for-user")
    public List<String> getRolesForUser(@RequestBody GetRolesForUserRequest request) {
        return enforcer.getRolesForUser(request.name());
    }

    @PostMapping("add-role-for-user")
    public boolean addRoleForUser(@RequestBody AddRoleForUserRequest request) {
        return enforcer.addRoleForUser(request.user(), request.role());
    }

    @PostMapping("get-permitted-actions")
    public Set<String> getPermittedActions(@RequestBody GetPermittedActionsRequest request) {
        return enforcer.getPermittedActions(request.subject(), request.object());
    }

    @GetMapping("get-grouping-policy")
    public List<List<String>> getGroupingPolicy() {
        return enforcer.getGroupingPolicy();
    }

}
