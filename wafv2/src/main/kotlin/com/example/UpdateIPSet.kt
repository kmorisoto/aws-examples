package com.example

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.wafv2.Wafv2Client
import software.amazon.awssdk.services.wafv2.model.GetIpSetRequest
import software.amazon.awssdk.services.wafv2.model.Scope
import software.amazon.awssdk.services.wafv2.model.UpdateIpSetRequest

fun main() {
    val client = Wafv2Client.builder()
        .region(Region.AP_NORTHEAST_1)
        .build()

    val ipSetResponse = GetIpSetRequest.builder()
        .name("xxxx")
        .id("yyyy")
        .scope(Scope.REGIONAL)
        .build()
        .let { client.getIPSet(it) }
        .also { println(it) }

    UpdateIpSetRequest.builder()
        .id(ipSetResponse.ipSet().id())
        .name(ipSetResponse.ipSet().name())
        .lockToken(ipSetResponse.lockToken())
        .addresses(ipSetResponse.ipSet().addresses() + "192.168.1.4/32")
        .scope(Scope.REGIONAL).build()
        .let { client.updateIPSet(it) }
        .also { println(it) }
}
