package com.iver.paylogstubservice.service

import io.minio.MinioClient
import io.minio.PutObjectArgs
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service


@Service
class PayLogService(
    private val minioClient: MinioClient,
    @Value(value = "\${minio.bucket.name}")
    private val bucket: String,
) {
    @KafkaListener(topics = ["paylog"])
    fun listenGroupFoo(@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: Long, @Payload message: String) {
        println("Received Message in group foo: $message")
//        s3Client.putObject(bucket, key.toString(), message)
        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket(bucket)
                .`object`(key.toString())
                .stream(message.byteInputStream(), message.toByteArray().size.toLong(), -1)
                .build()
        )
    }
}