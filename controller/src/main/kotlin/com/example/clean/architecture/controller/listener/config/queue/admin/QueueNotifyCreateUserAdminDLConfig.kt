
package com.example.clean.architecture.controller.listener.config.queue.admin

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class QueueNotifyCreateUserAdminDLConfig(@Value("\${queue.notify.create.user.admin.inp.dl}") val queueDeadletter: String,
                                              @Value("\${queue.notify.create.user.admin.routing.key.dl}")val routingKeyDL: String) {

    @Bean
    open fun createQueueNotifyCreateUserAdminDeadLetter() =
        QueueBuilder.durable(queueDeadletter).build()

    @Bean
    open fun createQueueNotifyCreateUserAdminDeadLetterBinding(generalExchange: TopicExchange?) =
        BindingBuilder.bind(createQueueNotifyCreateUserAdminDeadLetter()).to(generalExchange).with(routingKeyDL)

}

