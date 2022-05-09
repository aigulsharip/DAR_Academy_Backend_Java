package kz.daracademy.service.payment;

import kz.daracademy.feign.ClientFeign;
import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PaymentRequest;
import kz.daracademy.model.PaymentResponse;
import kz.daracademy.repository.PaymentEntity;
import kz.daracademy.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClientFeign clientFeign;


    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        paymentRequest.setPaymentId(UUID.randomUUID().toString());
        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);

        paymentEntity = paymentRepository.save(paymentEntity);
        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public PaymentResponse updatePayment(PaymentRequest paymentRequest) {

        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);
        PaymentEntity dbEntity = paymentRepository.getPaymentEntityByPaymentId(paymentRequest.getPaymentId());

        paymentEntity.setPaymentId(dbEntity.getPaymentId());

        paymentEntity = paymentRepository.save(paymentEntity);

        return modelMapper.map(paymentEntity, PaymentResponse.class);

    }


    @Override
    public PaymentResponse getPaymentByPaymentId(String paymentId) {
        PaymentEntity paymentEntity = paymentRepository.getPaymentEntityByPaymentId(paymentId);

        return modelMapper.map(paymentEntity, PaymentResponse.class);

    }

    @Override
    public Page<PaymentResponse> getAllPayments(Pageable pageable) {
        return paymentRepository.getPaymentEntitiesBy(pageable).map(payment -> modelMapper.map(payment, PaymentResponse.class));

    }

    @Override
    public List<PaymentResponse> getAllPaymentsList() {
        return paymentRepository.getPaymentEntitiesBy().stream().map(post -> modelMapper.map(post, PaymentResponse.class)).collect(Collectors.toList());
    }


    @Override
    public Page<PaymentResponse> getPaymentByClientId(String clientId, Pageable pageable) {
        return paymentRepository.getPaymentEntityByClientId(clientId, pageable).map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }

    @Override
    public Page<PaymentResponse> getPaymentByPaymentType(String paymentType, Pageable pageable) {
        return paymentRepository.getPaymentEntityByPaymentType(paymentType, pageable).map(payment -> modelMapper.map(payment, PaymentResponse.class));

    }


    @Override
    public void deletePaymentByPaymentId(String paymentId) {
        paymentRepository.deletePaymentEntityByPaymentId(paymentId);
    }

    @Override
    public ClientEmailInfo prepareEmailData(String clientId) {
        List<PaymentResponse> allPayments = getAllPaymentsList();
        ClientResponse client = clientFeign.getClientById(clientId);
        HashMap<String, Integer> clientPayments = new HashMap<>();
        int sum = 0;
        for (PaymentResponse payment : allPayments) {
            if (payment.getClientId().equals(clientId)) {
                clientPayments.put(payment.getPaymentType(), payment.getAmount());
                sum += payment.getAmount();
            }
        }
        ClientEmailInfo clientEmailInfo = new ClientEmailInfo();
        clientEmailInfo.setTotalPaymentId(UUID.randomUUID().toString());
        clientEmailInfo.setClientName(client.getName() + " " + client.getSurname());
        clientEmailInfo.setClientEmail(client.getEmail());
        clientEmailInfo.setTotalPaymentsAmount(sum);
        clientEmailInfo.setClientPayments(clientPayments);
        return clientEmailInfo;
    }
}
