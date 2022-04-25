package kz.daracademy.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "client-payment")
public class PaymentEntity {

    @Id
    @Field(type = FieldType.Keyword)
    private String paymentId;

    @Field(type = FieldType.Keyword)
    private String clientId;

    @Field(type = FieldType.Text)
    private String paymentType;

    @Field(type = FieldType.Integer)
    private Integer amount;


    @Field(type = FieldType.Date)
    private LocalDate paymentDate;







}
