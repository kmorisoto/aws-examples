package com.example

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.wafv2.Wafv2Client
import software.amazon.awssdk.services.wafv2.model.ListWebAcLsRequest
import software.amazon.awssdk.services.wafv2.model.Scope

fun main() {
    val client = Wafv2Client.builder()
        .region(Region.AP_NORTHEAST_1)
        .build()
    val request = ListWebAcLsRequest.builder()
        .scope(Scope.REGIONAL)
        .build()
    client.listWebACLs(request).also { println(it) }
}
