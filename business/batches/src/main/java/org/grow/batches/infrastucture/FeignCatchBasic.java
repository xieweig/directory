package org.grow.batches.infrastucture;

import org.grow.basics.domain.Justice;
import org.springframework.stereotype.Service;

/**
 * Author : xieweig
 * Date : 18-7-16
 * <p>
 * Description:
 */
@Service
public class FeignCatchBasic implements FeignBasic {
    @Override
    public Justice save(Justice justice) {
        System.err.println("RPC failed save justice");
        return null;
    }

    @Override
    public Justice getOne(String justiceCode) {
        System.err.println("RPC failed getOne justice");
        return null;
    }
}
