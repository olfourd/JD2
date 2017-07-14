package by.itacademy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import static org.apache.log4j.Logger.getLogger;

@Aspect
public class MyLogger {

    @Pointcut("@within(by.itacademy.aspect.Loggable)")
    public void log() {
    }

    @Around("log()")
    public Object logMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        final Class<?> targetClass = joinPoint.getTarget().getClass();
        final Logger logger = getLogger(targetClass);
        try {
            final String className = targetClass.getSimpleName();
            logger.debug(getPreMessage(joinPoint, className));
            final StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            final Object retVal = joinPoint.proceed();
            stopWatch.stop();
            logger.debug(getPostMessage(joinPoint, className, stopWatch.getTotalTimeMillis()));
            return retVal;
        } catch (final Throwable ex) {
            logger.error(getErrorMessage(ex), ex);
            throw ex;
        }
    }

    private static String getPreMessage(final JoinPoint joinPoint, final String className) {
        final StringBuilder builder = new StringBuilder()
                .append("Entered in ").append(className).append(".")
                .append(joinPoint.getSignature().getName())
                .append("(");
        appendTo(builder, joinPoint);
        return builder
                .append(")")
                .toString();
    }

    private static String getPostMessage(final JoinPoint joinPoint, final String className, final long millis) {
        return "Exit from " + className + "." +
                joinPoint.getSignature().getName() +
                "(..); Execution time: " +
                millis +
                " ms;";
    }

    private static String getErrorMessage(final Throwable ex) {
        return ex.getMessage();
    }

    private static void appendTo(final StringBuilder builder, final JoinPoint joinPoint) {
        final Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (i != 0) {
                builder.append(", ");
            }
            builder.append(args[i]);
        }
    }

}
