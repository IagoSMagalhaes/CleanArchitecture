package com.asset.management.entities.exceptions

import org.springframework.http.HttpStatus

class AssetGetException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class AssetPostException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class AssetPutException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class AssetDeleteException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()

