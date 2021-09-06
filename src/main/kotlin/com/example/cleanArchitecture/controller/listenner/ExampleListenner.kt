package com.example.cleanArchitecture.controller.listenner

import org.springframework.stereotype.Component


@Component
class ExampleListenner() {
//class ExampleListenner(rabbiteTemplate: RabbitTemplate) {



	//@RabbitListenner(queue = [""], concurrency = "")
	fun onMessage(){


		//rabbiteTemplate.convertAndSend("queue", body)

	}



}