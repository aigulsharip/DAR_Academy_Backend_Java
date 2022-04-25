package kz.daracademy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {

    Page<PaymentEntity> getPaymentEntitiesBy(Pageable pageable);

    //Page<Product> allProductsSortedByName = productRepository.findAll(Sort.by("name"));


    PaymentEntity getPaymentEntityByPaymentId(String paymentId);

    Page<PaymentEntity> getPaymentEntityByClientId(String clientId, Pageable pageable);

    Page<PaymentEntity> getPaymentEntityByPaymentType(String paymentType, Pageable pageable);

    void deletePaymentEntityByPaymentId(String paymentId);
}
