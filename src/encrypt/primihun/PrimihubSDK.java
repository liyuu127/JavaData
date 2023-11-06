package encrypt.primihun;

import com.primihub.sdk.config.GrpcClientConfig;
import com.primihub.sdk.task.TaskHelper;
import com.primihub.sdk.task.param.TaskPIRParam;
import com.primihub.sdk.task.param.TaskParam;

import java.util.UUID;

/**
 * @author liyu
 * date 2023/11/6 10:27
 * description:
 */


public class PrimihubSDK {
    public static void main(String[] args) {
        // 设置node地址信息
        GrpcClientConfig grpcClientConfig = new GrpcClientConfig();
        grpcClientConfig.setAddress("172.16.1.61");
        grpcClientConfig.setPort(50050);
        // 获取任务帮助类
        try {
            TaskHelper taskHelper = TaskHelper.getInstance(grpcClientConfig);
            // 发起一个PIR任务
            TaskParam<TaskPIRParam> taskParam = new TaskParam<>(new TaskPIRParam());
            // 设置taskID
            taskParam.setTaskId(UUID.randomUUID().toString().replace("-", ""));
            // 设置PIR参数
            taskParam.getTaskContentParam().setServerData("keyword_pir_server_data");
            taskParam.getTaskContentParam().setQueryParam(
                    new String[]{
                            "SXUiwPmLNohCROXPMZIqbnLrfhCtREPzCiDYZaDghlkfGBCTqyPdqnjoaWzyNzBT",
                            "IGvEVefbEuKPEIEoRxBUhGaiJlbaQqoGtXhzLFdrKMdBpqAkJJOqNvomqPBvBKmL",
                            "nLmrRIMTaYRaeMRoGHcTGumAJsgsGjNKvJkEYgEEspLHDUIaxUtqEdowjDWOjsJn"
                    }
            );
            taskParam.getTaskContentParam().setOutputFullFilename("/data/result/pir_sdk_result.csv");
            // 提交任务 - 阻塞持续获取任务状态
            taskHelper.submit(taskParam);
        } catch (Exception e) {
            System.out.println("错误信息:");
            e.printStackTrace();
        }
    }
}

