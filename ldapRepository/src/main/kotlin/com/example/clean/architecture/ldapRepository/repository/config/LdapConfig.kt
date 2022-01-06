package com.example.clean.architecture.ldapRepository.repository.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.ldap.repository.config.EnableLdapRepositories


@Configuration
@EnableLdapRepositories(basePackages = ["com.example.clean.architecture.ldapRepository"])
open class LdapConfig() {

}