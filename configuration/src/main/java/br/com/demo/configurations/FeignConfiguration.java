/*
 * Copyright (c) Audsat, Todos os direitos reservados
 *
 * Este arquivo e uma propriedade confidencial da Audsat. Nenhuma parte do mesmo
 * pode ser copiada, reproduzida, impressa ou transmitida por qualquer meio sem
 * autorizacao expressa e por escrito de um representante legal da Audsat.
 *
 * All rights reserved
 *
 * This file is a confidential property of Audsat. No part of this file may be
 * reproduced or copied in any form or by any means without written permission
 * from an authorized person from Audsat.
 *
 */
package br.com.audsat.configurations;

import feign.Logger.Level;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author marcelok
 *
 */
@Configuration
@EnableFeignClients(basePackages = { "br.com.audsat.asg.core.client" })
class FeignConfiguration {

	@Bean
	Level feignLoggerLevel(final @Value("${feign.loglevel:BASIC}") String level) {
		try {
			return Level.valueOf(level.toUpperCase());
		} catch(Exception e) {
			return Level.BASIC;
		}
	}

}
