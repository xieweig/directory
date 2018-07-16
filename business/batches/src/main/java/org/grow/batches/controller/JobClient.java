package org.grow.batches.controller;

import org.grow.basics.domain.Justice;
import org.grow.batches.infrastucture.FeignBasic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * Author : xieweig
 * Date : 18-7-16
 * <p>
 * Description:
 */
@RestController
public class JobClient {

    @Resource
    private FeignBasic feignBasic;

    @GetMapping("/batch/{justiceCode}")
    public String getOneAndExport(@PathVariable String justiceCode){
        Justice justice = feignBasic.getOne(justiceCode);
        LocalDateTime temp = justice.getCreateTime().minusDays(40);
        System.err.println(justice);
        justice.setCreateTime(temp);
        System.err.println("==>>>"+justice);
        return justiceCode;
    }

}
