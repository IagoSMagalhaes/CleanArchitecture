package com.example.cleanArchitecture.swagger


/*
import com.google.common.base.Strings.isNullOrEmpty
import org.springframework.stereotype.Service

import javax.servlet.ServletContext


@Service
class RelativePathProvider(val servletContext: ServletContext,
                                val root: String? = "/") : AbstractPathProvider() {

    override fun applicationPath() =
        (if (isNullOrEmpty(servletContext.contextPath)) root else servletContext.contextPath)!!

    override fun getDocumentationPath() = root


}


 */