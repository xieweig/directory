package org.grow.batches.infrastucture;

import org.grow.basics.domain.Justice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Author : xieweig
 * Date : 18-7-16
 * <p>
 * Description:
 */
@FeignClient(name = "basic-service", fallback = FeignCatchBasic.class)
public interface FeignBasic {

    @PutMapping("/justice/")
    Justice save(@RequestBody Justice justice);

    @GetMapping("/justice/{justiceCode}")
    Justice getOne(@PathVariable(value ="justiceCode") String justiceCode);
}
