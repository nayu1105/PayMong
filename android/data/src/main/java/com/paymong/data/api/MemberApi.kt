package com.paymong.data.api

import com.paymong.data.model.request.AddMongReqDto
import com.paymong.data.model.response.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MemberApi {
    @GET("/member/info")
    suspend fun findMember() : Response<FindMemberResDto>

    @GET("/member/paypoint/list")
    suspend fun pointList() : Response<List<PointInfoResDto>>

    @GET("/member/things")
    suspend fun findThings() : Response<List<ThingsResDto>>

    @GET("/member/things/addable")
    suspend fun addFindThings() : Response<List<AddThingsResDto>>
}