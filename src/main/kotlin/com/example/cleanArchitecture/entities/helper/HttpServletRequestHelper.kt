package com.example.cleanArchitecture.entities.helper



import org.springframework.util.LinkedCaseInsensitiveMap
import java.lang.IllegalArgumentException
import java.util.*
import javax.servlet.http.HttpServletRequest

fun HttpServletRequest.getHeaders() : Map<String, List<String>> {
    val headers = LinkedCaseInsensitiveMap<List<String>>(Locale.ENGLISH)
    val names = this.headerNames

    while (names.hasMoreElements()){
        val name = names.nextElement();
        headers[name] = Collections.list(this.getHeaders(name))
    }

    return headers;
}

fun Map<String, List<String>>.getAuthorization(required: Boolean) : String? {

    return when {
        this.containsKey("Authorization") -> {
            return this.getValue("Authorization")[0]
        }
        required -> {
            throw IllegalArgumentException("Authorization obrigatório")
        }
        else -> null
    }

}

fun Map<String, List<String>>.getUserDocument(required: Boolean) : String? {

    return when {
        this.containsKey("userDocument") -> {
            return this.getValue("userDocument")[0]
        }
        required -> {
            throw IllegalArgumentException("Authentication obrigatório")
        }
        else -> null
    }

}

fun Map<String, List<String>>.getDomain(required: Boolean) : String? {

    return when {
        this.containsKey("domain") -> {
            return this.getValue("domain")[0]
        }
        required -> {
            throw IllegalArgumentException("domain obrigatório")
        }
        else -> null
    }

}

fun Map<String, List<String>>.getId(required: Boolean) : Long? {

    return when {
        this.containsKey("id") -> {
            return this.getValue("id")[0].toLong()
        }
        required -> {
            throw IllegalArgumentException("id obrigatório")
        }
        else -> null
    }

}

fun Map<String, List<String>>.getIdAsset(required: Boolean) : Long? {

    return when {
        this.containsKey("idAsset") -> {
            return this.getValue("idAsset")[0].toLong()
        }
        required -> {
            throw IllegalArgumentException("idAsset obrigatório")
        }
        else -> null
    }

}



inline fun Boolean.yes(block: () -> Unit) = also {if (it) block()}
inline fun Boolean.no(block: () -> Unit) = also {if (!it) block()}