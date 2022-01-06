
package com.example.clean.architecture.controller.listener.config.other

import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


@Configuration
@EnableRabbit
open class RabbitConfig(@Value("\${rabbit.exchange}") val exchange: String,
                        @Value("\${rabbit.virtualhost}") val virtualHost: String,
                        @Value("\${rabbit.host}") val host: String,
                        @Value("\${rabbit.port}") val port: String,
                        @Value("\${rabbit.username}") val username: String,
                        @Value("\${rabbit.password}") val password: String){

    @Bean
    @Primary
    open fun getConnectionFactory(): ConnectionFactory {

        val factory = CachingConnectionFactory(host, port.toInt())

        factory.virtualHost = virtualHost
        factory.username = username
        factory.setPassword(password)
        factory.rabbitConnectionFactory.isAutomaticRecoveryEnabled = true
        factory.rabbitConnectionFactory.requestedHeartbeat = 15

        return factory

    }


    @Bean
    open fun rabbitTemplate(connectionFactory: ConnectionFactory) : RabbitTemplate {
        val template = RabbitTemplate(connectionFactory)

        template.exchange = exchange

        template.messageConverter = producerJacksonMessageConverter()

        return template
    }

    @Bean
    open fun producerJacksonMessageConverter() = Jackson2JsonMessageConverter()

    @Bean
    open fun generalExchange() = TopicExchange(exchange, true, false)

}