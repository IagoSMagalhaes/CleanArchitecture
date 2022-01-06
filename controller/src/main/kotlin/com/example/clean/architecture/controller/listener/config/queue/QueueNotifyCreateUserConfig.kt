
package com.example.clean.architecture.controller.listener.config.queue

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


@Configuration
open class QueueNotifyCreateUserConfig(@Value("\${queue.notify.create.user.inp}") val queue: String,
                                       @Value("\${queue.notify.create.user.inp.dl}") val queueDeadletter: String,
                                       @Value("\${rabbit.exchange}" )val exchange: String,
                                       @Value("\${queue.notify.create.user.routing.key}") val routingKey: String,
                                       @Value("\${queue.notify.create.user.routing.key.dl}") val routingKeyDL: String
) {

    @Bean
    @Primary
    open fun createQueueNotifyCreateUser() = QueueBuilder.durable(queue)
            .withArgument("x-dead-letter-exchange", exchange)
            .withArgument("x-dead-letter-routing-key", routingKeyDL)
            .build()

    @Bean
    open fun binding(queue: Queue?, generalExchange: TopicExchange?) =
        BindingBuilder.bind(queue).to(generalExchange).with(routingKey)

/*
    @Bean
    open fun createQueueNotifyCreateUserDeadLetter() =
        QueueBuilder.durable(queueDeadletter).build()

    @Bean
    open fun createQueueNotifyCreateUserDeadLetterBinding(generalExchange: TopicExchange?) =
        BindingBuilder.bind(createQueueNotifyCreateUserDeadLetter()).to(generalExchange).with(routingKeyDL)

 */

}

