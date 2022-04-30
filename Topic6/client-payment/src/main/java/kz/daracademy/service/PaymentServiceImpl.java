package kz.daracademy.service;

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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

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
}
