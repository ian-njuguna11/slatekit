package test.apis

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import slatekit.apis.core.Api
import slatekit.apis.ApiServer
import slatekit.apis.ApiSettings
import slatekit.apis.Verb
import slatekit.common.naming.LowerHyphenNamer
import slatekit.common.naming.LowerUnderscoreNamer
import slatekit.results.getOrElse
import test.setup.SampleExtendedApi
import test.setup.SamplePOKOApi


class Api_Naming_Tests : ApiTestsBase() {


    @Test fun can_use_naming_convention_lowerHyphen() {
        val apis = ApiServer(ctx, apis = listOf(Api(SamplePOKOApi::class,
                "app", "SamplePOKO")), settings = ApiSettings(naming = LowerHyphenNamer())
        )
        Assert.assertTrue( apis.getApi("app"   , "sample-poko", "get-time"    ).success)
        Assert.assertTrue(!apis.getApi("app"   , "SamplePOKO" , "getTime"     ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample-poko", "get-counter" ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample-poko", "hello"       ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample-poko", "request"     ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample-poko", "response"    ).success)
        Assert.assertTrue(!apis.getApi("app"   , "sample-poko", "get-email"   ).success)
        Assert.assertTrue(!apis.getApi("app"   , "sample-poko", "get-ssn"     ).success)

        val result = runBlocking {
            apis.call("app", "sample-poko", "get-counter", Verb.Get, mapOf(), mapOf())
        }
        Assert.assertTrue(result.success)
        Assert.assertTrue(result.getOrElse { 0 } == 1)
    }


    @Test fun can_use_naming_convention_lowerUnderscore() {
        val apis = ApiServer(ctx, apis = listOf(Api(SampleExtendedApi::class,
                "app", "SampleExtended", declaredOnly = false)),
                settings = ApiSettings(naming = LowerUnderscoreNamer())
        )
        Assert.assertTrue( apis.getApi("app"   , "sample_extended", "get_seconds" ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample_extended", "get_time"    ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample_extended", "get_counter" ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample_extended", "hello"       ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample_extended", "request"     ).success)
        Assert.assertTrue( apis.getApi("app"   , "sample_extended", "response"    ).success)
        Assert.assertTrue(!apis.getApi("app"   , "sample_extended", "get_email"   ).success)
        Assert.assertTrue(!apis.getApi("app"   , "sample_extended", "get_ssn"     ).success)

        val result = runBlocking {
            apis.call("app", "sample_extended", "get_seconds", Verb.Get, mapOf(), mapOf())
        }
        Assert.assertTrue(result.success)
        Assert.assertTrue(result.getOrElse { 0 } in 0..59)
    }
}
