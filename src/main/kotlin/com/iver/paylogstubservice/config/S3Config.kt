//package com.iver.paylogstubservice.config
//
//import com.amazonaws.auth.AWSCredentials
//import com.amazonaws.auth.AWSStaticCredentialsProvider
//import com.amazonaws.auth.BasicAWSCredentials
//import com.amazonaws.client.builder.AwsClientBuilder
//import com.amazonaws.regions.Regions
//import com.amazonaws.services.s3.AmazonS3
//import com.amazonaws.services.s3.AmazonS3ClientBuilder
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class S3Config(
//    @Value("\${spring.minio.access-key}")
//    private val accessKey: String,
//    @Value("\${spring.minio.secret-key}")
//    private val secretKey: String,
//    @Value("\${spring.minio.url}")
//    private val url: String,
//) {
//    @Bean
//    fun getS3Credentials(): AWSCredentials {
//        return BasicAWSCredentials(accessKey, secretKey)
//    }
//
//    @Bean
//    fun getS3Client(): AmazonS3 {
//        return AmazonS3ClientBuilder
//            .standard()
//            .withCredentials(AWSStaticCredentialsProvider(getS3Credentials()))
//            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(url, Regions.US_EAST_1.name))
////            .withRegion(Regions.US_EAST_2)
//            .build()
//    }
//}