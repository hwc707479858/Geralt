package com.geralt.script.web.controller;

import com.geralt.script.entity.design.Clue;
import com.geralt.script.entity.design.Role;
import com.geralt.script.entity.design.Script;
import com.geralt.script.service.ClueService;
import com.geralt.script.service.RoleService;
import com.geralt.script.service.ScriptService;
import com.geralt.web.vo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author hewenchao
 * @Date 2022/1/29 9:19
 * @Description
 */
@RestController
@RequestMapping("/script/design")
public class DesignController {

    @Autowired
    private ScriptService scriptService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ClueService clueService;

    @PostMapping("/script")
    public ResponseData saveScript(Script script) {
        scriptService.save(script);
        return ResponseData.newSingleInstance(null);
    }

    @PostMapping("/script/{scriptId}/submit")
    public ResponseData submitScript(@PathVariable int scriptId) {
        scriptService.submit(scriptId);
        return ResponseData.newSingleInstance(null);
    }

    @PostMapping("/clue")
    public ResponseData saveClue(Clue clue) {
        clueService.save(clue);
        return ResponseData.newSingleInstance(null);
    }

    @PostMapping("/role")
    public ResponseData saveRole(Role role) {
        roleService.save(role);
        return ResponseData.newSingleInstance(null);
    }

    @DeleteMapping("/script/{scriptId}")
    public ResponseData deleteScript(@PathVariable int scriptId) {
        scriptService.delete(scriptId);
        return ResponseData.newSingleInstance(null);
    }

    @PostMapping("/role/{roleId}")
    public ResponseData deleteRole(@PathVariable int roleId) {
        roleService.delete(roleId);
        return ResponseData.newSingleInstance(null);
    }

    @PostMapping("/clue/{clueId}")
    public ResponseData deleteClue(@PathVariable int clueId) {
        clueService.delete(clueId);
        return ResponseData.newSingleInstance(null);
    }

    @GetMapping("/script/{scriptId}")
    public ResponseData getScript(@PathVariable int scriptId) {
        scriptService.getById(scriptId);
        return ResponseData.newSingleInstance(null);
    }

    @GetMapping("/role/{roleId}")
    public ResponseData getRole(@PathVariable int roleId) {
        roleService.getById(roleId);
        return ResponseData.newSingleInstance(null);
    }

    @GetMapping("/clue/{clueId}")
    public ResponseData getClue(@PathVariable int clueId) {
        clueService.getById(clueId);
        return ResponseData.newSingleInstance(null);
    }


}
