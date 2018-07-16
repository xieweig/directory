package org.grow.basics.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author : xieweig
 * Date : 18-7-15
 * <p>
 * Description:
 */
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Entity
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Justice implements Serializable {

    @Id@GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    private String justiceCode;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public enum Grade{
        os5, os6, java11
    }

    private LocalDateTime createTime;
}
