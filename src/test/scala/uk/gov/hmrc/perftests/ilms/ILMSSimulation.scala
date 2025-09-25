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
import io.gatling.core.Predef.exec

import uk.gov.hmrc.performance.api.APIPerformanceTest
import uk.gov.hmrc.performance.api.configuration.Configuration
import uk.gov.hmrc.performance.api.models.PerformanceTest
import uk.gov.hmrc.perftests.ilms.ILMSRequests._

class ILMSSimulation extends APIPerformanceTest with Configuration {

  override val performanceTest: PerformanceTest = PerformanceTest(
    title = s"Create Licenses",
    apis = exec(createNewLicense),
    scope = "write:internal-licensing-management",
    feeder = "data/createLicenses.csv"
  )
  runSimulation(privileged = true)
}
