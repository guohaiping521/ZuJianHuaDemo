package reactivex.io.router_annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})////表明此注解可以用在域上(还没用过，)
@Retention(RetentionPolicy.CLASS)
public @interface Autowired {
    /**
     * @return param's name or service name.
     */
    String name() default "";

    /**
     * <em>primitive java type check will be ignore</em>
     * check the result of DI, if inject failed, the value of
     * the field will be null, if required, output log
     *
     * @return true for required,false otherwise
     */
    boolean required() default false;

    /**
     * throw exception when the required field is null after inject.
     * <p>
     * It can help developer find most data delivering bugs when developing.
     * but not suggest to open this function after release.
     * <p>
     * I suggest to define a Constant maintained manually
     * <p>
     * only activated when required = true and throwOnNull = true.
     *
     * @return true if throwing exception when null is required, false otherwise
     */
    boolean throwOnNull() default false;

    /**
     * @return field description
     */
    String desc() default "none desc.";
}
