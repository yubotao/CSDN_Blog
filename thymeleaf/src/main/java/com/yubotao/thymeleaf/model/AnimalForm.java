package com.yubotao.thymeleaf.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 9:55 2018/9/12
 * @Modified By:
 */
public class AnimalForm {

    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    @NotEmpty(message = "动物名：不能为空")
    private String oname;

    @Setter
    @Getter
    @Range(min = 1, message="数量：必须大于0")
    @NotNull(message = "数量：不能为空")
    private int ocount;

    @Setter
    @Getter
    @Size(max = 10, message = "备注：长度不能超过10个字符")
    private String memo;

}
