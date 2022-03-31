package com.example

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.wafv2.Wafv2Client
import software.amazon.awssdk.services.wafv2.model.GetIpSetRequest
import software.amazon.awssdk.services.wafv2.model.Scope

fun main() {
    val client = Wafv2Client.builder()
        .region(Region.AP_NORTHEAST_1)
        .build()

    val request = GetIpSetRequest.builder()
        .id("aaaa")
        .name("bbb")
        .scope(Scope.REGIONAL)
        .build()
    client.getIPSet(request).also { println(it) }
}
