package reactivex.io.router_annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})//用于定义在注解的上边，表明该注解可以使用的范围  (表明此注解可以用在类或接口上)
@Retention(RetentionPolicy.CLASS)
public @interface RouteNode {
    /**
     * path of one route
     */
    String path();
    /**
     * The priority of route.
     */
    int priority() default -1;

    /**
     * description of the activity, user for gen route table
     */
    String desc() default "";
}
