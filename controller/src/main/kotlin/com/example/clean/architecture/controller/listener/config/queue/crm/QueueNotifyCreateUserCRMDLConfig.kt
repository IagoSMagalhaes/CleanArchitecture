
package com.example.clean.architecture.controller.listener.config.queue.crm
/*
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class QueueNotifyCreateUserCRMDLConfig(@Value("\${queue.notify.create.user.crm.inp.dl}") val queueDeadletter: String,
                                            @Value("\${queue.notify.create.user.crm.routing.key.dl}")val routingKeyDL: String) {

    @Bean
    open fun createQueueNotifyCreateUserCRMDeadLetter() =
        QueueBuilder.durable(queueDeadletter).build()

    @Bean
    open fun createQueueNotifyCreateUserCRMDeadLetterBinding(generalExchange: TopicExchange?) =
        BindingBuilder.bind(createQueueNotifyCreateUserCRMDeadLetter()).to(generalExchange).with(routingKeyDL)

}


 */
