package kz.daracademy.service.message;


import kz.daracademy.model.ClientEmailInfo;

public interface ConsumeService {
    void consumeEmailInfo(ClientEmailInfo emailInfo);
}
