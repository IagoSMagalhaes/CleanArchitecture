package com.example.clean.architecture.ldapRepository.repository.ldapUser.repository

import com.example.clean.architecture.ldapRepository.repository.ldapUser.domain.LdapUser
import org.springframework.data.ldap.repository.LdapRepository
import org.springframework.stereotype.Repository


@Repository
interface LdapUserRepository : LdapRepository<LdapUser> {

    fun findByName(name: String?): LdapUser?

    fun findByNameAndPassword(name: String?, password: String?): LdapUser?

    fun findByNameLikeIgnoreCase(name: String?): List<LdapUser>
}

