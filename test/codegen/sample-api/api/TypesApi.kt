/**
    This code is auto-generated by the Slate Kit Api Component.
    @author  : Slate Kit
    @about   : Client side API for Types
    @desc    : sample to test features of Slate Kit APIs
    @route   : samples/types
    @version : 1.0.0
    @software: Visit www.slatekit.com for more info
*/
package blendlife.clientapis.apis

import blendlife.clientapis.dtos.*
import slatekit.common.HttpRPC
import slatekit.http.ApiBase
import slatekit.http.converters.*
import slatekit.results.Outcome

import java.util.Date;

class TypesApi(http: HttpRPC) : ApiBase(http) {

    constructor() : this(HttpRPC())

    	/**
    info about this api
	The tag parameter is used as a "correlation id"
    */
    fun about(
        
		tag:String,
        callback: (Outcome<About>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<About>(About::class.java)

        // execute
        http.post(
            "samples/types/about",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test post
	The tag parameter is used as a "correlation id"
    */
    fun create1(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.post(
            "samples/types/create1",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test delete
	The tag parameter is used as a "correlation id"
    */
    fun delete1(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.delete(
            "samples/types/delete1",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    File download
	The tag parameter is used as a "correlation id"
    */
    fun download(
        text : String,
		tag:String,
        callback: (Outcome<Doc>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "text" to text
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<Doc>(Doc::class.java)

        // execute
        http.post(
            "samples/types/download",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    get current value of counter
	The tag parameter is used as a "correlation id"
    */
    fun getCounter(
        
		tag:String,
        callback: (Outcome<Int>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<Int>(Int::class.java)

        // execute
        http.get(
            "samples/types/getCounter",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test movie list
	The tag parameter is used as a "correlation id"
    */
    fun getRecent(
        category : String,
		tag:String,
        callback: (Outcome<List<SampleMovie>>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            "category" to category.toString()
        )

        // data
        val postData = mapOf<String, Any>(
            
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterList<SampleMovie>(SampleMovie::class.java)

        // execute
        http.get(
            "samples/types/getRecent",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    accepts supplied basic data types from send
	The tag parameter is used as a "correlation id"
    */
    fun hello(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.post(
            "samples/types/hello",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    increments a simple counter
	The tag parameter is used as a "correlation id"
    */
    fun increment(
        
		tag:String,
        callback: (Outcome<Int>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<Int>(Int::class.java)

        // execute
        http.post(
            "samples/types/increment",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    accepts supplied basic data types from send
	The tag parameter is used as a "correlation id"
    */
    fun inputs(
        name : String,
		isActive : Boolean,
		age : Short,
		dept : Int,
		account : Long,
		average : Float,
		salary : Double,
		date : ZonedDateTime,
		tag:String,
        callback: (Outcome<Map<String, Any>>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "name" to name,
			"isActive" to isActive,
			"age" to age,
			"dept" to dept,
			"account" to account,
			"average" to average,
			"salary" to salary,
			"date" to date
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterMap<String, Any>(String::class.java, Any::class.java)

        // execute
        http.post(
            "samples/types/inputs",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test patch
	The tag parameter is used as a "correlation id"
    */
    fun lists(
        movies : SampleMovie,
		tag:String,
        callback: (Outcome<List<SampleMovie>>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "movies" to movies
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterList<SampleMovie>(SampleMovie::class.java)

        // execute
        http.post(
            "samples/types/lists",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test patch
	The tag parameter is used as a "correlation id"
    */
    fun patch1(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.patch(
            "samples/types/patch1",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test post
	The tag parameter is used as a "correlation id"
    */
    fun process1(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.post(
            "samples/types/process1",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test access to send
	The tag parameter is used as a "correlation id"
    */
    fun request(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.post(
            "samples/types/request",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test wrapped result
	The tag parameter is used as a "correlation id"
    */
    fun response(
        category : String,
		tag:String,
        callback: (Outcome<SampleMovie>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "category" to category
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<SampleMovie>(SampleMovie::class.java)

        // execute
        http.post(
            "samples/types/response",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    test put
	The tag parameter is used as a "correlation id"
    */
    fun update1(
        greeting : String,
		tag:String,
        callback: (Outcome<String>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "greeting" to greeting
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterSingle<String>(String::class.java)

        // execute
        http.put(
            "samples/types/update1",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }
	/**
    File upload
	The tag parameter is used as a "correlation id"
    */
    fun upload(
        file : Doc,
		tag:String,
        callback: (Outcome<Map<String, String>>) -> Unit
    )
    {
        // headers
        val headers = mapOf<String,String>()

        // query string
        val queryParams = mapOf<String,String>(
            
        )

        // data
        val postData = mapOf<String, Any>(
            "file" to file
        )
        val json = Conversions.convertMapToJson(postData)

        // convert
        val converter = ConverterMap<String, String>(String::class.java, String::class.java)

        // execute
        http.post(
            "samples/types/upload",
            headers = headers,
            queryParams = queryParams,
            body = HttpRPC.Body.JsonContent(json),
            callback = { respond(it, converter, callback ) }
        )
    }

}