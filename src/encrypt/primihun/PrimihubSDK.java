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
        // ����node��ַ��Ϣ
        GrpcClientConfig grpcClientConfig = new GrpcClientConfig();
        grpcClientConfig.setAddress("172.16.1.61");
        grpcClientConfig.setPort(50050);
        // ��ȡ���������
        try {
            TaskHelper taskHelper = TaskHelper.getInstance(grpcClientConfig);
            // ����һ��PIR����
            TaskParam<TaskPIRParam> taskParam = new TaskParam<>(new TaskPIRParam());
            // ����taskID
            taskParam.setTaskId(UUID.randomUUID().toString().replace("-", ""));
            // ����PIR����
            taskParam.getTaskContentParam().setServerData("keyword_pir_server_data");
            taskParam.getTaskContentParam().setQueryParam(
                    new String[]{
                            "SXUiwPmLNohCROXPMZIqbnLrfhCtREPzCiDYZaDghlkfGBCTqyPdqnjoaWzyNzBT",
                            "IGvEVefbEuKPEIEoRxBUhGaiJlbaQqoGtXhzLFdrKMdBpqAkJJOqNvomqPBvBKmL",
                            "nLmrRIMTaYRaeMRoGHcTGumAJsgsGjNKvJkEYgEEspLHDUIaxUtqEdowjDWOjsJn"
                    }
            );
            taskParam.getTaskContentParam().setOutputFullFilename("/data/result/pir_sdk_result.csv");
            // �ύ���� - ����������ȡ����״̬
            taskHelper.submit(taskParam);
        } catch (Exception e) {
            System.out.println("������Ϣ:");
            e.printStackTrace();
        }
    }
}

