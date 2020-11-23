package com.twy.springbootflowable.controller;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author gongpeng
 * @date 2020/8/26 9:20
 */
@Controller
@RequestMapping(value = "expense")
public class ExpenseController {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;

    /**
     * 添加报销
     *
     * @param userId      用户Id
     * @param money       报销金额
     * @param description 描述
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public String addExpense(String userId, Integer money, String description) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("taskUser", userId);
        map.put("money", money);
        map.put("description", description);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("expense", map);
        return "提交成功.流程Id为：" + processInstance.getId();
    }

    /**
     * 获取审批管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String userId) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
        return tasks.toArray().toString();
    }

    /**
     * 批准
     *
     * @param taskId 任务ID
     */
    @RequestMapping(value = "leaderApply")
    @ResponseBody
    public String apply(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaderResult", true);
        String[] v = {"人事1", "人事2"};
        map.put("assigneeList", Arrays.asList(v));
        taskService.complete(taskId, map);
        return "leaderApply ok!";
    }

    /**
     * 拒绝
     */
    @ResponseBody
    @RequestMapping(value = "leaderReject")
    public String reject(String taskId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaderResult", false);
        taskService.complete(taskId, map);
        return "reject";
    }

    /**
     * 批准
     *
     * @param taskId 任务ID
     */
    @RequestMapping(value = "hrApply")
    @ResponseBody
    public String hrApply(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        Integer money = (Integer) runtimeService.getVariable(task.getProcessInstanceId(), "money");
        if (money > 10000) {
            map.put("hrResult", "经理审批");
        } else {
            map.put("hrResult", "通过");
        }
        taskService.complete(taskId, map);
        return "hrApply ok!";
    }

    /**
     * 拒绝
     */
    @ResponseBody
    @RequestMapping(value = "hrReject")
    public String hrReject(String taskId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("hrResult", "拒绝");
        taskService.complete(taskId, map);
        return "hrReject";
    }

    /**
     * 批准
     *
     * @param taskId 任务ID
     */
    @RequestMapping(value = "managerApply")
    @ResponseBody
    public String managerApply(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaderResult", true);
        taskService.complete(taskId, map);
        return "managerApply ok!";
    }

    /**
     * 拒绝
     */
    @ResponseBody
    @RequestMapping(value = "managerReject")
    public String managerReject(String taskId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaderResult", false);
        taskService.complete(taskId, map);
        return "managerReject";
    }

    /**
     * 生成流程图
     *
     * @param processId 流程部署id
     */
    @GetMapping("/processDiagram")
    public void genProcessDiagram(HttpServletResponse httpServletResponse, String processId) throws Exception {
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();
        //流程走完的不显示图
        if (pi == null) {
            return;
        }

        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processId).list();
        for (Task task : tasks) {
            activityIds.add(task.getTaskDefinitionKey());
        }
        ProcessEngineConfiguration engConf = processEngine.getProcessEngineConfiguration();
        //定义流程画布生成器
        ProcessDiagramGenerator processDiagramGenerator = engConf.getProcessDiagramGenerator();
        InputStream in = processDiagramGenerator.generateDiagram(bpmnModel, "png", activityIds, flows, engConf.getActivityFontName(), engConf.getLabelFontName(), engConf.getAnnotationFontName(), engConf.getClassLoader(), 1.0);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
