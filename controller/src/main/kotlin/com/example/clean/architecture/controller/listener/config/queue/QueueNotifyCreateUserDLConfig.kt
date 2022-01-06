
package com.example.clean.architecture.controller.listener.config.queue

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class QueueNotifyCreateUserDLConfig(@Value("\${queue.notify.create.user.inp.dl}") val queueDeadletter: String,
                                         @Value("\${queue.notify.create.user.routing.key.dl}")val routingKeyDL: String) {

    @Bean
    open fun createQueueNotifyCreateUserDeadLetter() =
        QueueBuilder.durable(queueDeadletter).build()

    @Bean
    open fun createQueueNotifyCreateUserDeadLetterBinding(generalExchange: TopicExchange?) =
        BindingBuilder.bind(createQueueNotifyCreateUserDeadLetter()).to(generalExchange).with(routingKeyDL)

}

