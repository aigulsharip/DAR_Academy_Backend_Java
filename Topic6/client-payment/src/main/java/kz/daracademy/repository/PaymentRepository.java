package kz.daracademy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {

    List<PaymentEntity> getPaymentEntitiesBy();

    PaymentEntity getPaymentEntityByPaymentId(String paymentId);

    Page<PaymentEntity> getPaymentEntityByClientId(String clientId, Pageable pageable);

    Page<PaymentEntity> getPaymentEntityByPostId(String postId, Pageable pageable);

    void deletePaymentEntityByPaymentId(String paymentId);
}
