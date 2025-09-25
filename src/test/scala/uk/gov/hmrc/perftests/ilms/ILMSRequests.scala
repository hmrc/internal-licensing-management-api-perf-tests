/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.ilms

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmrc.performance.api.APIRequest
import uk.gov.hmrc.performance.api.configuration.APIConfiguration.apiGatewayBaseUrl

object ILMSRequests extends APIRequest {

  val route: String = "/customs/licence"

  private val httpRequestHeaders = Map(
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Authorization" -> "Bearer #{privilegedToken}",
    "Content-type"-> "application/json"
  )

  val createNewLicense = apiRequest(
    http("Create a New license")
      .put(s"$apiGatewayBaseUrl$route/#{licenseRef}")
      .body(StringBody("{}"))
      .headers(httpRequestHeaders)
      .check(status.is("#{status}"))
  )
}
