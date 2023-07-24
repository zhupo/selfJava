package ExceptionProcess;

//import java.io.UnsupportedEncodingException;
//import java.util.logging.Logger;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class LoggerMain {
    //在静态方法中引用Log:
//    static final Log log = LogFactory.getLog(LoggerMain.class);
    //在实例方法中引用Log: 这种方式有个非常大的好处，就是子类可以直接使用该log实例
//    protected final Log log = LogFactory.getLog(getClass());

    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(LoggerMain.class.getName());
//        logger.info("Start process...");
//        try {
//            "".getBytes("invalidCharsetName");
//        } catch (UnsupportedEncodingException e) {
//            logger.severe(e.toString());
//        }
//        logger.info("Process end.");

        //Commons Logging
//        Log log = LogFactory.getLog(LoggerMain.class);
//        log.info("start...");
//        log.warn("end.");
    }
}
