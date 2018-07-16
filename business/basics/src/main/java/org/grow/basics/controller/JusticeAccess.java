package org.grow.basics.controller;

import lombok.extern.slf4j.Slf4j;
import org.grow.basics.domain.Justice;
import org.grow.basics.infrastructure.JusticeJpa;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * Author : xieweig
 * Date : 18-7-15
 * <p>
 * Description:
 */
@Slf4j
@RestController
public class JusticeAccess {

    @Resource
    private JusticeJpa justiceJpa;

    @Resource
    private Random random;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @PutMapping("/justice/")
    public Justice save(@RequestBody Justice justice){
        justice.setCreateTime(LocalDateTime.now());
        justice.setJusticeCode((random.nextInt(900)+100)+"");
        log.info("当前服务的端口号是：{}, 名称是：{}", port ,appName );
        return justiceJpa.save(justice);
    }

    @GetMapping("/justice/{justiceCode}")
    public Justice getOne(@PathVariable String  justiceCode){
        log.info("当前服务的端口号是：{}, 名称是：{}", port ,appName );
        return  justiceJpa.findByJusticeCode(justiceCode);
    }
    @GetMapping("/justice")
    public Page<Justice> getAll(){
        Pageable pageable = PageRequest.of(0, 20, Sort
                                            .by(Sort.Direction.DESC,"createTime"));

        return justiceJpa.findAll(pageable);
    }


}
