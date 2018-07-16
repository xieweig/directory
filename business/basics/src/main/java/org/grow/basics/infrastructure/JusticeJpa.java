package org.grow.basics.infrastructure;

import org.grow.basics.domain.Justice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : xieweig
 * Date : 18-7-15
 * <p>
 * Description:
 */
@Repository
public interface JusticeJpa extends JpaRepository<Justice, Long> {

    Justice findByJusticeCode(String justiceCode);
}
